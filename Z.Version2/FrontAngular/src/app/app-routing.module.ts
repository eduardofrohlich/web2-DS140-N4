import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PagarPedidoComponent } from './cliente/pagar-pedido/pagar-pedido.component';
import { PedidoOnlineComponent } from './cliente/pedido-online/pedido-online.component';
import { TelaInicialComponent } from './cliente/tela-inicial/tela-inicial.component';
import { MeusPedidosComponent } from './cliente/meus-pedidos/meus-pedidos.component';
import { CadastrarClienteComponent } from './cliente/cadastrar-cliente/cadastrar-cliente.component';
import { TelaInicialFuncComponent } from './funcionario/tela-inicial-func/tela-inicial-func.component';
import { VisualizaPedidoComponent } from './funcionario/visualiza-pedido/visualiza-pedido.component';
import { ListarFuncionarioComponent } from './funcionario/listar-funcionario/listar-funcionario.component';
import { CadastrarFuncionarioComponent } from './funcionario/cadastrar-funcionario/cadastrar-funcionario.component';
import { EditarFuncionarioComponent } from './funcionario/editar-funcionario/editar-funcionario.component';
import { ListarRoupaComponent } from './funcionario/listar-roupa/listar-roupa.component';
import { CadastrarRoupaComponent } from './funcionario/cadastrar-roupa/cadastrar-roupa.component';
import { EditarRoupaComponent } from './funcionario/editar-roupa/editar-roupa.component';

const routes: Routes = [
  {path: '', redirectTo: 'cliente/cadastrar', pathMatch: 'full'},
  {path: 'cliente/pedidoonline', component: PedidoOnlineComponent},
  {path: 'cliente/pagarpedido/:id', component: PagarPedidoComponent},
  {path: 'cliente/home', component: TelaInicialComponent},
  {path: 'cliente/meuspedidos', component: MeusPedidosComponent},
  {path: 'cliente/cadastrar', component: CadastrarClienteComponent},
  {path: 'funcionario/home', component: TelaInicialFuncComponent},
  {path: 'funcionario/visualizarpedido', component: VisualizaPedidoComponent},
  {path: 'funcionario/listar', component: ListarFuncionarioComponent},
  {path: 'funcionario/cadastrar', component: CadastrarFuncionarioComponent},
  {path: 'funcionario/editar/:id', component: EditarFuncionarioComponent},
  {path: 'funcionario/roupa/listar', component: ListarRoupaComponent},
  {path: 'funcionario/roupa/cadastrar', component: CadastrarRoupaComponent},
  {path: 'funcionario/roupa/editar/:id', component: EditarRoupaComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})

export class AppRoutingModule {}
