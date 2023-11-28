import { Component, ViewChild, ElementRef, OnInit} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import jsPDF from 'jspdf'; //executar no terminal: npm install jspdf
import { RelatorioService } from '../services/relatorio.service';
import { Clientefiel } from 'src/app/shared'

const httpHeader = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
}

  @Component({
    selector: 'app-relatorio-cliente-fiel',
    templateUrl: './relatorio-cliente-fiel.component.html',
    styleUrls: ['./relatorio-cliente-fiel.component.css']
  })
  export class RelatorioClienteFielComponent {
    clientes!: Clientefiel[];
    total: number = 0;
    @ViewChild('content', {static: false}) el!:ElementRef;
    constructor(private http : HttpClient, private router : Router, private route : ActivatedRoute, private relatorioService: RelatorioService){}

    carregarDados() {
      this.relatorioService.getClientesFieis().subscribe((data) => {
        this.clientes = data;
      })
      this.getTotal();
    }


    getTotal() {
      return this.clientes.reduce((acc, cliente) => acc + (cliente.sum ?? 0), 0);
    }


    ngOnInit(): void {
      this.carregarDados();
    }
   
    gerarPDFClienteFiel() {
      var doc = new jsPDF('l', 'pt', 'tabloid');
      doc.html(this.el.nativeElement, {
        callback: (doc) => {doc.save('RelatorioClienteFiel.pdf');
        }   
      })
    }

}
