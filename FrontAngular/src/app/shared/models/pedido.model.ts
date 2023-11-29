import { Cliente } from "./cliente.model";
import { RoupasPedido } from "./roupas-pedido.model";

export class Pedido {
    constructor(
        public idPedido? : number,
        public cliente? : Cliente,
        public roupas? : RoupasPedido[],
        public pedidoStatus? : string,
        public valorTotal? : number,
        public prazoEntrega? : number,
        public dataHora? : string
    ){}
}
