package servidor;

import controle.ControleCliente;
import controle.ControleComunicacao;
import controle.ControleEmprestimo;
import controle.ControleExemplar;
import controle.ControleLivro;
import java.net.Socket;
import model.Cliente;
import model.Emprestimo;
import model.Exemplar;
import model.Livro;
import util.MsgsErros;

public class ThLocadora extends Thread {

    private Socket s;

    public ThLocadora(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            ControleComunicacao c1 = new ControleComunicacao(s);
            ControleCliente cCliente = new ControleCliente();
            ControleLivro cLivro = new ControleLivro();
            ControleExemplar cExemplar = new ControleExemplar();
            ControleEmprestimo cEmprestimo = new ControleEmprestimo();
            cCliente.carregarDados();
            cLivro.carregarDados();
            cExemplar.carregarDados();
            cEmprestimo.carregarDados();
            while (true) {
                String comando = c1.receberTexto();

                //Livro  
                if ("cc".equalsIgnoreCase(comando)) {
                    cCliente.persistir((Cliente) c1.receberObjeto());
                }
                if ("cr".equals(comando)) {
                    cCliente.remover(c1.receberTexto());
                }
                if ("co".equals(comando)) {
                    String cpf = c1.receberTexto();
                    c1.enviarObjeto(cCliente.obter(cpf));
                }
                if ("ct".equalsIgnoreCase(comando)) {
                    c1.enviarObjeto(cCliente.obterTodos());
                }

                // Livro
                
                if ("lc".equalsIgnoreCase(comando)) {
                    cLivro.persistir((Livro) c1.receberObjeto());
                }
                if ("lr".equals(comando)) {
                    cLivro.remover(c1.receberTexto());
                }
                if ("lo".equals(comando)) {
                    String isnb = c1.receberTexto();
                    c1.enviarObjeto(cLivro.obter(isnb));
                }
                if ("lt".equalsIgnoreCase(comando)) {
                    c1.enviarObjeto(cLivro.obterTodos());
                }
                
                //Exemplar

                if ("xc".equalsIgnoreCase(comando)) {
                    cExemplar.persistir((Exemplar) c1.receberObjeto());
                }
                if ("xr".equals(comando)) {
                    cExemplar.remover(c1.receberTexto());
                }
                if ("xo".equals(comando)) {
                    String cod = c1.receberTexto();
                    c1.enviarObjeto(cExemplar.obter(cod));
                }
                if ("xt".equalsIgnoreCase(comando)) {
                    c1.enviarObjeto(cExemplar.obterTodos());
                }
                
                //Emprestimo

                if ("ec".equalsIgnoreCase(comando)) {
                    cEmprestimo.persistir((Emprestimo) c1.receberObjeto());
                }
                if ("er".equals(comando)) {
                    cEmprestimo.remover(c1.receberTexto());
                }
                if ("eo".equals(comando)) {
                    String cod = c1.receberTexto();
                    c1.enviarObjeto(cEmprestimo.obter(cod));
                }
                if ("et".equalsIgnoreCase(comando)) {
                    c1.enviarObjeto(cEmprestimo.obterTodos());
                }
                
            }

        } catch (Exception ex) {
            MsgsErros.getErro("Erro ao ler \n"+ ex.toString());
        }

    }

}
