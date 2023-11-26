import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { RelatorioService } from '../services/relatorio.service';

@Component({
  selector: 'app-relatorio',
  templateUrl: './relatorio.component.html',
  styleUrls: ['./relatorio.component.css']
})
export class RelatorioComponent {
  dataInicial: string = '';
  dataFinal: string = '';

  constructor(private relatorioService: RelatorioService, private router: Router) {}

  navigateToReceita() {
    this.router.navigate(['/funcionario/relatorio/receita']);
  }
  navigateToCliente() {
    this.router.navigate(['/funcionario/relatorio/cliente']);
  }
  navigateToClienteFiel() {
    this.router.navigate(['/funcionario/relatorio/cliente-fiel']);
  }
  gerarRelatorio(dataInicial: string, dataFinal: string): void {
    // Chame o serviço que enviará as datas para o backend
    // Exemplo: this.relatorioService.gerarRelatorio(dataInicial, dataFinal);
  
    // Navegue para a tela de relatório
    this.router.navigate(['/funcionario/relatorio/receita', dataInicial, dataFinal]);
  }
}
