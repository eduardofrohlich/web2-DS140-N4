import { Component, OnInit } from '@angular/core';
import { Roupa } from 'src/app/shared';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-listar-roupa',
  templateUrl: './listar-roupa.component.html',
  styleUrls: ['./listar-roupa.component.css']
})
export class ListarRoupaComponent implements OnInit{
  roupas! : Roupa[];

  constructor(private http : HttpClient){}

  ngOnInit(): void {
    this.roupas = [];

    this.http.get<Roupa[]>("http://localhost:8080/roupas").subscribe((dados) => this.roupas = dados);
  }

  remover(roupa : Roupa)
  {
    if(confirm(`Deseja remover a roupa ${roupa.nomeRoupa} ?`))
    {
      this.http.delete<Roupa>(`http://localhost:8080/roupas/${roupa.idRoupa}`).subscribe((dados) => {
        roupa = dados;

        let auxRoupa : Roupa[] = [];

        this.roupas.forEach((obj, index, objs) => {
          if(obj.idRoupa !== roupa.idRoupa)
            auxRoupa.push(obj);
        });

        this.roupas = auxRoupa;
      });
    }
  }
}
