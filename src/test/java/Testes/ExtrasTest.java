package Testes;

import hamburgueria.EstilosDeBurger.BurgerClassico;
import hamburgueria.EstilosDeBurger.SmashBurger;
import hamburgueria.Extras.BaconVegano;
import hamburgueria.Extras.CebolaCaramelizada;
import hamburgueria.Extras.Queijo;
import hamburgueria.Hamburguer;
import hamburgueria.Proteinas.Carne;
import hamburgueria.Proteinas.Planta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExtrasTest {
    @Test
    public void testDecoratorUnicoIngrediente() {
        Hamburguer lancheBase = new BurgerClassico(new Carne());
        Hamburguer lancheComQueijo = new Queijo(lancheBase);

        assertTrue(lancheComQueijo.getDescricao().contains("+ Queijo Cheddar"));
        assertEquals(19.0, lancheComQueijo.getPreco());
    }

    @Test
    public void testDecoratorMultiplosIngredientesEmCadeia() {
        Hamburguer lanche = new SmashBurger(new Planta());

        lanche = new Queijo(lanche);
        lanche = new BaconVegano(lanche);
        lanche = new CebolaCaramelizada(lanche);

        assertEquals(26.50, lanche.getPreco());
        assertTrue(lanche.getDescricao().contains("Queijo"));
        assertTrue(lanche.getDescricao().contains("Bacon de Soja"));
        assertTrue(lanche.getDescricao().contains("Cebola Caramelizada"));
    }
}
