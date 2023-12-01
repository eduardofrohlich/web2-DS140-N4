
import { Roupa } from 'src/app/shared';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { RoupaService } from '../services/roupa.service';

@Component({
  selector: 'app-detalhes-roupa',
  templateUrl: './detalhes-roupa.component.html',
  styleUrls: ['./detalhes-roupa.component.css']
})
export class DetalhesRoupaComponent implements OnInit{

  roupa!: Roupa;

  constructor(private http: HttpClient, private roupaService: RoupaService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    let id = +this.route.snapshot.params['id'];
    this.http.get("http://localhost:8080/roupas/" + id).subscribe((dados) => this.roupa = dados);
  }

  editar() {
    const url = 'funcionario/manutencao/roupas/editar-roupa/' + this.roupa.idRoupa;
    this. router.navigate([url]);
  }

  return() {
    this.router.navigate(['/funcionario/manutencao/roupas'], { relativeTo: this.route });
  }
}
