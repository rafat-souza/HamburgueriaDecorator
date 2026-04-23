package hamburgueria.Observadores;

import hamburgueria.Combo;
import hamburgueria.PedidoObserver;

public class Caixa implements PedidoObserver {
    @Override
    public void onPedidoFinalizado(Combo combo) {
        System.out.println("[Caixa] Cobrança: R$ " + combo.getHamburguer().getPreco());
    }
}
