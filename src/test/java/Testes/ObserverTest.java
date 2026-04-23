package Testes;

import hamburgueria.Combo;
import hamburgueria.Combos.FabricaComboTradicional;
import hamburgueria.Observadores.Caixa;
import hamburgueria.Observadores.Cozinha;
import hamburgueria.PedidoObserver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ObserverTest {
    @Test
    public void testObserversNotificadosAoFinalizar() {
        Combo combo = new Combo(new FabricaComboTradicional());

        PedidoObserver cozinha = new Cozinha();
        PedidoObserver caixa = new Caixa();

        combo.adicionarObserver(cozinha);
        combo.adicionarObserver(caixa);

        assertDoesNotThrow(() -> combo.finalizarPedido());
    }
}
