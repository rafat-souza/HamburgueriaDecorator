package hamburgueria;

public interface EstrategiaDeDesconto {
    double aplicar(double preco);
    String getDescricao();
}
