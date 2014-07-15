package aplicacao.produto.view;

import aplicacao.produto.Produto;
import aplicacao.produto.controller.ProdutoController;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author avld
 */
public class ProdutoListarJDialog extends javax.swing.JDialog
{
    private ProdutoTableModel tableModel;
    
    /**
     * Creates new form ProdutoListarJDialog
     * 
     * @param parent
     */
    public ProdutoListarJDialog( java.awt.Window parent )
    {
        super( parent );
        
        initComponents();
        init();
        
        setModal( true );
        setLocationRelativeTo( null );
    }

    private void init()            
    {
        tableModel = new ProdutoTableModel();
        jTable1.setModel( tableModel );
    }
    
    public Produto getProdutoSelecionado() throws Exception
    {
        int row = jTable1.getSelectedRow();
        if( row == -1 )
        {
            throw new Exception( "Por favor, selecione uma linha da tabela." );
        }
        
        return tableModel.get( row );
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        adicionarJButton = new javax.swing.JButton();
        editarJButton = new javax.swing.JButton();
        excluirJButton = new javax.swing.JButton();
        listarJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        adicionarJButton.setText("Adicionar");
        adicionarJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarJButtonActionPerformed(evt);
            }
        });

        editarJButton.setText("Editar");
        editarJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarJButtonActionPerformed(evt);
            }
        });

        excluirJButton.setText("Excluir");
        excluirJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirJButtonActionPerformed(evt);
            }
        });

        listarJButton.setText("Listar");
        listarJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarJButtonActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "Escova de dente", "10.00"},
                {"2", "Fio dental", "3.00"},
                {"3", "Pasta de dente", "5.50"},
                {"4", "Barbeador", "12.35"}
            },
            new String [] {
                "Produto ID", "Nome", "Valor"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(adicionarJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editarJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(excluirJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(listarJButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adicionarJButton)
                    .addComponent(editarJButton)
                    .addComponent(excluirJButton)
                    .addComponent(listarJButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adicionarJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarJButtonActionPerformed
        ProdutoJDialog dialog = new ProdutoJDialog( this );
        dialog.setVisible( true );
        
        if( dialog.isSalvou() )
        {
            tableModel.adicionar( dialog.getProduto() );
        }
        
        dialog.dispose();
        dialog = null;
    }//GEN-LAST:event_adicionarJButtonActionPerformed

    private void editarJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarJButtonActionPerformed
        try
        {
            Produto p = getProdutoSelecionado();
        
            ProdutoJDialog dialog = new ProdutoJDialog( this );
            dialog.setProduto( p );
            dialog.setVisible( true );

            if( dialog.isSalvou() )
            {
                tableModel.modificar( jTable1.getSelectedRow() 
                                    , dialog.getProduto() );
            }

            dialog.dispose();
            dialog = null;
        }
        catch( Exception err )
        {
            JOptionPane.showMessageDialog( this , err );
        }
    }//GEN-LAST:event_editarJButtonActionPerformed

    private void excluirJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirJButtonActionPerformed
        try
        {
            Produto p = getProdutoSelecionado();
        
            String txt    = "Você deseja deletar o produto " + p.getNome() + " ?";
            int resultado = JOptionPane.showConfirmDialog( this , txt );

            if( resultado == JOptionPane.YES_OPTION )
            {
                ProdutoController.getInstancia().excluir( p.getProdutoId() );
                tableModel.excluir( jTable1.getSelectedRow() );
            }
            else
            {
                throw new Exception( "A ação foi cancelada pelo usuário." );
            }

            JOptionPane.showMessageDialog( this , "O produto foi excluido com sucesso." );
        }
        catch( Exception err )
        {
            JOptionPane.showMessageDialog( this , err );
        }
    }//GEN-LAST:event_excluirJButtonActionPerformed

    private void listarJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarJButtonActionPerformed
        try
        {
            List<Produto> lista = ProdutoController.getInstancia().listar();
            tableModel.setLista( lista );
        }
        catch( Exception err )
        {
            JOptionPane.showMessageDialog( this , err );
        }
    }//GEN-LAST:event_listarJButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ProdutoListarJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProdutoListarJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProdutoListarJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProdutoListarJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProdutoListarJDialog dialog = new ProdutoListarJDialog( new javax.swing.JFrame() );
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionarJButton;
    private javax.swing.JButton editarJButton;
    private javax.swing.JButton excluirJButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton listarJButton;
    // End of variables declaration//GEN-END:variables
}
