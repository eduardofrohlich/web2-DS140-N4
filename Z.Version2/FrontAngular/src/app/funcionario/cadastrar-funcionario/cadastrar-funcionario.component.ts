import { Component, OnInit, ViewChild } from '@angular/core';
import { Endereco, Funcionario } from 'src/app/shared';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { DatePipe } from '@angular/common'

const httpHeader = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Component({
  selector: 'app-cadastrar-funcionario',
  templateUrl: './cadastrar-funcionario.component.html',
  styleUrls: ['./cadastrar-funcionario.component.css']
})
export class CadastrarFuncionarioComponent implements OnInit{
  @ViewChild('formFunc') formFunc! : NgForm;
  funcionario! : Funcionario;

  constructor(private http : HttpClient, private router : Router, private datePipe : DatePipe){}

  ngOnInit(): void {
    this.funcionario = new Funcionario(0, new Endereco(0, '', '', '', '', 0, ''), '', '', '', '', '', '');
  }

  inserir()
  {
    console.log("Inserindo funcionario...");
    
    let data = this.datePipe.transform(this.funcionario.dataNascimento, 'dd-MM-yyyy');

    if(data !== null)
      this.funcionario.dataNascimento = data;

    console.log(this.funcionario);
    // Os problemas com bairro e rua aqui tbm...
    //if(this.formFunc.form.valid)
    //{
      this.http.post<Funcionario>("http://localhost:8080/funcionarios", this.funcionario, httpHeader).subscribe((dados) => {
        this.funcionario = dados;
        confirm(`Funcionario inserido com sucesso!\nId do funcionario: ${this.funcionario.idFuncionario}`);
        this.router.navigate(['/funcionario/listar']);
      });
    //}
  }
}
