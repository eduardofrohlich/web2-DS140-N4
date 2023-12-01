import { Component, OnInit } from '@angular/core';
import { Funcionario } from 'src/app/shared';
import { FuncionarioService } from '../services/funcionario.service';
@Component({
  selector: 'app-detalhes-funcionario',
  templateUrl: './detalhes-funcionario.component.html',
  styleUrls: ['./detalhes-funcionario.component.css']
})
export class DetalhesFuncionarioComponent implements OnInit {

  func!: Funcionario;

  constructor(private funcionarioService: FuncionarioService) { }

  ngOnInit() {
    const funcionario = this.funcionarioService.getFuncionarioById(1);
    this.func = funcionario;
  }

}
