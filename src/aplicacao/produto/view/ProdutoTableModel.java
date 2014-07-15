package aplicacao.produto.view;

import aplicacao.produto.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author avld
 */
public class ProdutoTableModel extends AbstractTableModel
{
    private List<Produto> lista;
    private String[]    colunas;
    
    public ProdutoTableModel()
    {
        lista = new ArrayList<>();
        
        colunas = new String[ 3 ];
        colunas[ 0 ] = "Produto ID";
        colunas[ 1 ] = "Nome";
        colunas[ 2 ] = "Valor";
    }
    
    @Override
    public int getRowCount()
    {
        return lista.size();
    }

    @Override
    public int getColumnCount()
    {
        return colunas.length;
    }

    @Override
    public String getColumnName( int index )
    {
        return colunas[ index ];
    }

    @Override
    public Object getValueAt( int row , int column )
    {
        Produto p = lista.get( row );
        
        if( p == null )
        {
            return null;
        }
        
        switch( column )
        {
            case 0 : return p.getProdutoId();
            case 1 : return p.getNome();
            case 2 : return p.getValor();
        }
        
        return null;
    }
    
    // ----------------------
    // ----------------------
    // ----------------------
    
    public void adicionar( Produto p )
    {
        lista.add( p );
        fireTableRowsInserted( lista.size() - 1 , lista.size() - 1 );
    }
    
    public void modificar( int row , Produto p )
    {
        lista.set( row , p );
        fireTableRowsInserted( row , row );
    }
    
    public void excluir( int row )
    {
        lista.remove( row );
        fireTableRowsDeleted( row , row );
    }
    
    public Produto get( int row )
    {
        return lista.get( row );
    }
    
    public void setLista( List<Produto> l )
    {
        lista.clear();
        
        if( l != null )
        {
            lista = l;
        }
        
        fireTableDataChanged();
    }
    
}
