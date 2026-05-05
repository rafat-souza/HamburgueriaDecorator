package hamburgueria.Descontos;

import hamburgueria.EstrategiaDeDesconto;

public class DescontoFidelidade implements EstrategiaDeDesconto {

    private final double valorFixo;

    public DescontoFidelidade(double valorFixo) {
        this.valorFixo = valorFixo;
    }

    @Override
    public double aplicar(double preco) {
        return Math.max(0, preco - valorFixo);
    }

    @Override
    public String getDescricao() { return "Desconto fidelidade de R$ " + valorFixo; }

}
