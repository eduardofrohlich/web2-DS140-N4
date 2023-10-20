import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PagarPedidoComponent } from './pagar-pedido/pagar-pedido.component';
import { PedidoOnlineComponent } from './pedido-online/pedido-online.component';
import { PedidoOnlineService } from './services/pedido-online.service';


@NgModule({
  declarations: [
    PagarPedidoComponent,
    PedidoOnlineComponent
  ],
  imports: [
    CommonModule
  ],
  providers: [
    PedidoOnlineService
  ]
})
export class ClienteModule { }
