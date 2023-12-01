import { Component, OnInit, ViewChild } from '@angular/core';
import { Pedido } from 'src/app/shared';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { HttpHeaders } from '@angular/common/http';

const httpHeader = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Component({
  selector: 'app-visualiza-pedido',
  templateUrl: './visualiza-pedido.component.html',
  styleUrls: ['./visualiza-pedido.component.css']
})
export class VisualizaPedidoComponent implements OnInit{
  @ViewChild('formFunc') formFunc! : NgForm;
  pedidos! : Pedido[];

  constructor(private http : HttpClient){}

  ngOnInit(): void {
    this.pedidos = [];

    this.http.get<Pedido[]>(`http://localhost:8080/pedidos`).subscribe((dados) => this.pedidos = dados);
  }

  confirmarRecolhimento(pedido : Pedido)
  {
    if(confirm(`Deseja confirmar o recolhimento do pedido ${pedido.idPedido} ?`))
    {
      this.http.put<Pedido>(`http://localhost:8080/pedidos/${pedido.idPedido}/estado/recolhido`, pedido, httpHeader).subscribe((dados) => {
        pedido = dados;

        this.pedidos.forEach((obj, index, objs) => {
          if(obj.idPedido == pedido.idPedido)
            objs[index] = pedido;
        });
      });
    }
  }

  confirmarLavagem(pedido : Pedido)
  {
    if(confirm(`Deseja confirmar a lavagem do pedido ${pedido.idPedido} ?`))
    {
      this.http.put<Pedido>(`http://localhost:8080/pedidos/${pedido.idPedido}/estado/aguardando pagamento`, pedido, httpHeader).subscribe((dados) => {
        pedido = dados;

        this.pedidos.forEach((obj, index, objs) => {
          if(obj.idPedido == pedido.idPedido)
            objs[index] = pedido;
        });
      });
    }
  }

  finalizar(pedido : Pedido)
  {
    if(confirm(`Deseja confirmar o recolhimento do pedido ${pedido.idPedido} ?`))
    {
      this.http.put<Pedido>(`http://localhost:8080/pedidos/${pedido.idPedido}/estado/finalizado`, pedido, httpHeader).subscribe((dados) => {
        pedido = dados;

        this.pedidos.forEach((obj, index, objs) => {
          if(obj.idPedido == pedido.idPedido)
            objs[index] = pedido;
        });
      });
    }
  }
}
