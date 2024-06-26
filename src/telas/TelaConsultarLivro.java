/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import action.ActionControle;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Livro;
import util.MsgsErros;

/**
 *
 * @author Edson
 */
public class TelaConsultarLivro extends javax.swing.JDialog {

    private ArrayList<Livro> listLivro;
    private TelaCadastrarLivro tl;
    private TelaCadastrarExemplar ce;
    private String tela;
    private TelaListaExemplar tlx;

    /**
     * Creates new form TelaConsultarLivro
     */
    public TelaConsultarLivro(java.awt.Frame parent, boolean modal) {
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

        btnConsultar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtConsultaISBN = new javax.swing.JTextField();
        btnConsultar1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar Livro");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setText("ISBN:");

        btnConsultar1.setText("Confirmar");
        btnConsultar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultar1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmLivro = jTable1.getSelectionModel();
        lsmLivro.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent evt){
                if (! evt.getValueIsAdjusting()){
                    tbLivroLinhaSelecionada(jTable1);
                }
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtConsultaISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(21, 21, 21)
                .addComponent(btnConsultar1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtConsultaISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnConsultar1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed

    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnConsultar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultar1ActionPerformed
        confirmar();
    }//GEN-LAST:event_btnConsultar1ActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown

    }//GEN-LAST:event_formComponentShown

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaConsultarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaConsultarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaConsultarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConsultarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaConsultarLivro dialog = new TelaConsultarLivro(new javax.swing.JFrame(), true);
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
    ListSelectionModel lsmLivro;

    private void tbLivroLinhaSelecionada(JTable jTable) {
        if (jTable.getSelectedRow() != -1) {
            txtConsultaISBN.setText(listLivro.get(jTable.getSelectedRow()).getIsbn());
            txtConsultaISBN.setEditable(false);
        }
    }

    protected TableModel getDadosTabela() {

        ArrayList<Livro> lista = obterTodos();
        String[] titulos = {"Nome", "Autor", "Editora", "ISBN"};
        Object[][] valores = new Object[lista.size()][5];
        for (int i = 0; i < lista.size(); i++) {
            valores[i][0] = lista.get(i).getNome();
            valores[i][1] = lista.get(i).getAutor();
            valores[i][2] = lista.get(i).getEditora();
            valores[i][3] = lista.get(i).getIsbn();
        }
        return new DefaultTableModel(valores, titulos);

    }

    protected void atualizarTabela() {
        jTable1.setModel(getDadosTabela());

    }

    private ArrayList<Livro> obterTodos() {
        try {
            ArrayList<Object> listLivroObject = new ActionControle().obterTodos("lt");

            listLivro = new ArrayList<Livro>();

            for (Object o : listLivroObject) {
                Livro livro = (Livro) o;
                listLivro.add(livro);
            }
            return listLivro;
        } catch (Exception ex) {
            MsgsErros.getErro("Erro ao conectar ao servidor \n" + ex.toString());
        }
        return null;
    }

    public void setTela(String tela) {
        this.tela = tela;
    }

    public String getIsbn() {
        return txtConsultaISBN.getText();
    }

    public void confirmar() {
        try {
            ActionControle ac = new ActionControle();
            Livro livro = ((Livro) ac.obter(txtConsultaISBN.getText(), "lo"));
            if (tela == "consultar") {
                tl = new TelaCadastrarLivro(new JFrame(), true);
                tl.setDados(livro);
                setVisible(false);
                tl.setVisible(true);

            } else if (tela == "exemplar") {
                ce = new TelaCadastrarExemplar(new JFrame(), true);
                ce.setDados(livro);
                setVisible(false);
                ce.setVisible(true);

            } else if (tela == "xexemplar") {
                tlx = new TelaListaExemplar(new JFrame(), true);
                tlx.setDados(livro);
                setVisible(false);
                tlx.setVisible(true);
            } else if (tela == "emprestimo") {
                setVisible(false);

            }
        } catch (Exception ex) {
            MsgsErros.getErro("Erro ao enviar dados \n" + ex.toString());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnConsultar1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtConsultaISBN;
    // End of variables declaration//GEN-END:variables
}
