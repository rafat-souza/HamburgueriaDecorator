package hamburgueria.Extras;

import hamburgueria.Hamburguer;
import hamburgueria.IngredienteDecorator;

public class Queijo extends IngredienteDecorator {
    public Queijo(Hamburguer hamburguer) { super(hamburguer);}
    @Override
    public String getDescricao() { return hamburguer.getDescricao() + " + Queijo Cheddar"; }
    @Override
    public double getPreco() { return hamburguer.getPreco() + 3.0; }
}
