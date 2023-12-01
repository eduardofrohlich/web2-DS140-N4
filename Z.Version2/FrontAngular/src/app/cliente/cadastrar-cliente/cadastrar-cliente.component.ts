import { Component, OnInit, ViewChild} from '@angular/core';
import { Cliente, Endereco } from 'src/app/shared';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';
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

export class CadastrarClienteComponent implements OnInit{
  @ViewChild('formCliente') formCliente! : NgForm;
  cliente! : Cliente;

  constructor(private http : HttpClient){}

  ngOnInit(): void {
    this.cliente = new Cliente(0, new Endereco(0, '', '', '', '', 0, ''), '', '', '', '', '');
  }

  cadastrar()
  {
    console.log("Cadastrando...");
    console.log(this.cliente.endereco);

    // Inserir a senha gerada random que é enviada no email (Não sei onde tá essa parte do código)
    this.cliente.senha = "1234";

    // Bug em preencher rua e bairro quando o nome é dividido por espaço. Ex: Jardim das Américas (desbuga ao interagir com o input)
    //if(this.formCliente.form.valid)
    //{
      this.http.post<Cliente>("http://localhost:8080/clientes", this.cliente, httpHeader).subscribe((dados) => {
        this.cliente = dados;
        confirm(`Cliente cadastrado com sucesso!\nId do cliente: ${this.cliente.idCliente}`);
      });
    //}
  }
}
