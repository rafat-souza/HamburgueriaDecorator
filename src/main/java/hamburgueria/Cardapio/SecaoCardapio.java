package hamburgueria.Cardapio;

import java.util.ArrayList;
import java.util.List;

public class SecaoCardapio extends ItemCardapio {

    private List<ItemCardapio> itens;

    public SecaoCardapio(String descricao) {
        super(descricao);
        this.itens = new ArrayList<>();
    }

    public void addItem(ItemCardapio item) {
        this.itens.add(item);
    }

    public void removeItem(ItemCardapio item) {
        this.itens.remove(item);
    }

    public List<ItemCardapio> getItens() {
        return itens;
    }

    @Override
    public String getDetalhes() {
        StringBuilder saida = new StringBuilder();
        saida.append("=== ").append(getDescricao()).append(" ===\n");
        for (ItemCardapio item : itens) {
            saida.append(item.getDetalhes());
        }
        return saida.toString();
    }

}
