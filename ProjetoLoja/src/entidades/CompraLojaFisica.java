package entidades;

public class CompraLojaFisica extends Compra {

    public CompraLojaFisica(int quantidade, Produto produto) {
        super(quantidade, produto);
    }

    @Override
    public double calculaFrete() {
        return 0.0; // Frete = 0.0
    }
}
