package hamburgueria.Combos;

import hamburgueria.*;
import hamburgueria.Acompanhamentos.Salada;
import hamburgueria.Bebidas.SucoNatural;
import hamburgueria.EstilosDeBurger.SmashBurger;
import hamburgueria.Proteinas.Planta;

public class FabricaComboVegano implements FabricaDeCombo {
    @Override
    public Hamburguer criarHamburguer() { return new SmashBurger(new Planta());
    }

    @Override
    public Acompanhamento criarAcompanhamento() {
        return new Salada();
    }

    @Override
    public Bebida criarBebida() { return new SucoNatural(); }
}
