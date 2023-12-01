import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, catchError, map, throwError } from 'rxjs';
import { Funcionario } from 'src/app/shared';


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

  excluirFuncionario(id: number | undefined): Observable<any> {
    const url = 'http://localhost:8080/funcionarios/excluir/' + id;
    return this.http.get<any>(url, httpHeader).pipe(
      catchError((error) => {
        console.error('Erro ao obter funcionarios:', error);
        throw error;
      })
    );
  }

  editarFuncionario(funcionario: Funcionario): Observable<any> {
    const url = 'http://localhost:8080/funcionarios/editar';
    return this.http.post<Funcionario>(url, funcionario, httpHeader).pipe(
      catchError((error) => {
        console.error('Erro ao editar funcionario:', error);
        throw error;
      })
    );
  }
  


}
