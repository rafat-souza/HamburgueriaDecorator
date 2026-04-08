package hamburgueria.Proteinas;

import hamburgueria.Proteina;

public class Planta implements Proteina {
    @Override
    public String getNome() { return "Proteína de Ervilha"; }
    @Override
    public double getPrecoBase() { return 12.0; }
}
