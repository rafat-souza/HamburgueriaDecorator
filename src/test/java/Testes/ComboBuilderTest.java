package Testes;

import hamburgueria.Acompanhamentos.BatataFrita;
import hamburgueria.Acompanhamentos.Salada;
import hamburgueria.Bebidas.Refrigerante;
import hamburgueria.Bebidas.SucoNatural;
import hamburgueria.Combo;
import hamburgueria.ComboBuilder;
import hamburgueria.Descontos.DescontoFidelidade;
import hamburgueria.Descontos.DescontoPorcentagem;
import hamburgueria.EstilosDeBurger.BurgerClassico;
import hamburgueria.EstilosDeBurger.BurgerGourmet;
import hamburgueria.EstilosDeBurger.SmashBurger;
import hamburgueria.Extras.Queijo;
import hamburgueria.Proteinas.Carne;
import hamburgueria.Proteinas.Planta;
import hamburgueria.Setores.Caixa;
import hamburgueria.Setores.Cozinha;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ComboBuilderTest {

    @Test
    public void deveConstruirComboComponenentesObrigatorios() {
        Combo combo = new ComboBuilder()
                .setHamburguer(new BurgerClassico(new Carne()))
                .setAcompanhamento(new BatataFrita())
                .setBebida(new Refrigerante())
                .build();

        assertEquals("Hambúrguer Clássico de Carne Bovina", combo.getHamburguer().getDescricao());
        assertEquals(16.0, combo.getHamburguer().getPreco());
    }

    @Test
    public void deveConstruirComboVeganoComSucoESalada() {
        Combo combo = new ComboBuilder()
                .setHamburguer(new SmashBurger(new Planta()))
                .setAcompanhamento(new Salada())
                .setBebida(new SucoNatural())
                .build();

        assertEquals("Smash Burger de Proteína de Ervilha", combo.getHamburguer().getDescricao());
        assertEquals(17.0, combo.getPrecoFinal());
    }

    @Test
    public void deveConstruirComboComDescontoPorcentagem() {
        Combo combo = new ComboBuilder()
                .setHamburguer(new BurgerClassico(new Carne()))
                .setAcompanhamento(new BatataFrita())
                .setBebida(new Refrigerante())
                .setDesconto(new DescontoPorcentagem(10))
                .build();

        assertEquals(14.4, combo.getPrecoFinal(), 0.001);
    }

    @Test
    public void deveConstruirComboComDescontoFidelidade() {
        Combo combo = new ComboBuilder()
                .setHamburguer(new SmashBurger(new Planta()))
                .setAcompanhamento(new Salada())
                .setBebida(new SucoNatural())
                .setDesconto(new DescontoFidelidade(5.0))
                .build();

        assertEquals(12.0, combo.getPrecoFinal());
    }

    @Test
    public void deveConstruirComboComObservers() {
        Combo combo = new ComboBuilder()
                .setHamburguer(new BurgerClassico(new Carne()))
                .setAcompanhamento(new BatataFrita())
                .setBebida(new Refrigerante())
                .adicionarObserver(new Cozinha())
                .adicionarObserver(new Caixa())
                .build();

        assertDoesNotThrow(() -> combo.finalizarPedido());
    }

    @Test
    public void deveConstruirComboGourmetComExtraDecorado() {
        Combo combo = new ComboBuilder()
                .setHamburguer(new Queijo(new BurgerGourmet(new Carne())))
                .setAcompanhamento(new BatataFrita())
                .setBebida(new Refrigerante())
                .build();

        assertTrue(combo.getHamburguer().getDescricao().contains("Queijo Cheddar"));
        assertEquals(23.0, combo.getHamburguer().getPreco());
    }

    @Test
    public void deveLancarExcecaoSemHamburguer() {
        ComboBuilder builder = new ComboBuilder()
                .setAcompanhamento(new BatataFrita())
                .setBebida(new Refrigerante());

        IllegalStateException ex = assertThrows(IllegalStateException.class, builder::build);
        assertTrue(ex.getMessage().contains("Hambúrguer"));
    }

    @Test
    public void deveLancarExcecaoSemAcompanhamento() {
        ComboBuilder builder = new ComboBuilder()
                .setHamburguer(new BurgerClassico(new Carne()))
                .setBebida(new Refrigerante());

        IllegalStateException ex = assertThrows(IllegalStateException.class, builder::build);
        assertTrue(ex.getMessage().contains("Acompanhamento"));
    }

    @Test
    public void deveLancarExcecaoSemBebida() {
        ComboBuilder builder = new ComboBuilder()
                .setHamburguer(new BurgerClassico(new Carne()))
                .setAcompanhamento(new BatataFrita());

        IllegalStateException ex = assertThrows(IllegalStateException.class, builder::build);
        assertTrue(ex.getMessage().contains("Bebida"));
    }

    @Test
    public void deveSemDescontoSerAplicadoPorPadrao() {
        Combo combo = new ComboBuilder()
                .setHamburguer(new BurgerClassico(new Carne()))
                .setAcompanhamento(new BatataFrita())
                .setBebida(new Refrigerante())
                .build();

        assertEquals(combo.getHamburguer().getPreco(), combo.getPrecoFinal());
    }

}
