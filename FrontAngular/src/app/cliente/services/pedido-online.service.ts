import { Injectable } from '@angular/core';
import { RoupasPedido } from 'src/app/shared';
import { Pedido } from 'src/app/shared';

@Injectable({
  providedIn: 'root'
})
export class PedidoOnlineService {

  constructor() { }

  adicionar(roupa : RoupasPedido, pedido : Pedido) : void
  {
    if(roupa.qtdRoupa != undefined && roupa.valorTotalRoupa != undefined && roupa.roupa?.valor != undefined && pedido.valorTotal != undefined)
    {
      roupa.qtdRoupa += 1;
      roupa.valorTotalRoupa += roupa.roupa.valor; 

      pedido.valorTotal += roupa.roupa.valor;
    }
  }

  remover(roupa : RoupasPedido, pedido : Pedido) : void
  {
    if(roupa.qtdRoupa != undefined && roupa.valorTotalRoupa != undefined && roupa.roupa?.valor != undefined && pedido.valorTotal != undefined)
    {
      if(roupa.qtdRoupa > 0)
      {
        roupa.qtdRoupa -= 1;
        roupa.valorTotalRoupa -= roupa.roupa.valor; 

        pedido.valorTotal -= roupa.roupa.valor;
      }
    }
  }

  atualizarPrazoPedido(roupas : RoupasPedido[], pedido : Pedido) : void
  {
    pedido.prazoEntrega = 0;
    
    roupas.forEach((obj, index, objs) => {
      if(obj.qtdRoupa != undefined && obj.qtdRoupa > 0)
      {
        if(obj.roupa?.prazo != undefined && pedido.prazoEntrega != undefined && obj.roupa.prazo > pedido.prazoEntrega)
          pedido.prazoEntrega = obj.roupa.prazo;
      }
    });
  }
}
