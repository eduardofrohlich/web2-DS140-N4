import { Component, OnInit } from '@angular/core';
import { Roupa, Pedido, RoupasPedido, Cliente } from 'src/app/shared';
import { PedidoOnlineService } from '../services/pedido-online.service';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs';

@Component({
  selector: 'app-pedido-online',
  templateUrl: './pedido-online.component.html',
  styleUrls: ['./pedido-online.component.css']
})
export class PedidoOnlineComponent implements OnInit{
  roupas! : RoupasPedido[];
  pedido! : Pedido;

  constructor(private http : HttpClient, private pedidoService : PedidoOnlineService){}

  ngOnInit(): void {
    let listaRoupas : Roupa[];
    listaRoupas = [];

    this.roupas = [];
    this.pedido = new Pedido(0, new Cliente(), [], '', 0, 0, '');
    
    // Observable
    this.http.get<{[key : string] : Roupa}>("http://localhost:8080/roupas").pipe(
      map((roupaJSON) => {
        for(const key in roupaJSON)
        {
          listaRoupas.push({...roupaJSON[key]});
        }
      })
    ).subscribe(() => {
     for(let i = 0; i < listaRoupas.length; i++)
     {
      let roupa : RoupasPedido = new RoupasPedido(new Roupa(0, '', 0, 0, ''), 0, 0);
      roupa.roupa = listaRoupas.at(i);

      this.roupas.push(roupa);
     }
    });
    // Observable
  }

  adicionar(roupa : RoupasPedido)
  {
    this.pedidoService.adicionar(roupa, this.pedido);
    this.pedidoService.atualizarPrazoPedido(this.roupas, this.pedido);
  }

  remover(roupa : RoupasPedido)
  {
    this.pedidoService.remover(roupa, this.pedido);
    this.pedidoService.atualizarPrazoPedido(this.roupas, this.pedido);
  }
}
