import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, catchError, map, throwError } from 'rxjs';
import { Roupa } from 'src/app/shared';

const httpHeader = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class RoupaService {


  constructor(private http: HttpClient) { }

  getRoupas(): Observable<any> {
    return this.http.get<any>('http://localhost:8080/roupas', httpHeader).pipe(
      catchError((error) => {
        console.error('Erro ao obter clientes:', error);
        throw error;
      })
    );
  }

  excluirRoupa(id: number | undefined): Observable<any> {
    const url = 'http://localhost:8080/roupas/excluir/' + id;
    return this.http.get<any>(url, httpHeader).pipe(
      catchError((error) => {
        console.error('Erro ao excluir roupa:', error);
        throw error;
      })
    );
  }

  editarRoupa(roupa: Roupa): Observable<any> {
    const nome = roupa.nomeRoupa;
    const prazo = roupa.prazo;
    const preco = roupa.valor;
    const img = roupa.imagem;
    const url = 'http://localhost:8080/roupas/atualizar/' + roupa.idRoupa
      + '/' + nome + '/' + prazo + '/' + preco + '/' + img;
    return this.http.get<any>(url, httpHeader);
  }

  cadastrarRoupa(roupa: Roupa): Observable<any> {
    const nome = roupa.nomeRoupa;
    const prazo = roupa.prazo;
    const preco = roupa.valor;
    const img = roupa.imagem;
    const url = 'http://localhost:8080/roupas/cadastrar/' + nome + '/' + prazo + '/' + preco + '/' + img;
    return this.http.get<any>(url, httpHeader);
  }

}
