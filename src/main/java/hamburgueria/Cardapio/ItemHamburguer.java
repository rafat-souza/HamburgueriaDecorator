package hamburgueria.Cardapio;

import hamburgueria.Hamburguer;

public class ItemHamburguer extends ItemCardapio {

    private final Hamburguer hamburguer;

    public ItemHamburguer(Hamburguer hamburguer) {
        super(hamburguer.getDescricao());
        this.hamburguer = hamburguer;
    }

    public Hamburguer getHamburguer() {
        return hamburguer;
    }

    @Override
    public String getDetalhes() {
        return "Lanche: " + hamburguer.getDescricao()
                + " - R$ " + String.format("%.2f", hamburguer.getPreco()) + "\n";
    }

}
