import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-relatorio-cliente-fiel',
  templateUrl: './relatorio-cliente-fiel.component.html',
  styleUrls: ['./relatorio-cliente-fiel.component.css']
})
export class RelatorioClienteFielComponent {
  constructor(private http : HttpClient, private router : Router, private route : ActivatedRoute){}

}
