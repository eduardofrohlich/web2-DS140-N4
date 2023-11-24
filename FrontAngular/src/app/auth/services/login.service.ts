import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Login } from 'src/app/shared';
import { Usuario } from 'src/app/shared/models/usuario.model~';

const LS_CHAVE: string = 'usuarioLogado';
@Injectable({
  providedIn: 'root',
})
export class LoginService {
  constructor() {}

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

  login(login: Login): Observable<Usuario | null> {
    let usu = new Usuario(
      1,
      'Endereco XV',
      login.senha,
      login.email,
      'João',
      '11111111111',
      '4136210493',
      1
    );
    if (login.email == 'admin@email.com') {
      usu = new Usuario(
        1,
        'Endereco XV',
        login.senha,
        login.email,
        'João',
        '11111111111',
        '4136210493',
        2
      );
      return of(usu);
    } else {
      return of(null);
    }
  }
}
