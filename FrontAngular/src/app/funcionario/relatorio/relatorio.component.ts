import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RelatorioService } from '../services/relatorio.service';

@Component({
  selector: 'app-relatorio',
  templateUrl: './relatorio.component.html',
  styleUrls: ['./relatorio.component.css']
})
export class RelatorioComponent {
  dataInicial: string = '';
  dataFinal: string = '';
  data1: Date = new Date();
  data2: Date = new Date();
  constructor(private relatorioService: RelatorioService, private router: Router) {}

  navigateToCliente() {
    this.router.navigate(['/funcionario/relatorio/cliente']);
  }
  
  navigateToClienteFiel() {
    this.router.navigate(['/funcionario/relatorio/cliente-fiel']);
  }

  gerarRelatorio() {
    this.router.navigate(['/funcionario/relatorio/receita'], {
      queryParams: {
        dataInicial: this.dataInicial,
        dataFinal: this.dataFinal
      }
    });
  }
}
