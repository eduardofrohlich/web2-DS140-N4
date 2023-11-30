import { Component, OnInit, ViewChild } from '@angular/core';
import { Cliente } from 'src/app/shared';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-cadastrar-cliente',
  templateUrl: './cadastrar-cliente.component.html',
  styleUrls: ['./cadastrar-cliente.component.css']
})
export class CadastrarClienteComponent implements OnInit {
  @ViewChild('formCliente') formCliente!: NgForm;
  cliente! : Cliente;

  constructor() {}

  ngOnInit(): void {
    this.cliente = new Cliente();
  }

  geraSenhaAleatoria(){
    var senhaAleatoria = '';
    var caracteres = '0123456789';
    for (var i = 0;i < 4;i++){
      senhaAleatoria += caracteres.charAt(Math.floor(Math.random() * caracteres.length));
    }
    return senhaAleatoria;
  }
}
