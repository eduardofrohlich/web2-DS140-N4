import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Pedido } from 'src/app/shared';
import { Router } from '@angular/router';

const httpHeader = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Component({
  selector: 'app-pagar-pedido',
  templateUrl: './pagar-pedido.component.html',
  styleUrls: ['./pagar-pedido.component.css']
})
export class PagarPedidoComponent implements OnInit{
  pedido! : Pedido;

  constructor(private http : HttpClient, private router : Router){}

  ngOnInit(): void {
    // Pegar o id do pedido pela rota
    let resposta = this.http.get("http://localhost:8080/pedidos/2");
    resposta.subscribe((dados) => this.pedido = dados);
  }

  pagar()
  {
    if(confirm("Tem certeza que quer pagar o pedido?"))
    {
      this.http.put<Pedido>(`http://localhost:8080/pedidos/${this.pedido.idPedido}/estado/pago`, this.pedido, httpHeader).subscribe((pedidoAtualizado) => {
        this.pedido.estado = pedidoAtualizado.estado;
        confirm(`o pedido foi pago!\nId do pedido: ${this.pedido.idPedido}\nEstado do pedido: ${this.pedido.estado}`);
        this.router.navigate(['/cliente/pedidoonline']);
      });
    }
  }
}
