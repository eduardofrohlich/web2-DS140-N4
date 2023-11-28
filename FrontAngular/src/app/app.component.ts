import { Component } from '@angular/core';
import { LoginService } from './auth/services/login.service';
import { Router } from '@angular/router';
import { Usuario } from './shared/models/usuario.model~';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  constructor(private loginService: LoginService, private router: Router) {}

  get usuarioLogado(): Usuario | null {
    return this.loginService.usuarioLogado;
  }

  logout() {
    this.loginService.logout();
    this.router.navigate(['/login']);
  }

  title = 'FrontAngular';
}
