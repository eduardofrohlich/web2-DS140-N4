import { Component, OnInit } from '@angular/core';
import { Funcionario } from 'src/app/shared';
import { FuncionarioService } from '../services/funcionario.service';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-editar-funcionario',
  templateUrl: './editar-funcionario.component.html',
  styleUrls: ['./editar-funcionario.component.css']
})
export class EditarFuncionarioComponent implements OnInit {

  funcionario!: Funcionario;

  constructor(private http: HttpClient, private funcionarioService: FuncionarioService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    let id = +this.route.snapshot.params['id'];
    this.http.get("http://localhost:8080/funcionarios/" + id).subscribe((dados) => this.funcionario = dados);
  }


  editar() {
    this.funcionarioService.editarFuncionario(this.funcionario).subscribe((dados) => console.log(dados));
    this.router.navigate(['/funcionario/manutencao/funcionarios']);
  }

}
