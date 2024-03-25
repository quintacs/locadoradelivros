package action;

import controle.ControleComunicacao;
import java.net.Socket;
import telas.TelaPrincipal;
import util.MsgsErros;

public class Action extends TelaPrincipal{
     
    ControleComunicacao c2;

     protected void preAction(){
        try{
            Socket s2 = new Socket("localhost", 5050);
            c2 = new ControleComunicacao(s2);                       
           
        }catch (Exception ex){
            MsgsErros.getErro("Erro ao conectar com o servidor \n" + ex.toString() );
        }
    }
 public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Action().setVisible(true);
            }
        });
    }
    

     
}
