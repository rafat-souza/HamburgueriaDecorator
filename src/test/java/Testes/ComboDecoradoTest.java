package Testes;

import hamburgueria.Combo;
import hamburgueria.Combos.FabricaComboVegano;
import hamburgueria.Extras.CebolaCaramelizada;
import hamburgueria.Extras.Queijo;
import hamburgueria.FabricaDeCombo;
import hamburgueria.Hamburguer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ComboDecoradoTest {
    @Test
    public void testCriacaoDeComboComExtras() {

        FabricaDeCombo fabrica = new FabricaComboVegano();

        Combo combo = new Combo(fabrica);

        assertEquals(17.0, combo.getHamburguer().getPreco());

        Hamburguer lancheDoCombo = combo.getHamburguer();
        lancheDoCombo = new CebolaCaramelizada(lancheDoCombo);
        lancheDoCombo = new Queijo(lancheDoCombo);

        combo.adicionarIngrediente(lancheDoCombo);

        assertEquals(22.50, combo.getHamburguer().getPreco());
        assertTrue(combo.getHamburguer().getDescricao().contains("Cebola Caramelizada"));
    }
}
