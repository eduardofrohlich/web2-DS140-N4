import { Injectable } from '@angular/core';
import {
  CanActivate,
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
  UrlTree,
  Router,
} from '@angular/router';
import { Observable } from 'rxjs';
import { LoginService } from './services/login.service';
@Injectable({
  providedIn: 'root',
})
export class AuthGuard implements CanActivate {
  constructor(private loginService: LoginService, private router: Router) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ):
    | Observable<boolean | UrlTree>
    | Promise<boolean | UrlTree>
    | boolean
    | UrlTree {
    const usuarioLogado = this.loginService.usuarioLogado;
    let url = state.url;
    if (usuarioLogado) {
      if (
        route.data?.['role'] &&
        route.data?.['role'].indexOf(usuarioLogado.perfil) === -1
      ) {
        this.router.navigate(['/login'], {
          queryParams: { error: 'Proibido o acesso a ' + url },
        });
        return false;
      }
      return true;
    }
    this.router.navigate(['/login'], {
      queryParams: { error: 'Deve fazer o login antes de acessar ' + url },
    });
    return false;
  }
}
