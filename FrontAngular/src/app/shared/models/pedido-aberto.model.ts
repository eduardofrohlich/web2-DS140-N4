export class PedidoAberto {
  constructor(
    public numPedido?: string,
    public nomeCliente?: string,
    public dataPedido?: string,
    public status?: string,
    public prazo?: string,
    public valorTotal?: string,
  ) { }
}
