import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PagarPedidoComponent } from './cliente/pagar-pedido/pagar-pedido.component';
import { PedidoOnlineComponent } from './cliente/pedido-online/pedido-online.component';
import { TelaInicialComponent } from './cliente/tela-inicial/tela-inicial.component';
import { LoginComponent } from './auth/login/login.component';
import { RelatorioComponent } from './funcionario/relatorio/relatorio.component';
import { RelatorioClienteComponent } from './funcionario/relatorio-cliente/relatorio-cliente.component';
import { RelatorioReceitaComponent } from './funcionario/relatorio-receita/relatorio-receita.component';
import { RelatorioClienteFielComponent } from './funcionario/relatorio-cliente-fiel/relatorio-cliente-fiel.component';
import { TelaInicialFuncComponent } from './funcionario/tela-inicial-func/tela-inicial-func.component';
import { VisualizaPedidoComponent } from './funcionario/visualiza-pedido/visualiza-pedido.component';
import { ManutencaoFuncionariosComponent } from './funcionario/manutencao-funcionarios/manutencao-funcionarios.component';
import { EditarFuncionarioComponent } from './funcionario/editar-funcionario/editar-funcionario.component';
import { CadastrarFuncionarioComponent } from './funcionario/cadastrar-funcionario/cadastrar-funcionario.component';
import { ManutencaoRoupasComponent } from './funcionario/manutencao-roupas/manutencao-roupas.component';
import { EditarRoupaComponent } from './funcionario/editar-roupa/editar-roupa.component';
import { EsqueceuSenhaComponent } from './cliente/esqueceu-senha/esqueceu-senha.component';
import { CadastrarRoupaComponent } from './funcionario/cadastrar-roupa/cadastrar-roupa.component';
import { AuthGuard } from './auth/auth.guard';
import { LoginRoutes } from './auth/auth-routing.module';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', redirectTo: 'login' },
  { path: 'login', redirectTo: 'login', pathMatch: 'full' },
  {
    path: 'cliente/pagarpedido/:id',
    component: PagarPedidoComponent,
    canActivate: [AuthGuard],
    data: { role: 'CLIENTE' },
  },
  {
    path: 'cliente/pedidoonline',
    component: PedidoOnlineComponent,
    canActivate: [AuthGuard],
    data: { role: 'CLIENTE' },
  },
  {
    path: 'cliente',
    component: TelaInicialComponent,
    canActivate: [AuthGuard],
    data: { role: 'CLIENTE' },
  },
  {
    path: 'funcionario/relatorio',
    component: RelatorioComponent,
    canActivate: [AuthGuard],
    data: { role: 'FUNCIONARIO' },
  },
  {
    path: 'funcionario/relatorio/cliente',
    component: RelatorioClienteComponent,
    canActivate: [AuthGuard],
    data: { role: 'FUNCIONARIO' },
  },
  {
    path: 'funcionario/relatorio/receita',
    component: RelatorioReceitaComponent,
    canActivate: [AuthGuard],
    data: { role: 'FUNCIONARIO' },
  },
  {
    path: 'funcionario/relatorio/cliente-fiel',
    component: RelatorioClienteFielComponent,
    canActivate: [AuthGuard],
    data: { role: 'FUNCIONARIO' },
  },
  {
    path: 'funcionario',
    component: TelaInicialFuncComponent,
    canActivate: [AuthGuard],
    data: { role: 'FUNCIONARIO' },
  },
  {
    path: 'funcionario/pedidos',
    component: VisualizaPedidoComponent,
    canActivate: [AuthGuard],
    data: { role: 'FUNCIONARIO' },
  },
  {
    path: 'funcionario/manutencao-func',
    component: ManutencaoFuncionariosComponent,
    canActivate: [AuthGuard],
    data: { role: 'FUNCIONARIO' },
  },
  {
    path: 'funcionario/editar-func',
    component: EditarFuncionarioComponent,
    canActivate: [AuthGuard],
    data: { role: 'FUNCIONARIO' },
  },
  {
    path: 'funcionario/cadastrar-func',
    component: CadastrarFuncionarioComponent,
    canActivate: [AuthGuard],
    data: { role: 'FUNCIONARIO' },
  },
  {
    path: 'funcionario/manutencao-roupas',
    component: ManutencaoRoupasComponent,
    canActivate: [AuthGuard],
    data: { role: 'FUNCIONARIO' },
  },
  {
    path: 'funcionario/editar-roupa',
    component: EditarRoupaComponent,
    canActivate: [AuthGuard],
    data: { role: 'FUNCIONARIO' },
  },
  {
    path: 'esqueceu-senha',
    component: EsqueceuSenhaComponent,
    canActivate: [AuthGuard],
    data: { role: 'CLIENTE' },
  },
  {
    path: 'funcionario/cadastrar-roupa',
    component: CadastrarRoupaComponent,
    canActivate: [AuthGuard],
    data: { role: 'FUNCIONARIO' },
  },
  ...LoginRoutes,
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
