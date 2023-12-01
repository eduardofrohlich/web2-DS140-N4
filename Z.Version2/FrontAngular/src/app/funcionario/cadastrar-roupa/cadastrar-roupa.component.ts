import { Component, OnInit, ViewChild } from '@angular/core';
import { Roupa } from 'src/app/shared';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

const httpHeader = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Component({
  selector: 'app-cadastrar-roupa',
  templateUrl: './cadastrar-roupa.component.html',
  styleUrls: ['./cadastrar-roupa.component.css']
})
export class CadastrarRoupaComponent implements OnInit{
  @ViewChild('formRoupa') formRoupa! : NgForm;
  roupa! : Roupa;

  constructor(private http : HttpClient, private router : Router){}

  ngOnInit(): void {
    this.roupa = new Roupa();
  }

  inserir()
  {
    if(this.formRoupa.form.valid)
    { 
      // Não tem upload de imagem :(
      this.roupa.imagem = "";

      this.http.post<Roupa>("http://localhost:8080/roupas", this.roupa, httpHeader).subscribe((dados) => {
        this.roupa = dados;
        confirm(`Roupa inserida com sucesso!\nId da roupa: ${this.roupa.idRoupa}`);
        this.router.navigate(['/funcionario/roupa/listar']);
      });
    }
  }
}
