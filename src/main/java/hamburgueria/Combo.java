package hamburgueria;

public class Combo {
    private Hamburguer hamburguer;
    private Acompanhamento acompanhamento;
    private Bebida bebida;

    public Combo(FabricaDeCombo fabrica) {
        this.hamburguer = fabrica.criarHamburguer();
        this.acompanhamento = fabrica.criarAcompanhamento();
        this.bebida = fabrica.criarBebida();
    }

    public void adicioanrIngrediente(Hamburguer hamburguerDecorado) {
        this.hamburguer = hamburguerDecorado;
    }

    public Hamburguer getHamburguer() { return this.hamburguer; }

    public void exibirResumo() {
        System.out.println("Lanche: " + hamburguer.getDescricao() + " | R$ " + hamburguer.getPreco());
        System.out.println("Acompanhamento: " + acompanhamento.getDescricao());
        System.out.println("Bebida: " + bebida.getDescricao());
        System.out.println("--------------------------------------------------");
    }
}
