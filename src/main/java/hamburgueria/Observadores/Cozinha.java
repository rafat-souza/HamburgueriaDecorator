package hamburgueria.Observadores;

import hamburgueria.Combo;
import hamburgueria.PedidoObserver;

public class Cozinha implements PedidoObserver {
    @Override
    public void onPedidoFinalizado(Combo combo) {
        System.out.println("[Cozinha] Novo pedido recebido: " + combo.getHamburguer().getDescricao());
    }
}
