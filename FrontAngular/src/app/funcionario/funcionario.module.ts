import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ManutencaoFuncionariosComponent } from './manutencao-funcionarios/manutencao-funcionarios.component';
import { TelaInicialFuncComponent } from './tela-inicial-func/tela-inicial-func.component';
import { ManutencaoRoupasComponent } from './manutencao-roupas/manutencao-roupas.component';
import { VisualizaPedidoComponent } from './visualiza-pedido/visualiza-pedido.component';
import { RouterModule, Routes } from '@angular/router';
import { RelatorioComponent } from './relatorio/relatorio.component'
import { RelatorioReceitaComponent } from './relatorio-receita/relatorio-receita.component'
import { RelatorioClienteComponent } from './relatorio-cliente/relatorio-cliente.component'
import { RelatorioClienteFielComponent } from './relatorio-cliente-fiel/relatorio-cliente-fiel.component'
import { FormsModule } from '@angular/forms';
import { RelatorioService } from './services/relatorio.service';
@NgModule({
  declarations: [
    ManutencaoFuncionariosComponent,
    TelaInicialFuncComponent,
    ManutencaoRoupasComponent,
    VisualizaPedidoComponent,
    RelatorioComponent,
    RelatorioClienteComponent,
    RelatorioClienteFielComponent,
    RelatorioReceitaComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule
  ],
  providers: [
    RelatorioService
  ]
})

export class FuncionarioModule { }
