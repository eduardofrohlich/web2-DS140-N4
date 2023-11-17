import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ManutencaoFuncionariosComponent } from './manutencao-funcionarios/manutencao-funcionarios.component';
import { TelaInicialFuncComponent } from './tela-inicial-func/tela-inicial-func.component';
import { ManutencaoRoupasComponent } from './manutencao-roupas/manutencao-roupas.component';
import { VisualizaPedidoComponent } from './visualiza-pedido/visualiza-pedido.component';



@NgModule({
  declarations: [
    ManutencaoFuncionariosComponent,
    TelaInicialFuncComponent,
    ManutencaoRoupasComponent,
    VisualizaPedidoComponent
  ],
  imports: [
    CommonModule
  ]
})
export class FuncionarioModule { }
