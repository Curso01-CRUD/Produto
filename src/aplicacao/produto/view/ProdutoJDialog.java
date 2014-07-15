package aplicacao.produto.view;

import aplicacao.produto.Produto;
import aplicacao.produto.controller.ProdutoController;
import javax.swing.JOptionPane;

/**
 *
 * @author avld
 */
public class ProdutoJDialog extends javax.swing.JDialog
{
    private Produto produto;
    private boolean salvou;
    
    /**
     * Creates new form ProdutoJDialog
     * 
     * @param parent
     */
    public ProdutoJDialog( java.awt.Window parent )
    {
        super( parent );
        
        initComponents();
        init();
        
        setModal( true );
        setLocationRelativeTo( parent );
    }

    private void init()
    {
        salvou = false;
        setProduto( new Produto() );
    }
    
    public void setProduto( Produto p )
    {
        produto = p;
        
        if( p == null )
        {
            produto = new Produto();
        }
        
        nomeJTextField.setText( produto.getNome()  );
        valorJTextField.setText( produto.getValor() + "" );
        
        salvou = false;
    }
    
    public Produto getProduto()
    {
        produto.setNome( nomeJTextField.getText() );
        
        double valor = Double.parseDouble( valorJTextField.getText() );
        produto.setValor( valor );
        
        return produto;
    }

    public boolean isSalvou()
    {
        return salvou;
    }

    public void setSalvou( boolean salvou )
    {
        this.salvou = salvou;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        produto1 = new aplicacao.produto.Produto();
        produto2 = new aplicacao.produto.Produto();
        jLabel1 = new javax.swing.JLabel();
        nomeJTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        valorJTextField = new javax.swing.JTextField();
        cancelarJButton = new javax.swing.JButton();
        salvarJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nome:");

        jLabel2.setText("Valor:");

        cancelarJButton.setText("Cancelar");
        cancelarJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarJButtonActionPerformed(evt);
            }
        });

        salvarJButton.setText("Salvar");
        salvarJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 196, Short.MAX_VALUE)
                        .addComponent(salvarJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelarJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valorJTextField)
                            .addComponent(nomeJTextField))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomeJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(valorJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarJButton)
                    .addComponent(salvarJButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salvarJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarJButtonActionPerformed
        try
        {
            salvou = false;
            
            Produto p = getProduto();
            
            if( p.getProdutoId() == 0 )
            {
                ProdutoController.getInstancia().adicionar( p );
            }
            else
            {
                ProdutoController.getInstancia().modificar( p );
            }
            
            setVisible( false );
            JOptionPane.showMessageDialog( this , "O produto foi salvo com sucesso." );
            
            salvou = true;
        }
        catch( Exception err )
        {
            JOptionPane.showMessageDialog( this , err );
        }
    }//GEN-LAST:event_salvarJButtonActionPerformed

    private void cancelarJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarJButtonActionPerformed
        salvou = false;
        setVisible( false );
    }//GEN-LAST:event_cancelarJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField nomeJTextField;
    private aplicacao.produto.Produto produto1;
    private aplicacao.produto.Produto produto2;
    private javax.swing.JButton salvarJButton;
    private javax.swing.JTextField valorJTextField;
    // End of variables declaration//GEN-END:variables
}
