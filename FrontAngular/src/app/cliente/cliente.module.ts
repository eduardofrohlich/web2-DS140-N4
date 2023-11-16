import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PagarPedidoComponent } from './pagar-pedido/pagar-pedido.component';
import { PedidoOnlineComponent } from './pedido-online/pedido-online.component';
import { PedidoOnlineService } from './services/pedido-online.service';
import { MenuSidebarComponent } from './menu-sidebar/menu-sidebar.component';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    PagarPedidoComponent,
    PedidoOnlineComponent,
    MenuSidebarComponent
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
