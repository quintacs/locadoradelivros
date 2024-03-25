package action;

import java.io.IOException;
import java.util.ArrayList;
import model.Exemplar;


public class ExemplarAction extends Action{
    protected void removerExemplar(String cod) {
        try {
            c2.enviarTexto("XR");
            c2.enviarTexto(cod);
        } catch (IOException ex) {

        }
    }

    protected void persistirExemplar(Exemplar x) {
        try {
            c2.enviarTexto("XP");
            c2.enviarObjeto(x);
        } catch (Exception ex) {
        }

    }

    protected Exemplar obterExemplar(String cod) {
        try {
            c2.enviarTexto("XO");
            c2.enviarTexto(cod);
            return (Exemplar) c2.receberObjeto();
        } catch (Exception ex) {
            return null;
        }

    }

    protected ArrayList<Exemplar> obterTodosExemplar() {
        try {
            c2.enviarTexto("X");
            c2.enviarTexto("T");
            return (ArrayList<Exemplar>) c2.receberObjeto();
        } catch (Exception ex) {
            return new ArrayList<Exemplar>();
        }

    }
    
}
