/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import javax.swing.JOptionPane;

/**
 *
 * @author Cesar
 */
public class MsgErro {
    
    public static void getMsgErro(String erro){
        JOptionPane.showMessageDialog(null,  erro , "Atenção!" , 2);
    }
}
