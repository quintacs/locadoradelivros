package action;

import java.io.IOException;
import java.util.ArrayList;
import model.Emprestimo;


public class EmprestimoAction extends Action {
    protected void removerEmprestimo(String cod) {
        try {
            c2.enviarTexto("ER");
            c2.enviarTexto(cod);
        } catch (IOException ex) {

        }
    }

    protected void persistirEmprestimo(Emprestimo e) {
        try {
            c2.enviarTexto("EP");
           c2.enviarObjeto(e);
        } catch (Exception ex) {
        }

    }

    protected Emprestimo obterEmprestimo(String cod) {
        try {
            c2.enviarTexto("EO");
            c2.enviarTexto(cod);
            return (Emprestimo) c2.receberObjeto();
        } catch (Exception ex) {
            return null;
        }

    }

    protected ArrayList<Emprestimo> obterTodosEmprestimo() {
        try {
            c2.enviarTexto("ET");
            return (ArrayList<Emprestimo>) c2.receberObjeto();
        } catch (Exception ex) {
            return new ArrayList<Emprestimo>();
        }

    }
    
}
