import { Component, OnInit } from '@angular/core';
import { Funcionario } from 'src/app/shared';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-listar-funcionario',
  templateUrl: './listar-funcionario.component.html',
  styleUrls: ['./listar-funcionario.component.css']
})
export class ListarFuncionarioComponent implements OnInit{
  funcionarios! : Funcionario[];

  constructor(private http : HttpClient){}

  ngOnInit(): void {
    this.funcionarios = [];

    this.http.get<Funcionario[]>("http://localhost:8080/funcionarios").subscribe((dados) => this.funcionarios = dados);
  }

  remover(func : Funcionario)
  {
    if(confirm(`Deseja remover o funcionario ${func.nome} ?`))
    {
      this.http.delete<Funcionario>(`http://localhost:8080/funcionarios/${func.idFuncionario}`).subscribe((dados) => {
        func = dados;

        let auxFunc : Funcionario[] = [];

        this.funcionarios.forEach((obj, index, objs) => {
          if(obj.idFuncionario !== func.idFuncionario)
            auxFunc.push(obj);
        });

        this.funcionarios = auxFunc;
      });
    }
  }
}
