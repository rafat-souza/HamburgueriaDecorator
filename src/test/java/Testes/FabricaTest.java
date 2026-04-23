package Testes;

import hamburgueria.Combos.FabricaComboTradicional;
import hamburgueria.Combos.FabricaComboVegano;
import hamburgueria.FabricaDeCombo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FabricaTest {
    @Test
    public void testEnumFactoryMethodRetornaInstanciaCorreta() {
        FabricaDeCombo f1 = new FabricaComboTradicional();
        FabricaDeCombo f2 = new FabricaComboVegano();

        assertTrue(f1 instanceof FabricaComboTradicional);
        assertTrue(f2 instanceof FabricaComboVegano);
    }
}
