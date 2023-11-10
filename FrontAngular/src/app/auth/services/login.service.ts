import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Cliente, Login } from 'src/app/shared';

const LS_CHAVE: string = 'usuarioLogado';
@Injectable({
  providedIn: 'root',
})
export class LoginService {
  constructor() {}

  public get usuarioLogado(): Cliente {
    let usu = localStorage[LS_CHAVE];
    return usu ? JSON.parse(localStorage[LS_CHAVE]) : null;
  }
  public set usuarioLogado(usuario: Cliente) {
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
