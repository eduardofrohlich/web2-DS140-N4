import { Component, OnInit } from '@angular/core';
import { Pedido } from 'src/app/shared';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';

const httpHeader = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Component({
  selector: 'app-tela-inicial-func',
  templateUrl: './tela-inicial-func.component.html',
  styleUrls: ['./tela-inicial-func.component.css']
})
export class TelaInicialFuncComponent implements OnInit{
  pedidos! : Pedido[];

  constructor(private http : HttpClient){}

  ngOnInit(): void {
    this.pedidos = [];

    this.http.get<Pedido[]>("http://localhost:8080/pedidos/aberto").subscribe((dados) => this.pedidos = dados);
  }

  recolher(pedido : Pedido)
  {
    if(confirm(`Deseja atualizar o estado do pedido ${pedido.idPedido} ?`))
    {
      this.http.put<Pedido>(`http://localhost:8080/pedidos/${pedido.idPedido}/estado/recolhido`, pedido, httpHeader).subscribe((dados) => {
        pedido = dados;

        let auxPedido : Pedido[] = this.pedidos;
        this.pedidos = [];

        auxPedido.forEach((obj, index, objs) => {
          if(obj.idPedido !== pedido.idPedido)
            this.pedidos.push(obj);
        });
      });
    }
  }
}
