import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Cliente } from 'src/app/shared';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { HttpHeaders } from '@angular/common/http';

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
  cliente! : Cliente;
  nome: string = '';
  cpf: string = '';
  email: string = '';
  telefone: string = '';
  dataFinal: string = '';
  cep: string = '';
  numCasa: string = '';
  bairro: string = '';
  cidade: string = '';
  uf: string = ''
  rua:string =''

  constructor(private router: Router,private http: HttpClient) {}

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

  concatenaEndereco(): string {
    return `${this.rua} ${this.numCasa}`;
  }

  Enviar(){
    let senhaGerada = this.geraSenhaAleatoria();
    const dadosFormulario = {
      nome: this.nome,
      email: this.email,
      cpf: this.cpf,
      telefone: this.telefone,
      rua: this.concatenaEndereco(),
      senha: senhaGerada
    };
    alert("Sua senha é: "+ senhaGerada);
    this.http.post('http://localhost:8080/clientes', dadosFormulario)
      .subscribe(
        response => {
          console.log('Cadastro realizado com sucesso!', response);
          // Adicione aqui o que deseja fazer após o cadastro bem-sucedido
        },
        error => {
          console.error('Erro no cadastro', error);
          // Adicione aqui o que deseja fazer em caso de erro
        }
      );
    this.router.navigate(['/login']);

  }
}
