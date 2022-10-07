package entidades;

import enums.Categoria;
import interfaces.Estoque;

import java.util.ArrayList;
import java.util.List;

/**
 * REGRAS DE NEGÓCIO
 * 1. Um produto não pode ser criado se já existir outro com o mesmo nome. Para isso utiliza-se o método estático
 * chamado produtoJaExiste(String nome).
 * 2. É possível ver a lista de produtos cadastrados usando o método estático getProdutos().
 * 3. É possível remover um produto da lista de produtos usando o método estático sobrecarregado case insensitive
 * removerProduto() que aceita tanto objetos Produto quanto strings.
 * 4. A classe implementa a interface Estoque que tem o getter e setter implementados na classe.
 *
 */

public class Produto implements Estoque {

    private String nomeGenerico;
    private Marca marca;
    private Categoria categoria;
    private double preco;
    private static List<Produto> produtos = new ArrayList<>();
    private int quantidadeEmEstoque;

    public Produto(String nomeGenerico, Marca marca, Categoria categoria, double preco) {
        if (produtoJaExiste(nomeGenerico)) {
            System.out.println("Produto " + nomeGenerico + " já está cadastrado.");
        } else if (nomeGenerico.isEmpty()) {
            System.out.println("Produto não pôde ser criado pois não tem nome válido.");
        } else if (eNumerico(nomeGenerico)) {
            System.out.println("O produto não pôde ser criado pois não seu nome não pode ser composto apenas por " +
                    "números.");
        } else {
            this.nomeGenerico = nomeGenerico;
            this.marca = marca;
            this.categoria = categoria;
            this.preco = preco;
            Produto.produtos.add(this);
        }
    }

    public static boolean produtoJaExiste (String nome) {
        for (Produto p : produtos) {
            if (nome.equalsIgnoreCase(p.getNomeGenerico())) {
                return true;
            }
        } return false;
    }

    public static boolean eNumerico(String s) {
        return s.matches("-?\\d+(\\.\\d+)?");
    }

    public String getNomeGenerico() {
        return nomeGenerico;
    }

    public void setNomeGenerico(String nomeGenerico) {
        this.nomeGenerico = nomeGenerico;
    }

    public Marca getMarca() {
        return marca;
    }

    public static List<Produto> getProdutos() {
        return produtos;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public static String removerProduto(Produto produto) {
        produtos.remove(produto);
        return "O produto **" + produto.getNomeGenerico() + "** foi removido com sucesso.";
    }

    public static String removerProduto(String nomeDoProduto) {
        for (Produto p : Produto.getProdutos()){
            if (p.getNomeGenerico().equalsIgnoreCase(nomeDoProduto)) {
                produtos.remove(p);
                return "O produto **" + nomeDoProduto + "** foi removido com sucesso.";
            }
        }
        return "O produto " + nomeDoProduto + " não pôde ser removido porque não está cadastrado.";
    }


    @Override
    public String toString() {
        return "Produto: {" +
                "nomeGenerico = '" + nomeGenerico + '\'' +
                ", marca = " + marca.getNome() +
                ", categoria = " + categoria +
                '}';
    }

    @Override
    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;

    }

    @Override
    public void setQuantidadeEmEstoque(int quantidade) {
        this.quantidadeEmEstoque = quantidade;
    }
}
