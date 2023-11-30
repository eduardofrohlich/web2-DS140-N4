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

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'cliente/pagarpedido/:id', component: PagarPedidoComponent },
  { path: 'cliente/pedidoonline', component: PedidoOnlineComponent },
  { path: 'cliente', component: TelaInicialComponent },
  { path: 'funcionario/relatorio', component: RelatorioComponent },
  { path: 'funcionario/relatorio/cliente', component: RelatorioClienteComponent },
  { path: 'funcionario/relatorio/receita', component: RelatorioReceitaComponent },
  { path: 'funcionario/relatorio/cliente-fiel', component: RelatorioClienteFielComponent },
  { path: 'funcionario', component: TelaInicialFuncComponent },
  { path: 'funcionario/visualiza-pedido', component: VisualizaPedidoComponent },
  { path: 'funcionario/manutencao-func', component: ManutencaoFuncionariosComponent  },
  { path: 'funcionario/editar-func', component: EditarFuncionarioComponent },
  { path: 'funcionario/cadastrar-func', component: CadastrarFuncionarioComponent },
  { path: 'funcionario/manutencao-roupas', component: ManutencaoRoupasComponent },
  { path: 'funcionario/editar-roupa', component: EditarRoupaComponent },
  { path: 'esqueceu-senha', component: EsqueceuSenhaComponent },
  { path: 'funcionario/cadastrar-roupa', component: CadastrarRoupaComponent },
  { path: 'cliente/cadastrar-cliente', component: CadastrarClienteComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})

export class AppRoutingModule {}
