package hamburgueria;

import hamburgueria.Descontos.SemDesconto;

import java.util.ArrayList;
import java.util.List;

public class ComboBuilder {

    private Hamburguer hamburguer;
    private Acompanhamento acompanhamento;
    private Bebida bebida;

    private EstrategiaDeDesconto desconto = new SemDesconto();
    private List<PedidoObserver> observers = new ArrayList<>();

    public ComboBuilder setHamburguer(Hamburguer hamburguer) {
        this.hamburguer = hamburguer;
        return this;
    }

    public ComboBuilder setAcompanhamento(Acompanhamento acompanhamento) {
        this.acompanhamento = acompanhamento;
        return this;
    }

    public ComboBuilder setBebida(Bebida bebida) {
        this.bebida = bebida;
        return this;
    }

    public ComboBuilder setDesconto(EstrategiaDeDesconto desconto) {
        this.desconto = desconto;
        return this;
    }

    public ComboBuilder adicionarObserver(PedidoObserver observer) {
        this.observers.add(observer);
        return this;
    }

    public Combo build() {
        validar(hamburguer == null,     "Hambúrguer é obrigatório para montar o combo.");
        validar(acompanhamento == null, "Acompanhamento é obrigatório para montar o combo.");
        validar(bebida == null,         "Bebida é obrigatória para montar o combo.");

        Combo combo = new Combo(hamburguer, acompanhamento, bebida, desconto);
        observers.forEach(combo::adicionarObserver);
        return combo;
        }

    private void validar(boolean invalido, String mensagem) {
        if (invalido) throw new IllegalStateException(mensagem);
    }

}
