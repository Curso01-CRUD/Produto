package aplicacao.produto;

/**
 * JavaBean representando um produto.
 * 
 * @author avld
 */
public class Produto
{
    private long produtoId;
    private String nome;
    private double valor;
    
    public Produto()
    {
        // faz nada
    }

    public long getProdutoId()
    {
        return produtoId;
    }

    public void setProdutoId( long produtoId )
    {
        this.produtoId = produtoId;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome( String nome )
    {
        this.nome = nome;
    }

    public double getValor()
    {
        return valor;
    }

    public void setValor( double valor )
    {
        this.valor = valor;
    }
    
}
