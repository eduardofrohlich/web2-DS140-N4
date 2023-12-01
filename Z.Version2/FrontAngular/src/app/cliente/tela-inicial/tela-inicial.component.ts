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
  selector: 'app-tela-inicial',
  templateUrl: './tela-inicial.component.html',
  styleUrls: ['./tela-inicial.component.css']
})
export class TelaInicialComponent implements OnInit{
  pedidos! : Pedido[];

  constructor(private http : HttpClient){}

  ngOnInit(): void {
    this.pedidos = [];

    this.http.get<Pedido[]>("http://localhost:8080/pedidos/cliente/2/aberto").subscribe(
      (dados) => this.pedidos = dados
    );
  }
}
