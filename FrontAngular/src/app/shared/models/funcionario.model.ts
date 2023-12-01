import { Endereco } from "./endereco.model";

export class Funcionario {
    constructor(
        public idFuncionario? : number,
        public endereco? : string,
        public senha? : string,
        public email? : string,
        public nome? : string,
        public cpf? : string,
        public telefone? : string,
        public dataNascimento? : string
    ){}
}
