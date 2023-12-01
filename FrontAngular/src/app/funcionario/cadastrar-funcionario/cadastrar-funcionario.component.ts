import { Funcionario, Endereco } from 'src/app/shared';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FuncionarioService } from '../services/funcionario.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ViaCepService } from '../services/via-cep.service';

@Component({
  selector: 'app-cadastrar-funcionario',
  templateUrl: './cadastrar-funcionario.component.html',
  styleUrls: ['./cadastrar-funcionario.component.css']
})

export class CadastrarFuncionarioComponent implements OnInit {
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
  funcionario!: Funcionario;
  cep: any;

  constructor(private http: HttpClient, private funcionarioService: FuncionarioService, private router: Router, private route: ActivatedRoute, private viaCepService: ViaCepService) { }

  ngOnInit() {

  }

  enviar() {
    this.funcionario = new Funcionario();
    this.funcionario.nome = this.nome;
    this.funcionario.email = this.email;
    this.funcionario.cpf = this.cpf;
    this.funcionario.telefone = this.telefone;
    this.funcionario.senha = this.senha;
    this.funcionario.endereco = this.rua + "," + this.numCasa + "," + this.bairro + "," + this.cidade + "," + this.uf;
    this.funcionario.dataNascimento = this.dataNascimento;
    console.log(this.funcionario);
    this.funcionarioService.adicionarFuncionario(this.funcionario).subscribe((dados) => {
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
