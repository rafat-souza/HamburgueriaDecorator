package hamburgueria.EstilosDeBurger;

import hamburgueria.EstiloHamburguer;
import hamburgueria.Proteina;

public class BurgerGourmet extends EstiloHamburguer {

    public BurgerGourmet(Proteina proteina) { super(proteina); }

    @Override
    protected String getEstilo() { return "Burger Gourmet"; }

    @Override
    protected String montarExtras() { return " (Pão Brioche Artesanal)"; }

    @Override
    public double getPreco() { return proteina.getPrecoBase() + 10.0; }

}
