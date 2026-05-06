package hamburgueria;

public class Atendente {

    public String fazerPedido(Combo combo) {
        return PedidoMediator.getInstancia().receberNovoPedidoAtendente(combo);
    }

    public String cancelarPedido(Combo combo) {
        return PedidoMediator.getInstancia().receberCancelamentoAtendente(combo);
    }

    public String processarPagamento(Combo combo) {
        return PedidoMediator.getInstancia().receberPagamentoAtendente(combo);
    }

}
