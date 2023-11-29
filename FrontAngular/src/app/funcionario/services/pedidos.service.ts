import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, catchError, map, throwError } from 'rxjs';

const httpHeader = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})

export class PedidosService {

  constructor(private http: HttpClient) { }


  getAbertos(): Observable<any> {
    return this.http.get<any>('http://localhost:8080/pedidos/abertos', httpHeader).pipe(
      catchError((error) => {
        console.error('Erro ao obter clientes:', error);
        throw error;
      })
    );
  }


}
