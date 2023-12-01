import { Component, OnInit, ViewChild} from '@angular/core';
import { Roupa } from 'src/app/shared';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { HttpHeaders } from '@angular/common/http';
import { Router, ActivatedRoute } from '@angular/router';

const httpHeader = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Component({
  selector: 'app-editar-roupa',
  templateUrl: './editar-roupa.component.html',
  styleUrls: ['./editar-roupa.component.css']
})
export class EditarRoupaComponent implements OnInit{
  @ViewChild('formRoupa') formRoupa! : NgForm;
  roupa! : Roupa;

  constructor(private http : HttpClient, private router : Router, private route : ActivatedRoute){}

  ngOnInit(): void {
    let id = +this.route.snapshot.params['id'];
    this.http.get<Roupa>(`http://localhost:8080/roupas/${id}`).subscribe((dados) => this.roupa = dados);
  }

  inserir()
  {
    if(this.formRoupa.form.valid)
    { 
      // Não tem upload de imagem :(
      this.roupa.imagem = "";

      this.http.put<Roupa>(`http://localhost:8080/roupas/${this.roupa.idRoupa}`, this.roupa, httpHeader).subscribe((dados) => {
        this.roupa = dados;
        confirm(`Roupa editada com sucesso!\nId da roupa: ${this.roupa.idRoupa}`);
        this.router.navigate(['/funcionario/roupa/listar']);
      });
    }
  }
}
