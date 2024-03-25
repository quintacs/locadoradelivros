package controle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import model.Cliente;
import util.MsgsErros;

public class ControleCliente  {

    
    
    private static HashMap<String, Cliente> bancoClientes = new HashMap<String, Cliente>();
    
    public  void armazenarDados() {
        try {
            ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream("cliente.bin"));
            saida.writeObject(bancoClientes);
            saida.flush();
            saida.close();

        }catch(Exception ex){
            MsgsErros.getErro("Erro ao gravar em disco \n"+ ex.toString());
        }

    }

    public  void carregarDados() {
        try {
            File file = new File("cliente.bin");
            if(file.exists()){
                //ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("c:\\cliente.bin"));
                ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(file));
                bancoClientes = (HashMap<String, Cliente>) entrada.readObject();
                entrada.close();
            }
                              
        }catch (Exception ex) {
            MsgsErros.getErro("Erro ao ler em disco \n"+ ex.toString());
        } 
    }

    

    public void persistir(Cliente cliente) {   
        try{
        bancoClientes.put(cliente.getCpf(), cliente);
        armazenarDados();
        }catch (Exception ex ){
         MsgsErros.getErro("Erro ao gravar \n"+ ex.toString());          

        } 
    }

    public void remover(String cpf) {
        bancoClientes.remove(cpf);
    }

    public Cliente obter(String cpf) {
        try{

        if (bancoClientes.containsKey(cpf)) {
            return bancoClientes.get(cpf);
        } else {
            return null;
        }
        }catch (Exception ex){
            MsgsErros.getErro("Erro ao ler \n"+ ex.toString());    
            return  null;
        }
    }

    public ArrayList<Cliente> obterTodos() {
        try {
            ArrayList<Cliente> lista = new ArrayList<Cliente>();
        lista.addAll(bancoClientes.values());
        Collections.sort(lista, new Comparator<Cliente>() {
            public int compare(Cliente t1, Cliente t2) {
                return (t1.getNome() == null)
                        ? (t2.getNome() == null) ? 0 : -1
                        : t1.getNome().compareTo(t2.getNome());
            }

        });

        return lista;
            
        } catch (Exception ex) {
            MsgsErros.getErro("Erro ao ler \n"+ ex.toString());
            return null;
        }
        

    }

   
}
