package hamburgueria.Cardapio;

public class Cardapio {

    private ItemCardapio raiz;

    public void setRaiz(ItemCardapio raiz) {
        this.raiz = raiz;
    }

    public String getCardapio() {
        if (this.raiz == null) {
            throw new NullPointerException("Cardápio sem itens definidos");
        }
        return this.raiz.getDetalhes();
    }

}
