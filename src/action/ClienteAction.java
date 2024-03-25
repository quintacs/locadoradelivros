package action;

import java.io.IOException;
import java.util.ArrayList;
import model.Cliente;



public class ClienteAction extends Action{

    private  String  operacao = null;
    
   protected void removerCliente(String cpf,String op) {
        try {
            c2.enviarTexto(op);
            c2.enviarTexto(cpf);

        } catch (IOException ex) {

        }
    }

   public void persistir(Object c, String op) {
        try {
            c2.enviarObjeto(c);
        } catch (Exception ex) {
        }

    }

    protected Cliente obterCliente(String cpf) {
        try {
            c2.enviarTexto("CO");
            c2.enviarTexto(cpf);
            return (Cliente) c2.receberObjeto();
        } catch (Exception ex) {
            return null;
        }

    }

    protected ArrayList<Cliente> obterTodosClientes() {
        try {
            c2.enviarTexto("C");
            c2.enviarTexto("T");
            return (ArrayList<Cliente>) c2.receberObjeto();
        } catch (Exception ex) {
            return new ArrayList<Cliente>();
        }

    }
}
