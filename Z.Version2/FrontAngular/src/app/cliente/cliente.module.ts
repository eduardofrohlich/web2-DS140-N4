import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PagarPedidoComponent } from './pagar-pedido/pagar-pedido.component';
import { PedidoOnlineComponent } from './pedido-online/pedido-online.component';
import { PedidoOnlineService } from './services/pedido-online.service';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { TelaInicialComponent } from './tela-inicial/tela-inicial.component';
import { MeusPedidosComponent } from './meus-pedidos/meus-pedidos.component';
import { CadastrarClienteComponent } from './cadastrar-cliente/cadastrar-cliente.component';

@NgModule({
  declarations: [
    PagarPedidoComponent,
    PedidoOnlineComponent,
    TelaInicialComponent,
    MeusPedidosComponent,
    CadastrarClienteComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule
  ],
  providers: [
    PedidoOnlineService
  ]
})
export class ClienteModule { }
