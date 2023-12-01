import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Login } from 'src/app/shared';
import { Perfil } from 'src/app/shared/models/usuario.model~';
import { LoginService } from '../services/login.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  login!: Login;
  loading: boolean = false;
  message!: string | undefined;
  email : any;
  senha : any;

  constructor(
    private loginService: LoginService,
    private router: Router,
    private route: ActivatedRoute
  ) {
    if (this.loginService.usuarioLogado) {
      if (this.loginService.usuarioLogado.perfil == 1) {
        this.router.navigate(['/cliente']);
      } else if (this.loginService.usuarioLogado.perfil == 2) {
        this.router.navigate(['/funcionario']);
      }
    }
  }

  ngOnInit(): void {
    this.route.queryParams.subscribe((params) => {
      this.message = params['error'];
    });
  }

  logar(): void {
    this.login = new Login(this.email, this.senha);
    this.loading = true;
      this.loginService.login(this.login).subscribe((usu) => {
        if (usu != null) {
          this.loginService.usuarioLogado = usu;
          this.loading = false;
          if (usu.perfil === "CLIENTE") {
            this.router.navigate(['/cliente']);
          } else if (usu.perfil === "FUNCIONARIO") {
            this.router.navigate(['/funcionario']);
          }
        } else {
          this.message = 'Usuário/Senha inválidos.';
          this.loading = false;
        }
      });
    }

}
