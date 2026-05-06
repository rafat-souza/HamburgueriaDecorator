package hamburgueria;

public interface SetorDaHamburgueria {
    String receberNovoPedido(Combo combo);
    String receberCancelamento(Combo combo);
    String receberPagamento(Combo combo);
}
