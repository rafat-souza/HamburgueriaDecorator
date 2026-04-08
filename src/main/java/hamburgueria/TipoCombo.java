package hamburgueria;

import hamburgueria.Combos.FabricaComboTradicional;
import hamburgueria.Combos.FabricaComboVegano;

public enum TipoCombo {
    TRADICIONAL {
        @Override
        public FabricaDeCombo instanciarFabrica() {
            return new FabricaComboTradicional();
        }
    },
    VEGANO {
        @Override
        public FabricaDeCombo instanciarFabrica() {
            return new FabricaComboVegano();
        }
    };

    public abstract FabricaDeCombo instanciarFabrica();
}
