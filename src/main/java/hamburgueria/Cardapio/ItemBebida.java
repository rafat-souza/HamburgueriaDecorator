package hamburgueria.Cardapio;

import hamburgueria.Bebida;

public class ItemBebida extends ItemCardapio{

    private final Bebida bebida;

    public ItemBebida(Bebida bebida) {
        super(bebida.getDescricao());
        this.bebida = bebida;
    }

    public Bebida getBebida() {
        return bebida;
    }

    @Override
    public String getDetalhes() {
        return "Bebida: " + bebida.getDescricao() + "\n";
    }

}
