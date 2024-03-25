/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controle;

import java.util.ArrayList;
import model.Cliente;

/**
 *
 * @author Edson
 */
public interface ControleLocadora {
    
    
    public  void armazenarDados();
    
    public void carregarDados() ;            
    
    public void persistir(Object object) ;

    public void remover(String cpf) ;

    public Cliente obter(String cpf);

    public ArrayList<Cliente> obterTodos() ;

    
}
