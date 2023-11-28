import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pedido } from 'src/app/shared';

@Injectable({
  providedIn: 'root'
})
export class PedidoService {

  constructor(private httpClient: HttpClient) { }

  BASE_URL = "http://localhost:8080/pedido/";

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  public getAllPedidos(): Observable<Pedido[]> {
    return this.httpClient.get<Pedido[]>(this.BASE_URL);
  }

  public getPedidoById(id: number): Observable<Pedido> {
    return this.httpClient.get<Pedido>(this.BASE_URL + id);
  }

  public addPedido(pedido: Pedido): Observable<Pedido> {
    return this.httpClient.post<Pedido>(this.BASE_URL, JSON.stringify(pedido), this.httpOptions);
  }

  public updatePedido(pedido: Pedido): Observable<Pedido> {
    return this.httpClient.put<Pedido>(this.BASE_URL + pedido.idPedido, JSON.stringify(pedido), this.httpOptions);
  }

  public deletePedido(id: number): Observable<Pedido> {
    return this.httpClient.delete<Pedido>(this.BASE_URL + id);
  }


}
