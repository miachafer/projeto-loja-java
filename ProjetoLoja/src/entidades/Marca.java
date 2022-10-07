package entidades;

import java.util.HashSet;
import java.util.*;

/**
 * REGRAS DE NEGÓCIO
 * 1. Uma marca não pode ser criada se já existir outra com o mesmo nome. Para isso utiliza-se o método estático
 * chamado marcaJaExiste(String nome).
 * 2. É possível ver a lista de marcas cadastradas usando o método estático getMarcas().
 * 3. É possível conferir se uma marca já está cadastrado também por meio do método estático
 * chamado marcaJaExiste(String nome).
 * 4. O método estático removerMarca remove uma marca da lista de marcas se não houver produto relacionado a ela.
 */

public class Marca {
    private String nome;
    private static List<Marca> marcas = new ArrayList<>();

    public Marca(String nome) {
        if (!marcaJaExiste(nome) && !nome.isEmpty()) {
            this.nome = nome;
            Marca.marcas.add(this);
        } else if (marcaJaExiste(nome)) {
            System.out.println("Marca " + nome + " já está cadastrada.");
        } else {
            System.out.println("A marca não pôde ser cadastrada pois tem nome mulo.");
        }
    }

    public static boolean marcaJaExiste (String nome) {
        for (Marca m : marcas) {
            if (nome.equalsIgnoreCase(m.getNome())) {
                return true;
            }
        } return false;
    }

    public String getNome() {
        return nome;
    }

    public static List<Marca> getMarcas() {
        return marcas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static String removerMarca(Marca marca) {
        for (Produto p : Produto.getProdutos()){
            if (p.getMarca().equals(marca)) {
                return "A marca **" + marca.getNome() + "** não pode ser removida por que o produto **" +
                p.getNomeGenerico() + "** está relacionado a ela.";
            }
        }
        Marca.marcas.remove(marca);
        return "A marca **" + marca.getNome() + "** foi removida com sucesso.";
    }


    @Override
    public String toString() {
        return "Marca: " + nome;
    }
}
