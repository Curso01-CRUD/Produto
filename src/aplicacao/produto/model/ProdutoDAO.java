package aplicacao.produto.model;

import aplicacao.produto.Produto;
import java.util.List;

/**
 *
 * @author avld
 */
public interface ProdutoDAO
{
    public long adicionar( Produto p ) throws Exception;
    public void modificar( Produto p ) throws Exception;
    public Produto get( long produtoId ) throws Exception;
    public void excluir( long produtoId ) throws Exception;
    public List<Produto> listar() throws Exception;
}
