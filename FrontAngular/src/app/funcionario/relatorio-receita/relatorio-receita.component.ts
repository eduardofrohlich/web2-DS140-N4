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
  constructor(private route: ActivatedRoute, private relatorioService : RelatorioService) {}

  @ViewChild('content', {static: false}) el!:ElementRef;
  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const dataInicial = params['dataInicial'];
      const dataFinal = params['dataFinal'];
      this.relatorioService.getReceita(dataInicial, dataFinal).subscribe();
      //this.receitas=this.relatorioService.getReceita();
      // Chame o serviço para obter os dados do relatório com base nas datas
      // Exemplo: this.relatorioService.obterRelatorio(dataInicial, dataFinal).subscribe(result => { /* Exiba os dados na tela */ });
    });
  }
  gerarPDFCliente() {
    var doc = new jsPDF('l');
    doc.html(this.el.nativeElement, {
      callback: (doc) => {doc.save('RelatorioCliente.pdf');
      }   
    })
  }

}