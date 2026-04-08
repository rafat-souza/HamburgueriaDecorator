package hamburgueria.Extras;

import hamburgueria.Hamburguer;
import hamburgueria.IngredienteDecorator;

public class BaconVegano extends IngredienteDecorator {
    public BaconVegano(Hamburguer hamburguer) { super(hamburguer); }

    @Override
    public String getDescricao() { return hamburguer.getDescricao() + " + Bacon de soja"; }
    @Override
    public double getPreco() { return hamburguer.getPreco() + 4.0; }
}
