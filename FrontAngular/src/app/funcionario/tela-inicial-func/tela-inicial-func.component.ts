import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Pedido } from 'src/app/shared';
import { PedidosService } from '../services/pedidos.service';

@Component({
  selector: 'app-tela-inicial-func',
  templateUrl: './tela-inicial-func.component.html',
  styleUrls: ['./tela-inicial-func.component.css']
})
export class TelaInicialFuncComponent implements OnInit {


  pedidos!: Pedido[];

  @ViewChild('content', { static: false }) el!: ElementRef;
  constructor(private pedidoService: PedidosService) { }

  ngOnInit(): void {
    this.carregarDados();
  }

  carregarDados() {
    this.pedidoService.getAbertos().subscribe((pedidos) => {
      this.pedidos = pedidos;
    });
  }

  atualizarEstado(pedido: Pedido) {
    if (confirm("Tem certeza que quer registrar o recolhimento?")) {
      if (pedido.idPedido !== undefined && pedido.pedidoStatus !== undefined) {
        const id: number = pedido.idPedido;
        const estado: string = pedido.pedidoStatus.toString();
          this.pedidoService.atualizarEstado(id, estado);
          this.pedidos.splice(this.pedidos.indexOf(pedido), 1);
        } else {
          console.error('Pedido não encontrado na lista.');
        }
      }
  }

}
