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

export class PedidosService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    let url = 'http://localhost:8080/pedidos/todos';
    return this.http.get<any>(url, httpHeader).pipe(
      catchError((error) => {
        console.error('Erro ao obter clientes:', error);
        throw error;
      })
    );
  }

  getAbertos(): Observable<any> {
    return this.http.get<any>('http://localhost:8080/pedidos/abertos', httpHeader).pipe(
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
