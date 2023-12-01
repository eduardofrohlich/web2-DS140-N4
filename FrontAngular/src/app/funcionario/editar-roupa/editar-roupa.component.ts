import { Component, OnInit } from '@angular/core';
import { Roupa } from 'src/app/shared';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { RoupaService } from '../services/roupa.service';

@Component({
  selector: 'app-editar-roupa',
  templateUrl: './editar-roupa.component.html',
  styleUrls: ['./editar-roupa.component.css']
})
export class EditarRoupaComponent implements OnInit {


  roupa!: Roupa ;

  constructor(private http: HttpClient, private roupaService: RoupaService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    let id = +this.route.snapshot.params['id'];
    this.http.get<Roupa>("http://localhost:8080/roupas/" + id).subscribe((dados) => this.roupa = dados);
  }

  salvar() {
    this.roupaService.editarRoupa(this.roupa).subscribe((dados) => {
      console.log(dados);
    });
    this.router.navigate(['/funcionario/manutencao/roupas']);

  }

  cancelar() {
    this.router.navigate(['/funcionario/manutencao/roupas']);
  }

}
