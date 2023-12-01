import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { PedidosService } from 'src/app/funcionario/services/pedidos.service';
import { Pedido } from 'src/app/shared';


@Component({
  selector: 'app-tela-inicial',
  templateUrl: './tela-inicial.component.html',
  styleUrls: ['./tela-inicial.component.css']
})
export class TelaInicialComponent implements OnInit {


  pedidos!: Pedido[];

  @ViewChild('content', { static: false }) el!: ElementRef;
  constructor(private pedidoService: PedidosService) { }

  ngOnInit(): void {
    this.carregarDados();
  }

  carregarDados() {
    this.pedidoService.getAbertos().subscribe((pedidos) => {
      let targetPedidos = pedidos;
      this.pedidos = targetPedidos;
    });
  }


}
