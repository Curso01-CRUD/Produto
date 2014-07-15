package aplicacao.produto.controller;

import aplicacao.produto.Produto;
import aplicacao.produto.model.ProdutoDAO;
import aplicacao.produto.model.RamProdutoDAO;
import java.util.List;

/**
 * Controlador do modulo produto.
 * 
 * @author avld
 */
public class ProdutoController
{
    private static ProdutoController instancia;
    private ProdutoDAO dao;
    
    private ProdutoController()
    {
        dao = new RamProdutoDAO();
    }

    public static ProdutoController getInstancia()
    {
        if( instancia == null )
        {
            instancia = new ProdutoController();
        }
        
        return instancia;
    }
    
    // -----------------------------
    // -----------------------------
    // -----------------------------
    
    public long adicionar( Produto p ) throws Exception
    {
        if( p == null )
        {
            throw new Exception( "O produto é nulo." );
        }
        else if( p.getNome() == null
                ? true
                : p.getNome().isEmpty() )
        {
            throw new Exception( "O produto deve ter um nome." );
        }
        else if( p.getValor() < 0.0 )
        {
            throw new Exception( "O produto deve ter um valor maior do que zero." );
        }
        
        return dao.adicionar( p );
    }

    public void modificar( Produto p ) throws Exception
    {
        dao.modificar( p );
    }

    public Produto get( long produtoId ) throws Exception
    {
        return dao.get( produtoId );
    }

    public void excluir( long produtoId ) throws Exception
    {
        dao.excluir( produtoId );
    }

    public List<Produto> listar() throws Exception
    {
        return dao.listar();
    }
    
}
