import { Component, ViewChild, ElementRef, OnInit } from '@angular/core';
import { Pedido } from 'src/app/shared';
import { PedidosService } from '../services/pedidos.service';

@Component({
  selector: 'app-visualiza-pedido',
  templateUrl: './visualiza-pedido.component.html',
  styleUrls: ['./visualiza-pedido.component.css']
})
export class VisualizaPedidoComponent implements OnInit {

  pedidos!: Pedido[];

  @ViewChild('content', { static: false }) el!: ElementRef;
  constructor(private pedidoService: PedidosService) { }

  ngOnInit(): void {
    this.carregarDados();
  }

  carregarDados() {
    this.pedidoService.getPedidos().subscribe((pedidos) => {
      this.pedidos = pedidos;
    });
  }

  getMensagemBotao(pedido: Pedido): string {
    switch (pedido.pedidoStatus) {
      case 'ABERTO':
        return 'Registrar recolhimento';
      case 'RECOLHIDO':
        return 'Confirmar Lavagem';
      case 'PAGO':
        return 'Finalizar Pedido';
      default:
        return 'Detalhes do pedido';
    }
  }

  getCorEstado(pedido: Pedido): string {
    switch (pedido.pedidoStatus) {
      case 'ABERTO':
        return 'rgb(165, 165, 0)';
      case 'PAGO':
        return 'rgb(214, 94, 50)';
      case 'REJEITADO' || 'CANCELADO':
        return 'rgba(255, 0, 0, 0.697)';
      case 'FINALIZADO':
        return 'rgb(26, 204, 26)';
      case 'AGUARDANDO_PAGAMENTO':
        return 'rgba(8, 169, 255, 0.77)';
      default:
        return '#1a191986';
    }
  }

  atualizarEstado(pedido: Pedido) {
    if (confirm("Tem certeza que quer pagar o pedido?")) {
      if (pedido.idPedido !== undefined && pedido.pedidoStatus !== undefined) {
        const id: number = pedido.idPedido;
        const estado: string = pedido.pedidoStatus.toString();
        this.pedidoService.atualizarEstado(id, estado);
      } else {
        console.error('Pedido não encontrado na lista.');
      }
    }
  }



}
