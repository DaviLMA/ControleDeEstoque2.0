import java.util.ArrayList;

public class ListaCompras {
    private ArrayList<Compra> listaCompras;

    public ListaCompras() {
        this.listaCompras = new ArrayList<>();
    }

    public void cadastrarCompras(Compra compra){
        listaCompras.add(compra);
    }
}
