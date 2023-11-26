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
  private baseUrl = 'http://localhost:8080/relatorios/receita'; // Substitua pela URL do seu backend

  constructor(private http: HttpClient) {}

  getReceita(dataInicial: string, dataFinal: string): Observable<Receita> {
    const url = `${this.baseUrl}`;
    const body = { dataInicial, dataFinal };

    return this.http.post<any>('http://localhost:8080/relatorios/receita', body);
  }
  getClientes(): Observable<any> {
    return this.http.get<any>('http://localhost:8080/relatorios/clientes', httpHeader).pipe(
      catchError((error) => {
        console.error('Erro ao obter clientes:', error);
        throw error; // Pode tratar ou relançar o erro conforme necessário
      })
    );
  }
  
  getClientesFieis(): Observable<any>{
    return this.http.get<any>('http://localhost:8080/relatorios/clientes-fieis', httpHeader).pipe(
      catchError((error) => {
        console.error('Erro ao obter clientes:', error);
        throw error; // Pode tratar ou relançar o erro conforme necessário
      })
    );
  }
}