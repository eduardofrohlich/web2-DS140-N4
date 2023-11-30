export class Usuario {
  constructor(
    public id?: number,
    public endereco?: string,
    public senha?: string,
    public email?: string,
    public nome?: string,
    public cpf?: string,
    public telefone?: string,
    public perfil?: string
  ) {}
}
