import { Endereco } from "./endereco.model";

export class Cliente {
    constructor(
        public idCliente? : number,
        public endereco? : Endereco,
        public senha? : string,
        public email? : string,
        public nome? : string,
        public cpf? : string,
        public telefone? : string
    ){}
}
