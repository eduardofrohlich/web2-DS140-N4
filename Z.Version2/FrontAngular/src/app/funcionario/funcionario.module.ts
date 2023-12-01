import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TelaInicialFuncComponent } from './tela-inicial-func/tela-inicial-func.component';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { VisualizaPedidoComponent } from './visualiza-pedido/visualiza-pedido.component';
import { ListarFuncionarioComponent } from './listar-funcionario/listar-funcionario.component';
import { CadastrarFuncionarioComponent } from './cadastrar-funcionario/cadastrar-funcionario.component';
import { EditarFuncionarioComponent } from './editar-funcionario/editar-funcionario.component';
import { DatePipe } from '@angular/common';
import { ListarRoupaComponent } from './listar-roupa/listar-roupa.component';
import { CadastrarRoupaComponent } from './cadastrar-roupa/cadastrar-roupa.component';
import { EditarRoupaComponent } from './editar-roupa/editar-roupa.component';

@NgModule({
  declarations: [
    TelaInicialFuncComponent,
    VisualizaPedidoComponent,
    ListarFuncionarioComponent,
    CadastrarFuncionarioComponent,
    EditarFuncionarioComponent,
    ListarRoupaComponent,
    CadastrarRoupaComponent,
    EditarRoupaComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule
  ],
  providers: [
    DatePipe
  ]
})
export class FuncionarioModule { }
