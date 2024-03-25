package controle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import model.Emprestimo;
import util.MsgsErros;

public class ControleEmprestimo {

    
     private static HashMap<String, Emprestimo> bancoEmprestimo = new HashMap<String, Emprestimo>();
    
    public static void armazenarDados() {

        try {
            ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream("emprestimo.bin"));
            saida.writeObject(bancoEmprestimo);
            saida.flush();
            saida.close();

        } catch (IOException ex) {
            MsgsErros.getErro("Erro ao gravar em disco\n"+ ex.toString());
        }

    }

    public static void carregarDados() {
        try {
            //ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("c:\\emprestimo.bin"));            
            File file = new File("emprestimo.bin");
            if(file.exists()){
            //ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("c:\\emprestimo.bin"));
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(file));        
            bancoEmprestimo = (HashMap<String, Emprestimo>) entrada.readObject();
            entrada.close();
        }
        } catch (IOException ex) {
            MsgsErros.getErro("Erro ao ler em disco\n"+ ex.toString());

        } catch (ClassNotFoundException ex) {
            MsgsErros.getErro("Erro ao ler em disco\n"+ ex.toString());

        }
    }

   

    public void persistir(Emprestimo emprestimo) {
        try {bancoEmprestimo.put(emprestimo.getCod(), emprestimo);
        armazenarDados();
            
        } catch (Exception ex) {
            MsgsErros.getErro("Erro ao gravar \n"+ ex.toString());
        }
        
    }

    public void remover(String cod) {
        bancoEmprestimo.remove(cod);
    }

    public Emprestimo obter(String cod) {

        if (bancoEmprestimo.containsKey(cod)) {
            return bancoEmprestimo.get(cod);
        } else {
            return null;
        }
    }
    
   
    public ArrayList<Emprestimo> obterTodos() {

        ArrayList<Emprestimo> lista = new ArrayList<Emprestimo>();
        lista.addAll(bancoEmprestimo.values());
        Collections.sort(lista, new Comparator<Emprestimo>() {
            public int compare(Emprestimo t1, Emprestimo t2) {
                return (t1.getCod() == null)
                        ? (t2.getCod() == null) ? 0 : -1
                        : t1.getCod().compareTo(t2.getCod());
            }

        });

        return lista;

    }

}
