package entidades;

public class CompraFornecedor extends Compra {

    public CompraFornecedor(int quantidade, Produto produto) {
        super(quantidade, produto);
    }

    @Override
    public double calculaFrete() {
        return 0.3 * super.getValorDaCompra();
    }
}
