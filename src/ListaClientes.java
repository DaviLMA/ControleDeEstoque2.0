
import java.util.ArrayList;

public class ListaClientes {
    private ArrayList<Cliente> listaClientes;

    public ListaClientes() {
        this.listaClientes = new ArrayList<>();
    }

    public void cadastrarClientes(Cliente cliente){
        listaClientes.add(cliente);
    }

    public Cliente buscarCliente(String cpf){
        for (Cliente cliente : listaClientes) {
            if(cliente.getCpf().equals(cpf)){
                return cliente;
            }
        }
        return null;
    }
    
}
