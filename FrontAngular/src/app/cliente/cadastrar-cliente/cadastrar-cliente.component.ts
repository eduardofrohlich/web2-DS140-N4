import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Cliente, Funcionario } from 'src/app/shared';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { HttpHeaders } from '@angular/common/http';
import { ViaCepService } from 'src/app/funcionario/services/via-cep.service';
import { ClienteService } from '../services/cliente.service';

const httpHeader = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Component({
  selector: 'app-cadastrar-cliente',
  templateUrl: './cadastrar-cliente.component.html',
  styleUrls: ['./cadastrar-cliente.component.css']
})
export class CadastrarClienteComponent implements OnInit {
  nome: any;
  email: any;
  cpf: any;
  telefone: any;
  rua: any;
  numCasa: any;
  bairro: any;
  cidade: any;
  uf: any;
  senha: any;
  dataNascimento: any;
  cliente!: Cliente;
  cep: any;

  constructor(private http: HttpClient, private clienteService: ClienteService, private router: Router, private route: ActivatedRoute, private viaCepService: ViaCepService) { }

  ngOnInit() {

  }

  enviar() {
    this.cliente = new Funcionario();
    this.cliente.nome = this.nome;
    this.cliente.email = this.email;
    this.cliente.cpf = this.cpf;
    this.cliente.telefone = this.telefone;
    this.cliente.senha = this.senha;
    this.cliente.endereco = this.rua + "," + this.numCasa + "," + this.bairro + "," + this.cidade + "," + this.uf;
    console.log(this.cliente);
    this.clienteService.adicionarFuncionario(this.cliente).subscribe((dados) => {
      console.log(dados);
    });
    this.router.navigate(['/funcionario/manutencao/funcionarios']);

  }

  buscarEnderecoPorCep(cep: string) {
    this.viaCepService.getEnderecoByCep(cep).subscribe((dados) => {
      this.rua = dados.logradouro;
      this.bairro = dados.bairro;
      this.cidade = dados.localidade;
      this.uf = dados.uf;
    }, (error) => {
      console.error('Erro ao buscar endereço por CEP', error);
    });
  }


  onCepChange(cep: string) {
    if (cep.length === 8) {
      this.buscarEnderecoPorCep(cep);
    }
  }
}
