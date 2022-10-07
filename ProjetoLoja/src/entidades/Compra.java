package entidades;

/**
 * Essa classe possui os atributos e métodos relacionados a três tipos de compras:
 *  a. Compras de fornecedores (classe filha: CompraFornecedor)
 *  b. Compras de clientes via e-commerce (classe filha: CompraEcommerce)
 *  c. Compras de clientes via loja física (classe filha: CompraLojaFisica)
 * As classes filhas implementam de forma distinta o método abstrato calculaFrete()
 */

public abstract class Compra {

    private int quantidade;
    private Produto produto;

    public Compra(int quantidade, Produto produto) {
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getValorDaCompra() {
        return getQuantidade() * getProduto().getPreco();
    }

    public abstract double calculaFrete();

}
