import { HttpClient } from '@angular/common/http';
import { Component, ViewChild, ElementRef, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PedidosService } from 'src/app/funcionario/services/pedidos.service';
import { Cliente, Pedido } from 'src/app/shared';

@Component({
  selector: 'app-meus-pedidos',
  templateUrl: './meus-pedidos.component.html',
  styleUrls: ['./meus-pedidos.component.css']
})
export class MeusPedidosComponent {
  pedidos!: Pedido[];
  cliente!: Cliente;
  id!: any;

  @ViewChild('content', { static: false }) el!: ElementRef;
  constructor(private pedidoService: PedidosService, private http: HttpClient, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = +this.route.snapshot.params['id'];
    this.http.get<Cliente>("http://localhost:8080/clientes/" + this.id).subscribe((dados) => this.cliente = dados);
    this.carregarDados();
  }

  carregarDados() {
    this.pedidoService.getByCliente(this.id).subscribe((pedidos) => {
      this.pedidos = pedidos;
    });
  }

  getMensagemBotao(pedido: Pedido): string {
    switch (pedido.pedidoStatus) {
      case 'AGUARDANDO_PAGAMENTO':
        return 'Pagar';
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
    if (pedido.pedidoStatus === 'AGUARDANDO_PAGAMENTO') {
      if (confirm("Tem certeza que quer pagar o pedido?")) {
        if (pedido.idPedido !== undefined && pedido.pedidoStatus !== undefined) {
          const id: number = pedido.idPedido;
          const estado: string = pedido.pedidoStatus.toString();
          this.pedidoService.atualizarEstado(id, estado);
          this.router.navigate(['cliente/pagar-pedido', pedido.idPedido]);
        }
      }
    } else {
      this.router.navigate([`cliente/meus-pedidos/detalhe/${pedido.idPedido}/${this.id}`]);    }
  }

}
