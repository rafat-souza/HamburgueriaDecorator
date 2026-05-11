package hamburgueria;

import hamburgueria.Combos.FabricaComboTradicional;
import hamburgueria.Combos.FabricaComboVegano;
import hamburgueria.Setores.Caixa;
import hamburgueria.Setores.Cozinha;

public class HamburgueriaPedidoFacade {

    private final Atendente atendente = new Atendente();

    public Combo criarPedidoTradicional() {
        FabricaDeCombo fabrica = new FabricaComboTradicional();
        return new ComboBuilder()
                .setHamburguer(fabrica.criarHamburguer())
                .setAcompanhamento(fabrica.criarAcompanhamento())
                .setBebida(fabrica.criarBebida())
                .adicionarObserver(new Cozinha())
                .adicionarObserver(new Caixa())
                .build();
    }

    public Combo criarPedidoVegano() {
        FabricaDeCombo fabrica = new FabricaComboVegano();
        return new ComboBuilder()
                .setHamburguer(fabrica.criarHamburguer())
                .setAcompanhamento(fabrica.criarAcompanhamento())
                .setBebida(fabrica.criarBebida())
                .adicionarObserver(new Cozinha())
                .adicionarObserver(new Caixa())
                .build();
    }

    public Combo criarPedidoPersonalizado(FabricaDeCombo fabrica) {
        return new ComboBuilder()
                .setHamburguer(fabrica.criarHamburguer())
                .setAcompanhamento(fabrica.criarAcompanhamento())
                .setBebida(fabrica.criarBebida())
                .adicionarObserver(new Cozinha())
                .adicionarObserver(new Caixa())
                .build();
    }

    public String enviarPedido(Combo combo) {
        return atendente.fazerPedido(combo);
    }

    public String aplicarDescontoEProcessarPagamento(Combo combo,
                                                     EstrategiaDeDesconto desconto) {
        combo.setEstrategiaDeDesconto(desconto);
        return atendente.processarPagamento(combo);
    }

    public String cancelarPedido(Combo combo) {
        return atendente.cancelarPedido(combo);
    }

}
