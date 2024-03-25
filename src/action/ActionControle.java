package action;

import java.io.IOException;
import java.util.ArrayList;
import util.MsgsErros;

public class ActionControle extends Action {

    public void remover(String str, String op) {
        try {
            c2.enviarTexto(op);
            c2.enviarTexto(str);

        } catch (IOException ex) {
            MsgsErros.getErro("Erro ao remover \n"+ ex.toString());

        }
    }

    public void persistir(Object o, String op) {
        try {
            c2.enviarTexto(op);
            c2.enviarObjeto(o);
           

        } catch (Exception ex) {
            MsgsErros.getErro("Erro ao gravar \n"+ ex.toString());
        }

    }

    public Object obter(String str, String op) {
        try {
            c2.enviarTexto(op);
            c2.enviarTexto(str);
            return c2.receberObjeto();
        } catch (Exception ex) {
             MsgsErros.getErro("Erro ao ler \n"+ ex.toString());
            return null;
        }

    }

    public ArrayList<Object> obterTodos(String op) {
        try {
            c2.enviarTexto(op);
            return (ArrayList<Object>) c2.receberObjeto();
        } catch (Exception ex) {
             MsgsErros.getErro("Erro ao ler \n"+ ex.toString());
            return new ArrayList<Object>();
        }

    }
     
}
