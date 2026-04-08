package hamburgueria.EstilosDeBurger;

import hamburgueria.EstiloHamburguer;
import hamburgueria.Proteina;

public class BurgerClassico extends EstiloHamburguer {
    public BurgerClassico(Proteina proteina) { super(proteina);}

    @Override
    public String getDescricao() {return "Hambúrguer Clássico de " + proteina.getNome();}
    @Override
    public double getPreco() { return proteina.getPrecoBase() + 6.0;}
}
