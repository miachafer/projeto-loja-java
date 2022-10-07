package entidades;

public class CompraEcommerce extends Compra{

    public CompraEcommerce(int quantidade, Produto produto) {
        super(quantidade, produto);
    }

    @Override
    public double calculaFrete() {
        double valorDaCompra = getValorDaCompra();
        if (valorDaCompra < 150.0) {
            return 0.1 * valorDaCompra;
        } else return 0.0;
    }
}
