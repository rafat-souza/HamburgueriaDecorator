package Testes;

import hamburgueria.Combo;
import hamburgueria.Combos.FabricaComboTradicional;
import hamburgueria.Combos.FabricaComboVegano;
import hamburgueria.Descontos.DescontoFidelidade;
import hamburgueria.Descontos.DescontoPorcentagem;
import hamburgueria.Descontos.SemDesconto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DescontoTest {

    @Test
    public void deveSemDescontoManterPrecoOriginal() {
        Combo combo = new Combo(new FabricaComboTradicional());

        combo.setEstrategiaDeDesconto(new SemDesconto());

        assertEquals(16.0, combo.getPrecoFinal());
    }

    @Test
    public void deveFazerDescontoPorcentagemReduzirPrecoCorretamente() {
        Combo combo = new Combo(new FabricaComboTradicional());

        combo.setEstrategiaDeDesconto(new DescontoPorcentagem(10));

        assertEquals(14.4, combo.getPrecoFinal(), 0.001);
    }

    @Test
    public void deveFazerDescontoFidelidadeSubtrairValorFixo() {
        Combo combo = new Combo(new FabricaComboVegano());

        combo.setEstrategiaDeDesconto(new DescontoFidelidade(5.0));

        assertEquals(12.0, combo.getPrecoFinal());
    }

    @Test
    public void deveFazerEstrategiaPodeSerTrocadaEmRuntime() {
        Combo combo = new Combo(new FabricaComboTradicional());

        combo.setEstrategiaDeDesconto(new DescontoPorcentagem(50));
        assertEquals(8.0, combo.getPrecoFinal());

        combo.setEstrategiaDeDesconto(new DescontoFidelidade(3.0));
        assertEquals(13.0, combo.getPrecoFinal());
    }

    @Test
    public void naoDeveDescontoFidelidadeRetornarPrecoNegativo() {
        Combo combo = new Combo(new FabricaComboTradicional());
        combo.setEstrategiaDeDesconto(new DescontoFidelidade(999.0));

        assertEquals(0.0, combo.getPrecoFinal());
    }

}
