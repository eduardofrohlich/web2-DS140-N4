import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Pedido } from 'src/app/shared';
import { PedidosService } from '../services/pedidos.service';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { PedidoAberto } from 'src/app/shared/models/pedido-aberto.model';

@Component({
  selector: 'app-tela-inicial-func',
  templateUrl: './tela-inicial-func.component.html',
  styleUrls: ['./tela-inicial-func.component.css']
})
export class TelaInicialFuncComponent implements OnInit {

  pedidos!: PedidoAberto[];

  @ViewChild('content', {static: false}) el!:ElementRef;
  constructor(private http : HttpClient, private router : Router, private route : ActivatedRoute,private pedidoService: PedidosService) { }

  ngOnInit(): void {
    this.carregarDados();
  }

  carregarDados() {
    this.pedidoService.getAbertos().subscribe((pedidos) => {
      this.pedidos = pedidos;
    });
  }
}
