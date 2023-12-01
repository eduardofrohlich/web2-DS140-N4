import { HttpClient } from '@angular/common/http';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FuncionarioService } from 'src/app/funcionario/services/funcionario.service';
import { PedidosService } from 'src/app/funcionario/services/pedidos.service';
import { Cliente, Pedido } from 'src/app/shared';


@Component({
  selector: 'app-tela-inicial',
  templateUrl: './tela-inicial.component.html',
  styleUrls: ['./tela-inicial.component.css']
})
export class TelaInicialComponent implements OnInit {


  pedidos!: Pedido[];
  cliente!: Cliente;
  id!: any;

  @ViewChild('content', { static: false }) el!: ElementRef;
  constructor(private pedidoService: PedidosService, private http: HttpClient, private funcionarioService: FuncionarioService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = +this.route.snapshot.params['id'];
    this.http.get<Cliente>("http://localhost:8080/clientes/" + this.id).subscribe((dados) => this.cliente = dados);
    this.carregarDados();
  }

  carregarDados() {
    this.pedidoService.getAbertosByCliente(this.id).subscribe((pedidos) => {
      let targetPedidos = pedidos;
      this.pedidos = targetPedidos;
    });
  }


}
