public class Compra {
    Produto produto;
    Cliente cliente;
    int quantidade;
    double valorTotalDaCompra;

    public Compra(Produto produto, Cliente cliente, int quantidade) {
        this.produto = produto;
        this.cliente = cliente;
        this.quantidade = quantidade;

    }

    public void calcularValorTotal(){
        if(produto.getNacionalidade() == "INTERNACIONAL" || produto.getNacionalidade() == "Internacional" || produto.getNacionalidade() == "internacional" ){
            valorTotalDaCompra = (produto.getPreco() * 1.3) * quantidade;
        }else{
            valorTotalDaCompra = produto.getPreco() * quantidade;
        }
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
