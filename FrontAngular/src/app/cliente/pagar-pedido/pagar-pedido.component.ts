import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs';
import { Pedido } from 'src/app/shared';

@Component({
  selector: 'app-pagar-pedido',
  templateUrl: './pagar-pedido.component.html',
  styleUrls: ['./pagar-pedido.component.css']
})
export class PagarPedidoComponent implements OnInit{
  pedido! : any;

  constructor(private http : HttpClient){}

  ngOnInit(): void {
    let resposta = this.http.get("http://localhost:8080/pedidos/cliente/2");
    resposta.subscribe((dados) => this.pedido = dados);
  }
}
