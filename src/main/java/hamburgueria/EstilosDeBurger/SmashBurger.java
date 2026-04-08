package hamburgueria.EstilosDeBurger;

import hamburgueria.EstiloHamburguer;
import hamburgueria.Proteina;

public class SmashBurger extends EstiloHamburguer {
    public SmashBurger(Proteina proteina) {super(proteina);}
    @Override
    public String getDescricao() {return "Smash Burger de " + proteina.getNome();}
    @Override
    public double getPreco() { return proteina.getPrecoBase() + 5.0; }
}
