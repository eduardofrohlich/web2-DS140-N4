import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PagarPedidoComponent } from './cliente/pagar-pedido/pagar-pedido.component';
import { PedidoOnlineComponent } from './cliente/pedido-online/pedido-online.component';

const routes: Routes = [
  {path: '', redirectTo: 'cliente/pedidoonline', pathMatch: 'full'},
  {path: 'cliente/pagarpedido', component: PagarPedidoComponent},
  {path: 'cliente/pedidoonline', component: PedidoOnlineComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
