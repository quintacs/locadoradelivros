/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import action.ActionControle;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Exemplar;
import model.Livro;
import util.MsgsErros;

/**
 *
 * @author Edson
 */
public class TelaCadastrarExemplar extends javax.swing.JDialog {
    private int quantidade;
    private ArrayList<Exemplar> listExemplar;

    /**
     * Creates new form TelaCadastrarExemplar
     */
    public TelaCadastrarExemplar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtISBNExemplar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtQuantidadeExemplar = new javax.swing.JTextField();
        btCancelar = new javax.swing.JToggleButton();
        btnCadastrar = new javax.swing.JToggleButton();
        btCancelar1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Exemplar");

        jLabel1.setText("ISBN:");

        jLabel2.setText("Quantidade:");

        txtQuantidadeExemplar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantidadeExemplarKeyTyped(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btCancelar1.setText("Sair");
        btCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCadastrar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtQuantidadeExemplar, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                            .addComponent(txtISBNExemplar))
                        .addComponent(jLabel1)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btCancelar, btnCadastrar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtISBNExemplar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtQuantidadeExemplar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtISBNExemplar, txtQuantidadeExemplar});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btCancelar, btnCadastrar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtQuantidadeExemplarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeExemplarKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtQuantidadeExemplarKeyTyped

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        setDados(null);
        setVisible(false);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if (validar()) {
            persistir(getDados());
            setDados(null);
            setVisible(false);
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelar1ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btCancelar1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarExemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarExemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarExemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarExemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                TelaCadastrarExemplar dialog = new TelaCadastrarExemplar(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
   

    public ArrayList<Exemplar> getDados() {
        try{
        quantidade = Integer.parseInt(txtQuantidadeExemplar.getText());
        listExemplar = new ArrayList<Exemplar>();
        int aux = getMaior();
        for (int i = 1; i <= quantidade; i++) {
            
            String str = (aux <9)?  "-0" : "-";
            Exemplar exemplar = new Exemplar(txtISBNExemplar.getText(), txtISBNExemplar.getText() + str + ++aux);
            listExemplar.add(exemplar);
        }
        return listExemplar;
    }catch (Exception ex){
         MsgsErros.getErro("Erro ao enviar dados \n" + ex.toString() );
    }
        return null;
    }
    

    private void persistir(ArrayList<Exemplar> listExemplar) {
        try{
        ActionControle ac = new ActionControle();

        for (Exemplar x : listExemplar) {
            ac.persistir(x, "xc");

        }
        }catch (Exception ex){
             MsgsErros.getErro("Erro ao enviar dados \n" + ex.toString() );
        }
    }

    public void setDados(Livro l) {
        txtISBNExemplar.setText((l == null) ? "" : l.getIsbn());
        txtQuantidadeExemplar.setText(null);
        txtISBNExemplar.setEditable(l==null);
    }

    boolean validar() {
        if ((txtISBNExemplar != null) && (txtQuantidadeExemplar != null)) {
            return true;
        }
         MsgsErros.getErro("Preencha todos os campos \n" );
        return false;

    }

    protected int getMaior() {
        int maior = 0;
        ArrayList<Exemplar> lista = obter();

        for (Exemplar x : lista) {
            int aux = Integer.parseInt(x.getCod().substring((x.getLivroISBN().length() + 1)));
            if (maior < aux) {
                maior = aux;
            }

        }
        return maior;

    }

    private ArrayList<Exemplar> obter() {
        try {
            ArrayList<Object> listExemplarObject = new ActionControle().obterTodos("xt");

            listExemplar = new ArrayList<Exemplar>();

            for (Object x : listExemplarObject) {
                Exemplar exemplar = (Exemplar) x;
                 if (txtISBNExemplar.getText().equals(exemplar.getLivroISBN())) {
                listExemplar.add(exemplar);
                }
            }
            return listExemplar;
        } catch (Exception ex) {
           MsgsErros.getErro("Erro ao enviar dados \n" + ex.toString() );
        }
        return null;
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btCancelar;
    private javax.swing.JToggleButton btCancelar1;
    private javax.swing.JToggleButton btnCadastrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtISBNExemplar;
    private javax.swing.JTextField txtQuantidadeExemplar;
    // End of variables declaration//GEN-END:variables
}