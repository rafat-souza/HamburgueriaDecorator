package hamburgueria.Extras;

import hamburgueria.Hamburguer;
import hamburgueria.IngredienteDecorator;

public class CebolaCaramelizada extends IngredienteDecorator {

    public CebolaCaramelizada(Hamburguer hamburguer) { super(hamburguer); }

    @Override
    public String getDescricao() {
        return hamburguer.getDescricao() + " + Cebola Caramelizada";
    }

    @Override
    public double getPreco() {
        return hamburguer.getPreco() + 2.50;
    }
}