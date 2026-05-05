package Testes;

import hamburgueria.EstilosDeBurger.BurgerClassico;
import hamburgueria.EstilosDeBurger.BurgerGourmet;
import hamburgueria.EstilosDeBurger.SmashBurger;
import hamburgueria.Hamburguer;
import hamburgueria.Proteinas.Carne;
import hamburgueria.Proteinas.Planta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EstilosTest {
    @Test
    public void deveIniciarDescricaoComNomeDoEstiloClassico() {
        Hamburguer burger = new BurgerClassico(new Carne());
        assertTrue(burger.getDescricao().startsWith("Hambúrguer Clássico"));
    }

    @Test
    public void deveIniciarDescricaoComNomeDoEstiloSmash() {
        Hamburguer burger = new SmashBurger(new Carne());
        assertTrue(burger.getDescricao().startsWith("Smash Burger"));
    }

    @Test
    public void deveIniciarDescricaoComNomeDoEstiloGourmet() {
        Hamburguer burger = new BurgerGourmet(new Carne());
        assertTrue(burger.getDescricao().startsWith("Burger Gourmet"));
    }

    @Test
    public void deveIncluirNomeDaProteinaCarneNaDescricao() {
        Hamburguer burger = new SmashBurger(new Carne());
        assertTrue(burger.getDescricao().contains("Carne Bovina"));
    }

    @Test
    public void deveIncluirNomeDaProteinaPlantaNaDescricao() {
        Hamburguer burger = new BurgerClassico(new Planta());
        assertTrue(burger.getDescricao().contains("Proteína de Ervilha"));
    }

    @Test
    public void deveSupprimirExtrasNaDescricaoQuandoHookNaoESobrescrito() {
        Hamburguer classico = new BurgerClassico(new Carne());
        Hamburguer smash    = new SmashBurger(new Planta());

        assertFalse(classico.getDescricao().contains("("));
        assertFalse(smash.getDescricao().contains("("));
    }

    @Test
    public void deveAdicionarExtrasDoPaoAoUsarHookSobrescritoNoGourmet() {
        Hamburguer burger = new BurgerGourmet(new Carne());
        assertTrue(burger.getDescricao().contains("Pão Brioche Artesanal"));
    }

    @Test
    public void deveMontarDescricaoCompletaDoSmashBurgerVegano() {
        Hamburguer burger = new SmashBurger(new Planta());
        assertEquals("Smash Burger de Proteína de Ervilha", burger.getDescricao());
    }

    @Test
    public void deveMontarDescricaoCompletaDoClassicoCarne() {
        Hamburguer burger = new BurgerClassico(new Carne());
        assertEquals("Hambúrguer Clássico de Carne Bovina", burger.getDescricao());
    }

    @Test
    public void deveMontarDescricaoCompletaDoGourmetComHook() {
        Hamburguer burger = new BurgerGourmet(new Carne());
        assertEquals("Burger Gourmet de Carne Bovina (Pão Brioche Artesanal)", burger.getDescricao());
    }

    @Test
    public void deveCalcularPrecoDoClassicoComCarne() {
        Hamburguer burger = new BurgerClassico(new Carne());
        assertEquals(16.0, burger.getPreco());
    }

    @Test
    public void deveCalcularPrecoDoSmashComPlanta() {
        Hamburguer burger = new SmashBurger(new Planta());
        assertEquals(17.0, burger.getPreco());
    }

    @Test
    public void deveCalcularPrecoDoGourmetComCarne() {
        Hamburguer burger = new BurgerGourmet(new Carne());
        assertEquals(20.0, burger.getPreco());
    }

    @Test
    public void deveMudarDescricaoAoTrocarProteinaMantentoMesmoEstilo() {
        Hamburguer comCarne  = new BurgerClassico(new Carne());
        Hamburguer comPlanta = new BurgerClassico(new Planta());

        assertNotEquals(comCarne.getDescricao(), comPlanta.getDescricao());
        assertTrue(comCarne.getDescricao().startsWith("Hambúrguer Clássico"));
        assertTrue(comPlanta.getDescricao().startsWith("Hambúrguer Clássico"));
    }

    @Test
    public void deveMudarPrecoAoTrocarProteinaMantentoMesmoEstilo() {
        Hamburguer comCarne  = new BurgerClassico(new Carne());
        Hamburguer comPlanta = new BurgerClassico(new Planta());

        assertNotEquals(comCarne.getPreco(), comPlanta.getPreco());
    }
}
