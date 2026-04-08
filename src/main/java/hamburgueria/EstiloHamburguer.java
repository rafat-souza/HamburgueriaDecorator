package hamburgueria;

public abstract class EstiloHamburguer implements Hamburguer {
    protected Proteina proteina;

    public EstiloHamburguer(Proteina proteina) {
        this.proteina = proteina;
    }
}
