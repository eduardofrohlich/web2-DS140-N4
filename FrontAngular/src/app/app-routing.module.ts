import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PagarPedidoComponent } from './cliente/pagar-pedido/pagar-pedido.component';
import { PedidoOnlineComponent } from './cliente/pedido-online/pedido-online.component';
import { TelaInicialComponent } from './cliente/tela-inicial/tela-inicial.component';
import { LoginComponent } from './auth/login/login.component';
import { MenuSidebarComponent } from './cliente/menu-sidebar/menu-sidebar.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: 'cliente/pedidoonline', pathMatch: 'full' },
  { path: 'cliente/pagarpedido/:id', component: PagarPedidoComponent },
  { path: 'cliente/pedidoonline', component: PedidoOnlineComponent },
  { path: 'cliente/inicial', component: TelaInicialComponent },
  { path: 'funcionario/inicial', component: TelaInicialComponent },


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
