package hamburgueria.Descontos;

import hamburgueria.EstrategiaDeDesconto;

public class DescontoPorcentagem implements EstrategiaDeDesconto {

    private final double porcentagem;

    public DescontoPorcentagem(double porcentagem) {
        this.porcentagem = porcentagem;
    }

    @Override
    public double aplicar(double preco) {
        return preco * (1.0 - porcentagem / 100.0);
    }

    @Override
    public String getDescricao() { return "Desconto de " + porcentagem + "%"; }

}
