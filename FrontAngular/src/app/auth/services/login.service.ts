import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Cliente, Login, Usuario } from 'src/app/shared';

const LS_CHAVE: string = 'usuarioLogado';
@Injectable({
  providedIn: 'root',
})
export class LoginService {
  BASE_URL = 'http://localhost:8080/login/';
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };
  constructor(private httpClient: HttpClient) {}

  public get usuarioLogado(): Usuario {
    let usu = localStorage[LS_CHAVE];
    return usu ? JSON.parse(localStorage[LS_CHAVE]) : null;
  }
  public set usuarioLogado(usuario: Usuario) {
    localStorage[LS_CHAVE] = JSON.stringify(usuario);
  }
  logout() {
    delete localStorage[LS_CHAVE];
  }

  login(login: Login): Observable<Cliente | null> {
    let usu = new Cliente(
      1,
      'Endereco XV',
      login.senha,
      login.email,
      'João',
      '11111111111',
      '4136210493'
    );
    if (login.email == 'joao@gmail.com') {
      return of(usu);
    } else {
      return of(null);
    }
  }
}
