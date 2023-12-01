import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Funcionario } from 'src/app/shared';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { FuncionarioService } from '../services/funcionario.service';


@Component({
  selector: 'app-manutencao-funcionarios',
  templateUrl: './manutencao-funcionarios.component.html',
  styleUrls: ['./manutencao-funcionarios.component.css']
})
export class ManutencaoFuncionariosComponent implements OnInit {

  funcionarios!: Funcionario[];
  @ViewChild('content', { static: false }) el!: ElementRef;
  constructor(private http: HttpClient, private router: Router, private route: ActivatedRoute, private funcionarioService: FuncionarioService) { }

  carregarDados() {
    this.funcionarioService.getFuncionarios().subscribe((data: Funcionario[]) => {
      this.funcionarios = data;
    });
  }

  ngOnInit(): void {
    this.carregarDados();
  }

  exibirDetalhes(id: number | undefined) {
    this.router.navigate(['./detalhes-funcionario', id], { relativeTo: this.route });
  }

}
