import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RelatorioComponent } from './relatorio/relatorio.component';
import { RelatorioClienteComponent } from './relatorio-cliente/relatorio-cliente.component';
import { RelatorioReceitaComponent } from './relatorio-receita/relatorio-receita.component';
import { RelatorioClienteFielComponent } from './relatorio-cliente-fiel/relatorio-cliente-fiel.component';
import { RouterModule } from '@angular/router';


@NgModule({
  declarations: [
    RelatorioComponent,
    RelatorioClienteComponent,
    RelatorioReceitaComponent,
    RelatorioClienteFielComponent
  ],
  imports: [
    CommonModule,
    RouterModule
  ]
})
export class RelatoriosModule { }
