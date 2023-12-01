export class Endereco {
  constructor(
    public idEndereco?: number,
    public estado?: string,
    public cidade?: string,
    public cep?: string,
    public rua?: string,
    public numero?: number,
    public bairro?: string
  ) { }

  public static getString(rua: any, numero: any, bairro: any, cidade: any, estado: any): string {
    return rua + ', ' + numero + ', ' + bairro + ', ' + cidade + ', ' + estado;
  }

  public static generateString(rua: any, numero: any, bairro: any, cidade: any, estado: any): string {
    return rua + '-' + numero + '-' + bairro + '-' + cidade + '-' + estado;
  }
}
