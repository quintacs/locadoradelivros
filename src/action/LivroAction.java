package action;

import java.io.IOException;
import java.util.ArrayList;
import model.Livro;

public class LivroAction extends Action{
    protected void removerLivro(String isbn) {
        try {
            c2.enviarTexto("LR");
            c2.enviarTexto(isbn);
        } catch (IOException ex) {

        }
    }

    protected void persistirLivro(Livro l) {
        try {
            c2.enviarTexto("LP");
           c2.enviarObjeto(l);
        } catch (Exception ex) {
        }

    }

    protected Livro obterLivro(String isbn) {
        try {
            c2.enviarTexto("LO");
            c2.enviarTexto(isbn);
            return (Livro) c2.receberObjeto();
        } catch (Exception ex) {
            return null;
        }

    }

    protected ArrayList<Livro> obterTodosLivros() {
        try {
            c2.enviarTexto("LT");
            return (ArrayList<Livro>) c2.receberObjeto();
        } catch (Exception ex) {
            return new ArrayList<Livro>();
        }

    }
    
}
