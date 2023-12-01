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
export class FuncionarioService {


  constructor(private http: HttpClient) { }

  getFuncionarios(): Observable<any> {
    return this.http.get<any>('http://localhost:8080/funcionarios', httpHeader).pipe(
      catchError((error) => {
        console.error('Erro ao obter funcionarios:', error);
        throw error;
      })
    );
  }


  getFuncionarioById(id: number): Observable<any> {
    return 1;
  }

}
