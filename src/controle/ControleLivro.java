/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import model.Livro;
import util.MsgsErros;

public class ControleLivro {
    
    
    private static HashMap<String, Livro> bancoLivro = new HashMap<String, Livro>();
    
    public static void armazenarDados() {
        try {
            ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream("livro.bin"));
            saida.writeObject(bancoLivro);
            saida.flush();
            saida.close();

        } catch (IOException ex) {
            MsgsErros.getErro("Erro ao gravar em disco\n"+ ex.toString());

        }

    }

    public static void carregarDados() {
        try{
            File file = new File("livro.bin");
            if(file.exists()){
                ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(file));
                //ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("c:\\livro.bin"));
                bancoLivro = (HashMap<String, Livro>) entrada.readObject();
                entrada.close();
            }
        } catch (IOException ex) {
            MsgsErros.getErro("Erro ao ler em disco\n"+ ex.toString());

        } catch (ClassNotFoundException ex) {
            MsgsErros.getErro("Erro ao ler em disco\n"+ ex.toString());

        }
    }

    

    public void persistir(Livro livro) {
        bancoLivro.put(livro.getIsbn(), livro);
        armazenarDados();
    }

    public void remover(String isbn) {
        bancoLivro.remove(isbn);
    }

    public Livro obter(String isbn) {

        if (bancoLivro.containsKey(isbn)) {
            return bancoLivro.get(isbn);
        } else {
            return null;
        }
    }

    public ArrayList<Livro> obterTodos() {

        ArrayList<Livro> lista = new ArrayList<Livro>();
        lista.addAll(bancoLivro.values());
        Collections.sort(lista, new Comparator<Livro>() {
            public int compare(Livro t1, Livro t2) {
                return (t1.getNome() == null)
                        ? (t2.getNome() == null) ? 0 : -1
                        : t1.getNome().compareTo(t2.getNome());
            }

        });

        return lista;

    }
}
