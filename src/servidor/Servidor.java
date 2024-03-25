package servidor;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import util.MsgsErros;


public class Servidor extends javax.swing.JFrame {

    private ServerSocket s0;
    private boolean ligado = false;

    public Servidor() {
        initComponents();
       
    }


    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btLigar = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Servidor");

        btLigar.setLabel("Ligar Servidor");
        btLigar.setMinimumSize(new java.awt.Dimension(57, 57));
        btLigar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLigarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btLigar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btLigar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btLigarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLigarActionPerformed
        if (ligado) {
            DeslidarServidor();
            btLigar.setLabel("Ligar Servidor");
            ligado = false;
            

        } else {
            ligarServidor();
            btLigar.setLabel("Desligar Servidor");
            ligado = true;
            
            

        }

       
       
    }//GEN-LAST:event_btLigarActionPerformed

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Servidor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btLigar;
    // End of variables declaration//GEN-END:variables

    private void ligarServidor() {
          new Thread(
                new Runnable() {
                    public void run() {
                        try {
                            s0 = new ServerSocket(5050);
                            while (true) {
                                Socket s1 = s0.accept();
                                new ThLocadora(s1).start();
                                

                            }
                        } catch (Exception ex) {
                            

                        }
                    }
                }
        ).start();
    }

    private void DeslidarServidor() {
        try {
            s0.close();               
            } catch (IOException ex) {
                MsgsErros.getErro("Erro ao desligar o servidor \n" + ex.toString() );
            }
    }
}
