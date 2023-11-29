package backend.lavanderia.pedido.dto;

public class PedidoAbertoDTO {

    private String numPedido;
    private String nomeCliente;
    private String dataPedido;
    private String status;
    private String prazo;
    private String valorTotal;


    public PedidoAbertoDTO() {
        super();
    }

    public PedidoAbertoDTO(String numPedido, String nomeCliente, String dataPedido, String status, String prazo, String valorTotal) {
        super();
        this.numPedido = numPedido;
        this.nomeCliente = nomeCliente;
        this.dataPedido = dataPedido;
        this.status = status;
        this.prazo = prazo;
        this.valorTotal = valorTotal;
    }

    public String getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(String numPedido) {
        this.numPedido = numPedido;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrazo() {
        return prazo;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }

}
