import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, catchError, map, throwError } from 'rxjs';

const httpHeader = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({ providedIn: 'root' })
export class PedidosService {


  constructor(private http: HttpClient) { }

  getPedidos(): Observable<any> {
    return this.http.get<any>('http://localhost:8080/pedidos/todos', httpHeader).pipe(
      catchError((error) => {
        console.error('Erro ao obter clientes:', error);
        throw error;
      })
    );
  }

  getAbertos(): Observable<any> {
    return this.http.get<any>('http://localhost:8080/pedidos/abertos', httpHeader).pipe(
      catchError((error) => {
        console.error('Erro ao obter clientes:', error);
        throw error;
      })
    );
  }


  getAbertosByUser(idCliente: number | undefined): Observable<any> {
    return this.http.get<any>('http://localhost:8080/pedidos/abertos/' + idCliente, httpHeader).pipe(
      catchError((error) => {
        console.error('Erro ao obter clientes:', error);
        throw error;
      })
    );
  }

  atualizarEstado(pedidoId: number | undefined, estado: string | undefined) {
    if (pedidoId === undefined) {
      throw new Error('ID do pedido não fornecido');
    }
    const idStr: string = pedidoId.toString();
    const targetEstado = getNextEstado(estado);

    this.http.get<any>(`http://localhost:8080/pedidos/${idStr}/estado/${targetEstado}`, {}).pipe(
      catchError((error) => {
        console.error(`Erro ao atualizar para ${targetEstado}:`, error);
        throw error;
      })
    ).subscribe(() => {
      console.log(`Atualização para ${targetEstado} concluída`);
    });
  }

}
function getNextEstado(estado: string | undefined) {
  switch (estado) {
    case 'ABERTO':
      return 'RECOLHIDO';
    case 'RECOLHIDO':
      return 'AGUARDANDO_PAGAMENTO';
    case 'AGUARDANDO_PAGAMENTO':
      return 'PAGO';
    case 'PAGO':
      return 'FINALIZADO';
    case 'CANCELAR':
      return 'CANCELADO';
    default:
      return 'ABERTO';
  }
}

