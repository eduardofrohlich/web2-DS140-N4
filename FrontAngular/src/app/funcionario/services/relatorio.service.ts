import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, catchError } from 'rxjs';
import { Receita } from 'src/app/shared/models/receita.model';


const httpHeader = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})

export class RelatorioService {

  constructor(private http: HttpClient) {}

  getReceita(dataInicial: string, dataFinal: string): Observable<any> {

    let url = 'http://localhost:8080/relatorios/receita';

    if (dataInicial && dataFinal) {
        url += `?dataInicial=${dataInicial}&dataFinal=${dataFinal}`;
    }
    return this.http.get<any>(url, httpHeader);
  }
  
  getClientes(): Observable<any> {
    return this.http.get<any>('http://localhost:8080/relatorios/clientes', httpHeader).pipe(
      catchError((error) => {
        console.error('Erro ao obter clientes:', error);
        throw error;
      })
    );
  }
  
  getClientesFieis(): Observable<any>{
    return this.http.get<any>('http://localhost:8080/relatorios/clientes-fieis', httpHeader).pipe(
      catchError((error) => {
        console.error('Erro ao obter clientes:', error);
        throw error;
      })
    );
  }
}