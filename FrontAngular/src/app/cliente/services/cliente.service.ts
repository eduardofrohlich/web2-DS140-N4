import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { Funcionario } from 'src/app/shared';

const httpHeader = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class ClienteService {


  constructor(private http: HttpClient) { }
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
    const url = 'http://localhost:8080/clientes/cadastrar/' + nome + '/' + email + '/' +
      senha + '/' + endereco + '/' + telefone + '/' + cpf;
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
}
