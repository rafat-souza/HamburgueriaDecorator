package Testes;

import hamburgueria.Acompanhamento;
import hamburgueria.Bebida;
import hamburgueria.Combos.FabricaComboTradicional;
import hamburgueria.Combos.FabricaComboVegano;
import hamburgueria.FabricaDeCombo;
import hamburgueria.Hamburguer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CombosTest {
    @Test
    public void testFabricaComboTradicionalGeraProdutosCorretos() {
        FabricaDeCombo fabrica = new FabricaComboTradicional();

        Hamburguer h = fabrica.criarHamburguer();
        Acompanhamento a = fabrica.criarAcompanhamento();
        Bebida b = fabrica.criarBebida();

        assertEquals("Hambúrguer Clássico de Carne Bovina", h.getDescricao());
        assertEquals("Batata Frita Média", a.getDescricao());
        assertEquals("Refrigerante Cola", b.getDescricao());
    }

    @Test
    public void testFabricaComboVeganoGeraProdutosCorretos() {
        FabricaDeCombo fabrica = new FabricaComboVegano();

        Hamburguer h = fabrica.criarHamburguer();
        Acompanhamento a = fabrica.criarAcompanhamento();
        Bebida b = fabrica.criarBebida();

        assertEquals("Smash Burger de Proteína de Ervilha", h.getDescricao());
        assertEquals("Salada Orgânica", a.getDescricao());
        assertEquals("Suco de Laranja Natural", b.getDescricao());
    }
}
