import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PagarPedidoComponent } from './pagar-pedido/pagar-pedido.component';
import { PedidoOnlineComponent } from './pedido-online/pedido-online.component';
import { PedidoOnlineService } from './services/pedido-online.service';
import { RouterModule } from '@angular/router';
import { MeusPedidosComponent } from './meus-pedidos/meus-pedidos.component';
import { EsqueceuSenhaComponent } from './esqueceu-senha/esqueceu-senha.component';
import { CadastrarClienteComponent } from './cadastrar-cliente/cadastrar-cliente.component';

@NgModule({
  declarations: [
    PagarPedidoComponent,
    PedidoOnlineComponent,
    MeusPedidosComponent,
    EsqueceuSenhaComponent,
    CadastrarClienteComponent
  ],
  imports: [
    CommonModule,
    RouterModule
  ],
  providers: [
    PedidoOnlineService
  ]
})
export class ClienteModule { }
