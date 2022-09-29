
import java.util.ArrayList;

public class ListaProdutos {
    private ArrayList<Produto> listaProdutos;

    public ListaProdutos(){
        this.listaProdutos = new ArrayList<>();
    }

    public void cadastrarProdutos(Produto produto){
        listaProdutos.add(produto);
    }

    public Produto buscarProduto(String id){
        for (Produto produto : listaProdutos) {
            if(produto.getId().equals(id)){
                return produto;
            }
        }
        return null;
    }

    public void atualizarEstoque(String id, int quantidade){
        Produto produto = buscarProduto(id);
        if(produto != null){
            produto.setQuantidade(quantidade);
        }
    }
}
