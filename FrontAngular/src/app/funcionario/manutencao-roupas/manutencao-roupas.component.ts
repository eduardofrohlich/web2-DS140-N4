import { Roupa } from 'src/app/shared';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { RoupaService } from '../services/roupa.service';

@Component({
  selector: 'app-manutencao-roupas',
  templateUrl: './manutencao-roupas.component.html',
  styleUrls: ['./manutencao-roupas.component.css']
})
export class ManutencaoRoupasComponent implements OnInit{

  roupas!: Roupa[];
  @ViewChild('content', { static: false }) el!: ElementRef;
  constructor(private http: HttpClient, private router: Router, private route: ActivatedRoute, private roupaService: RoupaService) { }

  carregarDados() {
    this.roupaService.getRoupas().subscribe((data: Roupa[]) => {
      this.roupas = data;
    });
  }

  ngOnInit(): void {
    this.carregarDados();
  }

  exibirDetalhes(id: number | undefined) {
    this.router.navigate(['./detalhes-roupa', id], { relativeTo: this.route });
  }
}
