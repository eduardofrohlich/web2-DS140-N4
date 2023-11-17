import { Component, OnInit } from '@angular/core';
import { TelaInicialService } from './tela-inicial.service';

@Component({
  selector: 'app-tela-inicial',
  templateUrl: './tela-inicial.component.html',
  styleUrls: ['./tela-inicial.component.css']
})
export class TelaInicialComponent implements OnInit {
  dadosDoBanco: any[] = [];

  constructor(private telaInicialService: TelaInicialService) { }

  ngOnInit(): void {
    this.carregarDadosDoBanco();
  }

  carregarDadosDoBanco() {
    this.telaInicialService.getDadosDoBanco().subscribe(
      (dados) => {
        this.dadosDoBanco = dados;
      },
      (error) => {
        console.error('Erro ao carregar dados do banco', error);
      }
    );
  }
}