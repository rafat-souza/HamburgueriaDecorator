package hamburgueria;

import java.util.ArrayList;
import java.util.List;

public class Combo {
    private Hamburguer hamburguer;
    private Acompanhamento acompanhamento;
    private Bebida bebida;
    private List<PedidoObserver> observers = new ArrayList<>();

    public Combo(FabricaDeCombo fabrica) {
        this.hamburguer = fabrica.criarHamburguer();
        this.acompanhamento = fabrica.criarAcompanhamento();
        this.bebida = fabrica.criarBebida();
    }

    public void adicionarObserver(PedidoObserver observer) {
        observers.add(observer);
    }

    public void removerObserver(PedidoObserver observer) {
        observers.remove(observer);
    }

    public void finalizarPedido() {
        for (PedidoObserver observer : observers) {
            observer.onPedidoFinalizado(this);
        }
    }

    public void adicionarIngrediente(Hamburguer hamburguerDecorado) {
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