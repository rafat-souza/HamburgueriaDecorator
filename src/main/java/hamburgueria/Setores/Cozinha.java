package hamburgueria.Setores;

import hamburgueria.Combo;
import hamburgueria.PedidoObserver;
import hamburgueria.SetorDaHamburgueria;

public class Cozinha implements PedidoObserver, SetorDaHamburgueria {

    @Override
    public void onPedidoFinalizado(Combo combo) {
        System.out.println("[Cozinha] Novo pedido recebido: " + combo.getHamburguer().getDescricao());
    }

    @Override
    public String receberNovoPedido(Combo combo) {
        return "A Cozinha começou a preparar: " + combo.getHamburguer().getDescricao();
    }

    @Override
    public String receberCancelamento(Combo combo) {
        return "A Cozinha cancelou o preparo de: " + combo.getHamburguer().getDescricao();
    }

    @Override
    public String receberPagamento(Combo combo) {
        return "A Cozinha foi informada que o pagamento foi confirmado para: "
                + combo.getHamburguer().getDescricao();
    }

}
