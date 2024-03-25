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
import model.Cliente;
import util.MsgsErros;

public class TelaConsultaCliente extends javax.swing.JDialog {

    private ArrayList<Cliente> listCliente;
    private TelaCadastrarCliente tc;
    private TelaCadastrarEmprestimo tce;
    private String tela;
   private TelaConsultrarEmprestimo te;

    public TelaConsultaCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtConsultaCPF = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar Cliente");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        jLabel1.setText("CPF:");

        txtConsultaCPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtConsultaCPFKeyTyped(evt);
            }
        });

        btnConsultar.setText("Confirmar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
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
        lsmCliente = jTable1.getSelectionModel();
        lsmCliente.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent evt){
                if (! evt.getValueIsAdjusting()){
                    tbClientesLinhaSelecionada(jTable1);
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtConsultaCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtConsultaCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown

    }//GEN-LAST:event_formComponentShown

    private void txtConsultaCPFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConsultaCPFKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') || ((txtConsultaCPF.getText().length()) > 10)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtConsultaCPFKeyTyped

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        confirmar();

    }//GEN-LAST:event_btnConsultarActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
    }//GEN-LAST:event_formFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //setVisible(false);
        this.setVisible(false);
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
            java.util.logging.Logger.getLogger(TelaConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                TelaConsultaCliente dialog = new TelaConsultaCliente(new javax.swing.JFrame(), true);
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
    private ListSelectionModel lsmCliente;

    private void tbClientesLinhaSelecionada(JTable jTable) {
        if (jTable.getSelectedRow() != -1) {
            txtConsultaCPF.setText(listCliente.get(jTable.getSelectedRow()).getCpf());
            txtConsultaCPF.setEditable(false);

        }
    }

    protected TableModel getDadosTabela() {

        ArrayList<Cliente> lista = obterTodos();
        String[] titulos = {"Nome", "CPF", "Telefone", "Cliente Ativo"};
        Object[][] valores = new Object[lista.size()][5];
        for (int i = 0; i < lista.size(); i++) {
            valores[i][0] = lista.get(i).getNome();
            valores[i][1] = lista.get(i).getCpf();
            valores[i][2] = lista.get(i).getTelefone();
            valores[i][3] = (lista.get(i).isStatus() == true) ? "Sim" : "Não";
        }
        return new DefaultTableModel(valores, titulos);

    }

    protected void atualizarTabela() {
        jTable1.setModel(getDadosTabela());

    }

    private ArrayList<Cliente> obterTodos() {
        try {
            ArrayList<Object> listClienteObject = new ActionControle().obterTodos("ct");

            listCliente = new ArrayList<Cliente>();

            for (Object o : listClienteObject) {
                Cliente cliente = (Cliente) o;
                if (!tela.equals("emprestimo")) {
                    listCliente.add(cliente);
                } else if (cliente.isStatus() == true) {
                    listCliente.add(cliente);
                }

            }
            return listCliente;
        } catch (Exception ex) {
            MsgsErros.getErro("Erro ao enviar dados \n" + ex.toString() );
        }
        return null;
    }

    public void setTela(String tela) {
        this.tela = tela;
    }

    public String getCpf() {
        return txtConsultaCPF.getText();
    }

    public void confirmar() {
        try{
        ActionControle ac = new ActionControle();
        Cliente cliente = ((Cliente) ac.obter(txtConsultaCPF.getText(), "co"));
        if (tela == "pCadastrar") {
            tc = new TelaCadastrarCliente(new JFrame(), true);
            tc.setDados(cliente);
            setVisible(false);
            tc.setVisible(true);

        } else if (tela == "emprestimo") {
            setVisible(false);

        } else if (tela == "eConsultar") {
          te = new TelaConsultrarEmprestimo(new JFrame(), true);
            te.setTela("eConsultar");
            //te.setTxtCpf(txtConsultaCPF.getText());  
            te.setTxtCpf(cliente.getNome());  
            setVisible(false);
            te.setVisible(true);
        }
        }catch (Exception ex){
            MsgsErros.getErro("Erro ao enviar dados \n" + ex.toString() );
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtConsultaCPF;
    // End of variables declaration//GEN-END:variables
}
