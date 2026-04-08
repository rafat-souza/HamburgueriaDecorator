package hamburgueria.Combos;

import hamburgueria.*;
import hamburgueria.Acompanhamentos.BatataFrita;
import hamburgueria.Bebidas.Refrigerante;
import hamburgueria.EstilosDeBurger.BurgerClassico;
import hamburgueria.Proteinas.Carne;

public class FabricaComboTradicional implements FabricaDeCombo {
    @Override
    public Hamburguer criarHamburguer() {
        return new BurgerClassico(new Carne());
    }
    @Override
    public Acompanhamento criarAcompanhamento() {
        return new BatataFrita();
    }
    @Override
    public Bebida criarBebida() { return new Refrigerante();
    }
}
