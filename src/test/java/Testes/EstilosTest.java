package Testes;

import hamburgueria.EstilosDeBurger.BurgerClassico;
import hamburgueria.EstilosDeBurger.SmashBurger;
import hamburgueria.Hamburguer;
import hamburgueria.Proteinas.Carne;
import hamburgueria.Proteinas.Planta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EstilosTest {
    @Test
    public void testBridgeEstilosDeHamburger() {
        Hamburguer smashVegano = new SmashBurger(new Planta());

        assertEquals("Smash Burger de Proteína de Ervilha", smashVegano.getDescricao());
        assertEquals(17.0, smashVegano.getPreco());

        Hamburguer classicoCarne = new BurgerClassico(new Carne());

        assertEquals("Hambúrguer Clássico de Carne Bovina", classicoCarne.getDescricao());
        assertEquals(16.0, classicoCarne.getPreco());
    }
}
