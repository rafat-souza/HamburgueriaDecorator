package Testes;

import hamburgueria.Atendente;
import hamburgueria.Combo;
import hamburgueria.Combos.FabricaComboTradicional;
import hamburgueria.Combos.FabricaComboVegano;
import hamburgueria.Descontos.DescontoPorcentagem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MediatorTest {

    @Test
    public void deveFazerPedidoRotearParaCozinhaECaixa() {
        Atendente atendente = new Atendente();
        Combo combo = new Combo(new FabricaComboTradicional());

        String resposta = atendente.fazerPedido(combo);

        assertTrue(resposta.contains("PedidoMediator"));
        assertTrue(resposta.contains("Cozinha"));
        assertTrue(resposta.contains("Caixa"));
    }

    @Test
    public void deveCancelarPedidoNotificarAmbosSetos() {
        Atendente atendente = new Atendente();
        Combo combo = new Combo(new FabricaComboVegano());

        String resposta = atendente.cancelarPedido(combo);

        assertTrue(resposta.contains("cancelamento"));
        assertTrue(resposta.contains("cancelou o preparo"));
        assertTrue(resposta.contains("estornou"));
    }

    @Test
    public void deveProcessarPagamentoComDescontoAplicado() {
        Atendente atendente = new Atendente();
        Combo combo = new Combo(new FabricaComboTradicional());
        combo.setEstrategiaDeDesconto(new DescontoPorcentagem(10));

        String resposta = atendente.processarPagamento(combo);

        assertTrue(resposta.contains("pagamento"));
        assertTrue(resposta.contains("14,40") || resposta.contains("14.40"));
    }

    @Test
    public void deveAtendenteComunicarSempreViaMediatorNuncaDiretamente() {

        Atendente atendente = new Atendente();
        Combo combo = new Combo(new FabricaComboTradicional());

        assertDoesNotThrow(() -> {
            atendente.fazerPedido(combo);
            atendente.processarPagamento(combo);
            atendente.cancelarPedido(combo);
        });
    }

}
