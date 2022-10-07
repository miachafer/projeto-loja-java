import entidades.*;
import enums.Categoria;

/** REQUISITOS DO PROJETO:
 * Deve ser possível:
 * [x] Gerenciar marcas (cadastrar, selecionar, alterar, remover)
 * [x] Gerenciar produtos (cadastrar, selecionar, alterar, remover)
 * [x] Pesquisar produtos
 * Exigências:
 * [x] Uma marca não pode ser removida se houver produto relacionados a ela
 * [x] Não permitir duplicidade de produtos e marcas
 * [x] Usar encapsulamento
 * [x] Usar polimorfismo
 *      - Verificar classes Compra, CompraEcommerce, CompraFornecedor, e CompraLojaFisica
 *      - Verificar função calculaFrete();
 * [x] Usar classe abstrata ou interface
 *      - Verificar interface Estoque;
 *      - Verificar métodos setQuantidadeEmEstoque(int i) e getQuantidadeEmEstoque() na classe Produto, que implementa
 *      interface Estoque
 *      - Verificar método abstrato calculaFrete() da classe Compra e de suas filhas
 * Pontos de atenção:
 * [x] Comentários e identação
 * [x] Validação de campos (não permitir campos vazios)
 *      - Verificar validação no construtor da classe Marca
 * [x] Validação campos (não permitir informações totalmente numéricas)
 *      - Verificar validação no construtor da classe Produto
 *
 */

public class Main {
    public static void main(String[] args) {

        Marca m1 = new Marca("Omo");
        Marca m2 = new Marca("Minuano");
        Marca m3 = new Marca("Bauduco");
        Marca m4 = new Marca("Camponesa");
        Marca m5 = new Marca("Seda");
        Marca m6 = new Marca("seda"); // Não é adicionada à lista de marcas.
        Marca m7 = new Marca(""); // Não é adicionada à lista de marcas.
        System.out.println("Marcas cadastradas:");
        System.out.println(Marca.getMarcas());
        System.out.println("A marca **camponesa** está cadastrada? " + Marca.marcaJaExiste("camponesa")); // true
        System.out.println("A marca **pinho sol** está cadastrada? " + Marca.marcaJaExiste("pinho sol")); // false


        System.out.println();
        Produto p1 = new Produto("Sabão em pó Omo", m1, Categoria.LIMPEZA, 9.00);
        Produto p2 = new Produto("Detergente Minuano", m2, Categoria.LIMPEZA, 7.50);
        Produto p3 = new Produto("Biscoito recheado Bauduco", m3, Categoria.ALIMENTACAO, 4.99);
        Produto p4 = new Produto("Leite líquido 1L Camponesa", m4, Categoria.ALIMENTACAO, 3.45);
        Produto p5 = new Produto("Leite líquido 1L Camponesa", m4, Categoria.PETSHOP, 9.00); // Não é adicionad à
        // lista de produtos.
        Produto p6 = new Produto("", m4, Categoria.PETSHOP, 9.00); // Não é adicionad à
        // lista de produtos.
        Produto p7 = new Produto("122333", m4, Categoria.PETSHOP, 9.00); // Não é adicionad à
        // lista de produtos.
        System.out.println("Produtos cadastrados:");
        System.out.println(Produto.getProdutos());
        System.out.println("O **detergente minuano** está cadastrado? " +
                Produto.produtoJaExiste("detergente minuano")); // true
        System.out.println("A **bolacha nestle** está cadastrada? " +
                Produto.produtoJaExiste("Bolacha Nestlé")); // false

        System.out.println();
        System.out.println("Remoção de marcas:");
        System.out.println(Marca.removerMarca(m5)); // Funciona pois não há produto com essa marca.
        System.out.println(Marca.removerMarca(m3)); // Não funciona pois há produto cadastrado com essa marca.
        System.out.println(Marca.getMarcas());

        System.out.println();
        System.out.println("Remoção de produtos:");
        System.out.println(Produto.removerProduto("Biscoito recheado Bauduco"));
        System.out.println(Produto.removerProduto(p2));
        System.out.println(Produto.getProdutos());

        System.out.println();
        System.out.println("Interface Estoque:");
        System.out.println("Estoque Produto " + p1.getNomeGenerico() + ": " + p1.getQuantidadeEmEstoque());
        System.out.println("Adicionando 100 unidades ao estoque...");
        p1.setQuantidadeEmEstoque(100);
        System.out.println("Estoque Produto " + p1.getNomeGenerico() + ": " + p1.getQuantidadeEmEstoque());

        System.out.println();
        System.out.println("Polimorfismo com calculaFrete()");
        Compra compraComFornecedor = new CompraFornecedor(100, p1);
        System.out.println("Valor da compra com fornecedor: " + compraComFornecedor.getValorDaCompra());
        System.out.println("Valor do frete (30%): " + compraComFornecedor.calculaFrete());
        System.out.println("-------------------------------------");

        Compra compraComEcommerceMenos150 = new CompraEcommerce(10, p2);
        System.out.println("Valor da compra por ecommerce: " + compraComEcommerceMenos150.getValorDaCompra());
        System.out.println("Valor do frete (10% se > 150.00, senão, grátis): " + compraComEcommerceMenos150.calculaFrete());
        System.out.println("-------------------------------------");

        Compra compraComEcommerceMais150 = new CompraEcommerce(30, p2);
        System.out.println("Valor da compra por ecommerce: " + compraComEcommerceMais150.getValorDaCompra());
        System.out.println("Valor do frete (10% se > 150.00, senão, grátis): " + compraComEcommerceMais150.calculaFrete());
        System.out.println("-------------------------------------");

        Compra compraNaLoja = new CompraLojaFisica(10, p2);
        System.out.println("Valor da compra na loja física: " + compraNaLoja.getValorDaCompra());
        System.out.println("Valor do frete (sem frete): " + compraNaLoja.calculaFrete());

    }

}
