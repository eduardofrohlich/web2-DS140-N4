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

  dataNascForHttp (dataNasc: string | undefined): string {
    if (dataNasc === undefined) {
      return '';
    }
    const data = dataNasc.split('/');
    return data[0] + '-' + data[1] + '-' + data[2];
  }
  editarFuncionario(funcionario: Funcionario): Observable<any> {
    const nome = funcionario.nome;
    const email = funcionario.email;
    const dataNasc = this.dataNascForHttp(funcionario.dataNascimento);
    const senha = funcionario.senha;
    const url = 'http://localhost:8080/funcionarios/editar/' + funcionario.idFuncionario + '/' + nome + '/' + email + '/' + dataNasc + '/' + senha;
    return this.http.get<any>(url, httpHeader);
  }



}
