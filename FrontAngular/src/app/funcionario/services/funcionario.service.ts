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
    const nome = funcionario.nome;
    const email = funcionario.email;
    const dataNasc = FuncionarioService.dataNascForHttp(funcionario.dataNascimento);
    const senha = funcionario.senha;
    const url = 'http://localhost:8080/funcionarios/editar/' + funcionario.idFuncionario
      + '/' + nome + '/' + email + '/' + dataNasc + '/' + senha;
    return this.http.get<any>(url, httpHeader);
  }

  adicionarFuncionario(funcionario: Funcionario): Observable<any> {
    const nome: string | undefined = funcionario.nome;
    const email = funcionario.email;
    const dataNasc = funcionario.dataNascimento?.replaceAll('/', '-');
    const senha = funcionario.senha;
    const cpf = funcionario.cpf;
    const telefone = funcionario.telefone;
    let endereco = funcionario.endereco?.replaceAll(' ', '-');
    if (endereco !== undefined) {
      endereco = this.removeAcentos(endereco);
    }
    const url = 'http://localhost:8080/funcionarios/cadastrar/' + nome + '/' + email + '/' +
      dataNasc + '/' + senha + '/' + endereco + '/' + telefone + '/' + cpf;
    if (funcionario.nome !== undefined && funcionario.email !== undefined && funcionario.senha !== undefined) {
      return this.http.get<any>(url, httpHeader);
    }
    return throwError('Erro ao cadastrar funcionario');
  }

  removeAcentos(str: string): string {
    const mapaAcentos: { [key: string]: string } = {
      'á': 'a',
      'à': 'a',
      'â': 'a',
      'ã': 'a',
      'é': 'e',
      'è': 'e',
      'ê': 'e',
      'í': 'i',
      'ì': 'i',
      'î': 'i',
      'ó': 'o',
      'ò': 'o',
      'ô': 'o',
      'õ': 'o',
      'ú': 'u',
      'ù': 'u',
      'û': 'u',
      'ç': 'c',
      'Á': 'A',
      'À': 'A',
      'Â': 'A',
      'Ã': 'A',
      'É': 'E',
      'È': 'E',
      'Ê': 'E',
      'Í': 'I',
      'Ì': 'I',
      'Î': 'I',
      'Ó': 'O',
      'Ò': 'O',
      'Ô': 'O',
      'Õ': 'O',
      'Ú': 'U',
      'Ù': 'U',
      'Û': 'U',
      'Ç': 'C',
    };

    return str.replace(/[áàâãéèêíìîóòôõúùûçÁÀÂÃÉÈÊÍÌÎÓÒÔÕÚÙÛÇ]/g, function (letra) {
      return mapaAcentos[letra];
    });
  }

  static dataNascForHttp(dataNasc: string | undefined): string {
    if (dataNasc === undefined) {
      return '';
    }
    const data = dataNasc.split('/');
    return data[0] + '-' + data[1] + '-' + data[2];
  }

}
