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

  formatCpf(cpf: string | undefined): string {
    if (!cpf) {
      return 'CPF Inválido';
    }

    const cleanedCpf = cpf.replace(/\D/g, '');

    if (cleanedCpf.length !== 11) {
      // Invalid CPF length, return as is
      return 'CPF Inválido';
    }

    const cpfArray = cleanedCpf.split('');
    const formattedCpf = cpfArray.reduce((acc, digit, index) => {
      return acc + digit + (index === 2 || index === 5 ? '.' : (index === 8 ? '-' : ''));
    }, '');

    return formattedCpf;
  }

  formatTelefone(telefone: string | undefined): string {
    if (!telefone) {
      return 'Telefone Inválido';
    }
  
    const cleanedTelefone = telefone.replace(/\D/g, ''); // Remove caracteres não numéricos
  
    if (![8, 9, 11].includes(cleanedTelefone.length)) {
      // Verifica se o número de dígitos é 8, 9 ou 11
      return 'Telefone Inválido';
    }
  
    // Separa os dígitos para formatação
    const telefoneArray = cleanedTelefone.split('');
  
    // Adiciona o código de área (se existir)
    if (telefoneArray.length === 11) {
      return `(${telefoneArray.slice(0, 2).join('')}) ${telefoneArray.slice(2, 7).join('')}-${telefoneArray.slice(7).join('')}`;
    }
    if (telefoneArray.length === 9) {
      return `${telefoneArray.slice(0, 5).join('')}-${telefoneArray.slice(5).join('')}`;
    }


    // Adiciona os grupos de 4 dígitos (ou 4 dígitos)
    return telefoneArray.slice(0, 4).join('') + '-' + telefoneArray.slice(4).join('');
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
