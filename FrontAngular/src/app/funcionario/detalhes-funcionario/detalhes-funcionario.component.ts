import { Component, OnInit } from '@angular/core';
import { Funcionario } from 'src/app/shared';
import { FuncionarioService } from '../services/funcionario.service';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-detalhes-funcionario',
  templateUrl: './detalhes-funcionario.component.html',
  styleUrls: ['./detalhes-funcionario.component.css']
})
export class DetalhesFuncionarioComponent implements OnInit {


  funcionario!: Funcionario;

  constructor(private http: HttpClient, private funcionarioService: FuncionarioService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    let id = +this.route.snapshot.params['id'];
    this.http.get("http://localhost:8080/funcionarios/" + id).subscribe((dados) => this.funcionario = dados);
  }

  editar() {
    this.router.navigate(['funcionario/manutencao/funcionarios/editar-funcionario/', this.funcionario.idFuncionario]);
  }

  excluir() {
    this.funcionarioService.excluirFuncionario(this.funcionario.idFuncionario).subscribe((dados) => console.log(dados));
    this.router.navigate(['/funcionario/manutencao/funcionarios']);
  }

  return() {
    this.router.navigate(['/funcionario/manutencao/funcionarios'], { relativeTo: this.route });
  }

}
