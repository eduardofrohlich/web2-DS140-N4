import { Component, OnInit } from '@angular/core';
import { Roupa, Pedido, RoupasPedido, Cliente, Endereco } from 'src/app/shared';
import { PedidoOnlineService } from '../services/pedido-online.service';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs';
import { Router } from '@angular/router';

const httpHeader = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Component({
  selector: 'app-pedido-online',
  templateUrl: './pedido-online.component.html',
  styleUrls: ['./pedido-online.component.css']
})
export class PedidoOnlineComponent implements OnInit{
  roupas! : RoupasPedido[];
  pedido! : Pedido;

  constructor(private http : HttpClient, private pedidoService : PedidoOnlineService, private router : Router){}

  ngOnInit(): void {
    let listaRoupas : Roupa[];
    listaRoupas = [];

    this.roupas = [];

    // Pegar o id do cliente logado
    this.pedido = new Pedido(0, new Cliente(1, new Endereco(), '', '', '', '', ''), [], '', 0, 0, '');

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

  aprovar()
  {
    if(this.pedidoService.setRoupasPedido(this.roupas, this.pedido))
    {
      if(confirm("Tem certeza que quer aprovar o pedido?"))
      {
          // Observable
          this.http.post<Pedido>("http://localhost:8080/pedidos", this.pedido, httpHeader).subscribe((novoPedido) => {
            this.pedido.idPedido = novoPedido.idPedido;
            confirm(`Pedido gerado com sucesso!\nId do pedido: ${this.pedido.idPedido}`);
          });
          // Observable
      }
    }
    else
      confirm("Por favor adicione uma roupa ao pedido!");
  }

  rejeitar()
  {
    if(this.pedidoService.setRoupasPedido(this.roupas, this.pedido))
    {
      if(confirm("Tem certeza que quer rejeitar o pedido?"))
      {
        // Observable
        this.http.post<Pedido>("http://localhost:8080/pedidos", this.pedido, httpHeader).subscribe((novoPedido) => {
          this.pedido.idPedido = novoPedido.idPedido;

          this.http.put<Pedido>(`http://localhost:8080/pedidos/${this.pedido.idPedido}/estado/rejeitado`, this.pedido, httpHeader).subscribe((pedidoAtualizado => {
            this.pedido.estado = pedidoAtualizado.estado;
            confirm(`Pedido rejeitado com sucesso!\nId do pedido: ${this.pedido.idPedido}\nEstado: ${this.pedido.estado}`);
          }));
        });
        // Observable
      }
    }
    else
      confirm("Por favor adicione uma roupa ao pedido!");
  }
}
