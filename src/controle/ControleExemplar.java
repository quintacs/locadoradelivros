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
import model.Exemplar;
import util.MsgsErros;

public class ControleExemplar {
    
    
    
    private static HashMap<String, Exemplar> bancoExemplar = new HashMap<String, Exemplar>();

    public static void armazenarDados() {
        try {
            ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream("exemplar.bin"));
            saida.writeObject(bancoExemplar);
            saida.flush();
            saida.close();

        } catch (IOException ex) {
            MsgsErros.getErro("Erro ao gravar em disco\n"+ ex.toString());

        }

    }

    public static void carregarDados() {
        try {
           // ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("c:\\exemplar.bin"));
            File file = new File("exemplar.bin");
            if(file.exists()){
                ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(file));
                bancoExemplar = (HashMap<String, Exemplar>) entrada.readObject();
                entrada.close();
            }
        } catch (IOException ex) {
            MsgsErros.getErro("Erro ao ler em disco\n"+ ex.toString());

        } catch (ClassNotFoundException ex) {
            MsgsErros.getErro("Erro ao ler em disco\n"+ ex.toString());

        }
    }

    

    public void persistir(Exemplar exemplar) {
        bancoExemplar.put(exemplar.getCod(), exemplar);
        armazenarDados();
    }

    public void remover(String cod) {
        bancoExemplar.remove(cod);
    }

    public Exemplar obter(String cod) {

        if (bancoExemplar.containsKey(cod)) {
            return bancoExemplar.get(cod);
        } else {
            return null;
        }
    }

    public ArrayList<Exemplar> obterIsbn(String Isbn) {

        ArrayList<Exemplar> listaIsbn = new ArrayList<Exemplar>();
        if (bancoExemplar.containsValue(Isbn))
        listaIsbn.addAll(bancoExemplar .values());
        Collections.sort(listaIsbn, new Comparator<Exemplar>() {
            public int compare(Exemplar t1, Exemplar t2) {
                return (t1.getLivroISBN()== null)
                        ? (t2.getLivroISBN()== null) ? 0 : -1
                        : t1.getLivroISBN().compareTo(t2.getLivroISBN());

            }
        });

        return listaIsbn;
        
    }

    public ArrayList<Exemplar> obterTodos() {

        ArrayList<Exemplar> lista = new ArrayList<Exemplar>();
        lista.addAll(bancoExemplar.values());
        Collections.sort(lista, new Comparator<Exemplar>() {
            public int compare(Exemplar t1, Exemplar t2) {
                return (t1.getCod() == null)
                        ? (t2.getCod() == null) ? 0 : -1
                        : t1.getCod().compareTo(t2.getCod());
            }

        });

        return lista;

    }

}
