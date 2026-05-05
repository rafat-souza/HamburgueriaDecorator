package hamburgueria.EstilosDeBurger;

import hamburgueria.EstiloHamburguer;
import hamburgueria.Proteina;

public class SmashBurger extends EstiloHamburguer {
    public SmashBurger(Proteina proteina) {super(proteina);}

    @Override
    protected String getEstilo() { return "Smash Burger"; }

    @Override
    public double getPreco() { return proteina.getPrecoBase() + 5.0; }
}
