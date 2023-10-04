import { Roupa } from "./roupa.model";

export class RoupasPedido {
    constructor(
        public roupa? : Roupa,
        public qtdRoupa? : number,
        public valorTotalRoupa? : number
    ){}
}
