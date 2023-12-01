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
import { CadastrarClienteComponent } from './cliente/cadastrar-cliente/cadastrar-cliente.component';
import { DetalhesFuncionarioComponent } from './funcionario/detalhes-funcionario/detalhes-funcionario.component';
import { DetalhesRoupaComponent } from './funcionario/detalhes-roupa/detalhes-roupa.component';
import { LoginRoutes } from './auth/auth-routing.module';
import { AuthGuard } from './auth/auth.guard';
import { Perfil } from './shared/models/usuario.model~';
import { MeusPedidosComponent } from './cliente/meus-pedidos/meus-pedidos.component';
import { DetalhesPedidoComponent } from './cliente/detalhes-pedido/detalhes-pedido.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'cliente/pagarpedido/:id', component: PagarPedidoComponent },
  { path: 'cliente/pedidoonline', component: PedidoOnlineComponent },
  {
    path: 'cliente/:id',
    component: TelaInicialComponent,
  },
  {
    path: 'cliente/pedidos/:id',
    component: MeusPedidosComponent,
  },
  {
    path: 'cliente/meus-pedidos/detalhe/:id/:cliente',
    component: DetalhesPedidoComponent,
  },

  { path: 'funcionario/relatorio', component: RelatorioComponent },
  {
    path: 'funcionario/relatorio/cliente',
    component: RelatorioClienteComponent,
  },
  {
    path: 'funcionario/relatorio/receita',
    component: RelatorioReceitaComponent,
  },
  {
    path: 'funcionario/relatorio/cliente-fiel',
    component: RelatorioClienteFielComponent,
  },
  {
    path: 'funcionario',
    component: TelaInicialFuncComponent,
  },
  { path: 'funcionario/pedidos', component: VisualizaPedidoComponent },
  {
    path: 'funcionario/manutencao/funcionarios',
    component: ManutencaoFuncionariosComponent,
  },
  {
    path: 'funcionario/cadastrar-funcionario',
    component: CadastrarFuncionarioComponent,
  },
  {
    path: 'funcionario/manutencao/roupas',
    component: ManutencaoRoupasComponent,
  },
  { path: 'funcionario/editar-roupa', component: EditarRoupaComponent },
  { path: 'esqueceu-senha', component: EsqueceuSenhaComponent },
  { path: 'funcionario/cadastrar-roupa', component: CadastrarRoupaComponent },
  { path: 'logout', component: LoginComponent },
  { path: 'cliente/cadastrar-cliente', component: CadastrarClienteComponent },
  {
    path: 'funcionario/manutencao/funcionarios/detalhes-funcionario/:id',
    component: DetalhesFuncionarioComponent,
  },
  {
    path: 'funcionario/manutencao/funcionarios/editar-funcionario/:id',
    component: EditarFuncionarioComponent,
  },
  {
    path: 'funcionario/manutencao/roupas/detalhes-roupa/:id',
    component: DetalhesRoupaComponent,
  },
  {
    path: 'funcionario/manutencao/roupas/editar-roupa/:id',
    component: EditarRoupaComponent,
  },
  ...LoginRoutes,
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { }
