import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PagarPedidoComponent } from './cliente/pagar-pedido/pagar-pedido.component';
import { PedidoOnlineComponent } from './cliente/pedido-online/pedido-online.component';
import { TelaInicialComponent } from './cliente/tela-inicial/tela-inicial.component';
import { LoginComponent } from './auth/login/login.component';
import { RelatorioComponent } from './funcionario/relatorios/relatorio/relatorio.component';
import { RelatorioClienteComponent } from './funcionario/relatorios/relatorio-cliente/relatorio-cliente.component';
import { RelatorioReceitaComponent } from './funcionario/relatorios/relatorio-receita/relatorio-receita.component';
import { RelatorioClienteFielComponent } from './funcionario/relatorios/relatorio-cliente-fiel/relatorio-cliente-fiel.component';
import { MenuSidebarComponent } from './cliente/menu-sidebar/menu-sidebar.component';
import { TelaInicialFuncComponent } from './funcionario/tela-inicial-func/tela-inicial-func.component';
import { VisualizaPedidoComponent } from './funcionario/visualiza-pedido/visualiza-pedido.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: 'cliente/pedidoonline', pathMatch: 'full' },
  { path: 'cliente/pagarpedido/:id', component: PagarPedidoComponent },
  { path: 'cliente/pedidoonline', component: PedidoOnlineComponent },
  { path: 'cliente/inicial', component: TelaInicialComponent },
  { path: 'funcionario/relatorio', component: RelatorioComponent },
  { path: 'funcionario/relatorio/cliente', component: RelatorioClienteComponent },
  { path: 'funcionario/relatorio/receita', component: RelatorioReceitaComponent },
  { path: 'funcionario/relatorio/cliente-fiel', component: RelatorioClienteFielComponent },
  { path: 'funcionario/inicial', component: TelaInicialFuncComponent },
  { path: 'funcionario/visualiza-pedido', component: VisualizaPedidoComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
