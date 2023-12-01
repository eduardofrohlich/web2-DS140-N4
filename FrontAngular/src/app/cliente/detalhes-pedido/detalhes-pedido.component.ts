import { Pedido, Roupa, RoupasPedido } from 'src/app/shared';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { PedidosService } from 'src/app/funcionario/services/pedidos.service';

@Component({
  selector: 'app-detalhes-pedido',
  templateUrl: './detalhes-pedido.component.html',
  styleUrls: ['./detalhes-pedido.component.css']
})
export class DetalhesPedidoComponent {

  pedido!: Pedido;
  id!: any;

  constructor(private http: HttpClient, private pedidosService: PedidosService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = +this.route.snapshot.params['id'];
    this.http.get("http://localhost:8080/pedidos/" + this.id).subscribe((dados) => this.pedido = dados);
  }

  return() {
    this.router.navigate(['/cliente/pedidos'], { relativeTo: this.route });
  }
  getStringRoupas(roupas: RoupasPedido[] | undefined): string {
    if (roupas) {
      let stringBuilder = "";
      for (let i = 0; i < roupas.length; i++) {
        const roupa = roupas[i]?.roupa; 
        if (roupa && roupa?.nomeRoupa) {
          stringBuilder += roupa.nomeRoupa;
          if (i !== roupas.length - 1) {
            stringBuilder += ", ";
          }
        }
      }
      return stringBuilder;
    }
    return "";
  }


}
