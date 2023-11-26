import { Component, ViewChild, ElementRef, OnInit} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import jsPDF from 'jspdf';
import { Cliente } from 'src/app/shared'
import { RelatorioService } from '../services/relatorio.service';

const httpHeader = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Component({
  selector: 'app-relatorio-cliente',
  templateUrl: './relatorio-cliente.component.html',
  styleUrls: ['./relatorio-cliente.component.css']
})

export class RelatorioClienteComponent implements OnInit {
  
  clientes!: Cliente[];
  @ViewChild('content', {static: false}) el!:ElementRef;
  constructor(private http : HttpClient, private router : Router, private route : ActivatedRoute, private relatorioService: RelatorioService){}
  
  carregarDados() {
    this.relatorioService.getClientes().subscribe((data) => {
      this.clientes = data;
    });
  }
  
  ngOnInit(): void {
    this.carregarDados();
  }

  gerarPDFCliente() {
    var doc = new jsPDF('l', 'pt', 'tabloid');
    doc.html(this.el.nativeElement, {
      callback: (doc) => {doc.save('RelatorioCliente.pdf');
      }   
    })
  }
}
