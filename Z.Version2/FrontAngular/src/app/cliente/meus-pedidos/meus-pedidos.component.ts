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
  selector: 'app-meus-pedidos',
  templateUrl: './meus-pedidos.component.html',
  styleUrls: ['./meus-pedidos.component.css']
})
export class MeusPedidosComponent implements OnInit{
  TodosPedidos! : Pedido[];
  pedidosFiltrados! : Pedido[];
  estadoSelecionado! : string;

  constructor(private http : HttpClient){}

  ngOnInit(): void {
    this.TodosPedidos = [];
    this.pedidosFiltrados = [];

    this.http.get<Pedido[]>("http://localhost:8080/pedidos/cliente/1").subscribe((dados) => {
      this.TodosPedidos = dados; 
      this.pedidosFiltrados = dados;
    });
  }

  cancelar(pedido : Pedido)
  {
    if(confirm(`Deseja cancelar o pedido ${pedido.idPedido} ?`))
    {
      this.http.put<Pedido>(`http://localhost:8080/pedidos/${pedido.idPedido}/estado/cancelado`, pedido, httpHeader).subscribe(
        (dados) => {
        pedido = dados;

        this.pedidosFiltrados.forEach((obj, index, objs) => {
          if(obj.idPedido == pedido.idPedido)
            objs[index] = pedido;
        });
      });
    }
  }

  filtrar()
  {
    if(this.estadoSelecionado.toUpperCase() == 'TODOS')
    {
      this.pedidosFiltrados = [];

      this.TodosPedidos.forEach((obj, index, objs) => {
        this.pedidosFiltrados.push(obj);
      });
    }
    else
    {
      this.pedidosFiltrados = [];

      this.TodosPedidos.forEach((obj, index, objs) => {
        if(obj.estado == this.estadoSelecionado.toUpperCase())
          this.pedidosFiltrados.push(obj);
      });
    }
  }
}
