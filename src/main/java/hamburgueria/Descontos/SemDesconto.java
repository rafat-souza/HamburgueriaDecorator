package hamburgueria.Descontos;

import hamburgueria.EstrategiaDeDesconto;

public class SemDesconto implements EstrategiaDeDesconto {

    @Override
    public double aplicar(double preco) { return preco; }

    @Override
    public String getDescricao() { return "Sem desconto"; }

}
