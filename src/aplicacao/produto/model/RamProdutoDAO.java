package aplicacao.produto.model;

import aplicacao.produto.Produto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe responsavel por armazenar os dados na memoria RAM
 * 
 * @author avld
 */
public class RamProdutoDAO implements ProdutoDAO
{
    private Map<Long,Produto> map;
    private long counter;
    
    public RamProdutoDAO()
    {
         map = new HashMap<>();
         counter = 1;
    }
    
    @Override
    public long adicionar( Produto p ) throws Exception
    {
        p.setProdutoId( counter++ );
        map.put( p.getProdutoId() , p );
        
        return p.getProdutoId();
    }

    @Override
    public void modificar( Produto p ) throws Exception
    {
        map.put( p.getProdutoId() , p );
    }

    @Override
    public Produto get( long produtoId ) throws Exception
    {
        return map.get( produtoId );
    }

    @Override
    public void excluir( long produtoId ) throws Exception
    {
        map.remove( produtoId );
    }

    @Override
    public List<Produto> listar() throws Exception
    {
        return new ArrayList<>( map.values() );
    }
    
}
