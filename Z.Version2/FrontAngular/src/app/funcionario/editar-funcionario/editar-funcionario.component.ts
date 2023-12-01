import { Component, OnInit, ViewChild } from '@angular/core';
import { Endereco, Funcionario } from 'src/app/shared';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { DatePipe } from '@angular/common';

const httpHeader = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Component({
  selector: 'app-editar-funcionario',
  templateUrl: './editar-funcionario.component.html',
  styleUrls: ['./editar-funcionario.component.css']
})
export class EditarFuncionarioComponent {
  @ViewChild('formFunc') formFunc! : NgForm;
  funcionario! : Funcionario;

  constructor(private http : HttpClient, private router : Router, private datePipe : DatePipe, private route : ActivatedRoute){}

  ngOnInit(): void {
    let id = +this.route.snapshot.params['id'];
    this.http.get<Funcionario>(`http://localhost:8080/funcionarios/${id}`).subscribe((dados) => this.funcionario = dados);
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
      this.http.put<Funcionario>(`http://localhost:8080/funcionarios/${this.funcionario.idFuncionario}`, this.funcionario, httpHeader).subscribe((dados) => {
        this.funcionario = dados;
        confirm(`Funcionario atualizado com sucesso!\nId do funcionario: ${this.funcionario.idFuncionario}`);
        this.router.navigate(['/funcionario/listar']);
      });
    //}
  }
}
