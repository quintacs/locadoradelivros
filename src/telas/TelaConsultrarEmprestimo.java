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
import model.Emprestimo;
import model.Livro;
import util.MsgsErros;
import util.UtilDate;

/**
 *
 * @author Edson
 */
public class TelaConsultrarEmprestimo extends javax.swing.JDialog {

    private TelaConsultaCliente cc;
    private ArrayList<Emprestimo> listEmprestimo;
    private ActionControle ac;
    private String tela;
    private ListSelectionModel lsmEmprestimo;
    private TelaDevolucao td;

    /**
     * Creates new form TelaCunsultaEmprestimo
     */
    public TelaConsultrarEmprestimo(java.awt.Frame parent, boolean modal) {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txtcpf = new javax.swing.JLabel();
        txtcodEmprestimo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consutar Exemplar");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
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
        lsmEmprestimo = jTable1.getSelectionModel();
        lsmEmprestimo.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent evt){
                if (! evt.getValueIsAdjusting()){
                    tbEmprestimoLinhaSelecionada(jTable1);
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

        txtcodEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodEmprestimoActionPerformed(evt);
            }
        });

        jLabel1.setText("Código do Emprestimo :");

        jLabel2.setText("Nome do Cliente: ");

        jToggleButton1.setText("Devolver");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtcpf))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtcodEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtcodEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtcpf, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        montaTela();
    }//GEN-LAST:event_formComponentShown

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtcodEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodEmprestimoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodEmprestimoActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        td = new TelaDevolucao(new JFrame(), true);
        td.setDados(txtcodEmprestimo.getText());
        td.setVisible(true);
        atualizarTabela();

    }//GEN-LAST:event_jToggleButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaConsultrarEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaConsultrarEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaConsultrarEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConsultrarEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaConsultrarEmprestimo dialog = new TelaConsultrarEmprestimo(new javax.swing.JFrame(), true);
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

    protected void atualizarTabela() {
        try {
            jTable1.setModel(getDadosTabela());
        } catch (Exception ex) {

        }
    }

    protected TableModel getDadosTabela() {
        try {
            ArrayList<Emprestimo> lista = obterTodosEmprestimo();
            String[] titulos = {"Livro", "Exemplar", "CPF do Cliente", "Data do Emprestimo", "Data Prevista", "Data de Devolução"};
            Object[][] valores = new Object[lista.size()][6];
            ac = new ActionControle();

            for (int i = 0; i < lista.size(); i++) {
                
                String [] codigoExemplar = lista.get(i).getCodExemplar().split("-");                
                //valores[i][0] = ((Livro) ac.obter(((lista.get(i).getCodExemplar()).substring(0, (lista.get(i).getCodExemplar()).length() - 3)), "lo")).getNome();                
                valores[i][0] = ((Livro)ac.obter(codigoExemplar[0],"lo")).getNome();
                valores[i][1] = lista.get(i).getCodExemplar();
                valores[i][2] = lista.get(i).getCpfCliente();
                valores[i][3] = UtilDate.formatDMY(lista.get(i).getDataEmprestimo());
                valores[i][4] = UtilDate.formatDMY(lista.get(i).getDataPrevista());
                valores[i][5] = UtilDate.formatDMY(lista.get(i).getDataDevolucao());
            }
            return new DefaultTableModel(valores, titulos);
        } catch (Exception ex) {
            MsgsErros.getErro("Erro ao enviar dados \n" + ex.toString() );
            return null;

        }
    }

    private ArrayList<Emprestimo> obterTodosEmprestimo() {
        try {
            ArrayList<Object> listEmprestimoObject = new ActionControle().obterTodos("et");

            listEmprestimo = new ArrayList<Emprestimo>();

            for (Object o : listEmprestimoObject) {
                Emprestimo emprestimo = (Emprestimo) o;
                if (tela == "h") {
                    listEmprestimo.add(emprestimo);

                } else if ((txtcpf.getText() == "") && (emprestimo.getDataDevolucao() == null)) {
                    listEmprestimo.add(emprestimo);
                } else if ((emprestimo.getCpfCliente().equals(txtcpf.getText())) && (emprestimo.getDataDevolucao() == null)) {
                    listEmprestimo.add(emprestimo);
                }

            }
            return listEmprestimo;
        } catch (Exception ex) {
            MsgsErros.getErro("Erro ao enviar dados \n" + ex.toString() );
        }
        return null;
    }

    public void setTela(String tela) {
        this.tela = tela;

    }

    public void setTxtCpf(String cpf) {
        txtcpf.setText(cpf);
    }

    private void tbEmprestimoLinhaSelecionada(JTable jTable) {
        if (jTable.getSelectedRow() != -1) {
            txtcodEmprestimo.setText(listEmprestimo.get(jTable.getSelectedRow()).getCodExemplar());
            txtcodEmprestimo.setEditable(false);

        }
    }

    private void montaTela() {
        atualizarTabela();
        if (txtcpf.getText() == "") {
            jLabel2.setVisible(false);
        }
        if (tela == "h") {
            jLabel1.setVisible(false);
            jLabel2.setVisible(false);
            txtcodEmprestimo.setVisible(false);
            jToggleButton1.setVisible(false);

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField txtcodEmprestimo;
    private javax.swing.JLabel txtcpf;
    // End of variables declaration//GEN-END:variables
}
