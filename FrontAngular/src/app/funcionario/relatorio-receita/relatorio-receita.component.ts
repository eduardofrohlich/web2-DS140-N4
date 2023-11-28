import { Component, ViewChild, ElementRef, OnInit} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import jsPDF from 'jspdf';
import { RelatorioService } from '../services/relatorio.service';
import { Receita } from 'src/app/shared/models/receita.model';

const httpHeader = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
}

@Component({
  selector: 'app-relatorio-receita',
  templateUrl: './relatorio-receita.component.html',
  styleUrls: ['./relatorio-receita.component.css']
})
export class RelatorioReceitaComponent {
  receitas!: Receita[];
  total: number = 0;
  constructor(private route: ActivatedRoute, private relatorioService : RelatorioService) {}

  @ViewChild('content', {static: false}) el!:ElementRef;
  dataInicial: string = '';
  dataFinal: string = '';
  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      this.dataInicial = params['dataInicial'];
      this.dataFinal = params['dataFinal'];
      this.relatorioService.getReceita(this.dataInicial, this.dataFinal).subscribe((data) => {
        this.receitas = data;
      },
      (error) => {
        console.error('Erro ao obter relatório de receita:', error);
      }
    )});
  }
  
  getTotal() {
      return this.receitas.reduce((acc, receita) => acc + (receita.receita ?? 0), 0);
    }
  gerarPDFReceita() {
    var doc = new jsPDF('l', 'pt', 'tabloid');
    doc.html(this.el.nativeElement, {
      callback: (doc) => {doc.save('RelatorioReceita.pdf');
      }   
    })
  }

}