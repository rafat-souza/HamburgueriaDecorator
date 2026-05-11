package hamburgueria.Cardapio;

import hamburgueria.Acompanhamento;

public class ItemAcompanhamento extends ItemCardapio{

    private final Acompanhamento acompanhamento;

    public ItemAcompanhamento(Acompanhamento acompanhamento) {
        super(acompanhamento.getDescricao());
        this.acompanhamento = acompanhamento;
    }

    public Acompanhamento getAcompanhamento() {
        return acompanhamento;
    }

    @Override
    public String getDetalhes() {
        return "Acompanhamento: " + acompanhamento.getDescricao() + "\n";
    }

}
