import { Component, OnInit } from '@angular/core';
import { Pedido } from 'src/app/shared';
import { PedidosService } from '../services/pedidos.service';

@Component({
  selector: 'app-tela-inicial-func',
  templateUrl: './tela-inicial-func.component.html',
  styleUrls: ['./tela-inicial-func.component.css']
})
export class TelaInicialFuncComponent implements OnInit {

  pedidos: Pedido[] = [];

  constructor(private pedidoService: PedidosService) { }

  ngOnInit(): void {
    this.pedidoService.getAbertos().subscribe((pedidos) => {
      this.pedidos = pedidos;
    });
  }

}
