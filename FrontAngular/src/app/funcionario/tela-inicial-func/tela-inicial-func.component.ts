import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Pedido } from 'src/app/shared';
import { PedidosService } from '../services/pedidos.service';

const httpHeader = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Component({
  selector: 'app-tela-inicial-func',
  templateUrl: './tela-inicial-func.component.html',
  styleUrls: ['./tela-inicial-func.component.css']
})
export class TelaInicialFuncComponent implements OnInit {


  pedidos!: Pedido[];

  @ViewChild('content', { static: false }) el!: ElementRef;
  constructor(private http: HttpClient, private router: Router, private route: ActivatedRoute, private pedidoService: PedidosService) { }

  ngOnInit(): void {
    this.carregarDados();
    if (this.pedidos.length === 0) {
      ///quero que seja exibida uma mensagem de não há pedidos caso a variavel pedidos[] esteja sem elementos
     }

  }

  carregarDados() {
    this.pedidoService.getAbertos().subscribe((pedidos) => {
      this.pedidos = pedidos;
    });
  }

  atualizarEstado(pedido: Pedido) {
    if (confirm("Tem certeza que quer pagar o pedido?")) {
      if (pedido.idPedido !== undefined && pedido.pedidoStatus !== undefined) {
        const id: number = pedido.idPedido;
        const estado: string = pedido.pedidoStatus.toString();
        const indicePedido = this.pedidos.findIndex(p => p.idPedido === id);
        if (indicePedido !== -1) {
          this.pedidos.splice(indicePedido, 1);
          this.pedidoService.atualizarEstado(id, estado);
          this.carregarDados(); 
        } else {
          console.error('Pedido não encontrado na lista.');
        }
      }
    }

  }
}
