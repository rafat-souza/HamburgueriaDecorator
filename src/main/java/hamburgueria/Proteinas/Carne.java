package hamburgueria.Proteinas;

import hamburgueria.Proteina;

public class Carne implements Proteina {
    @Override
    public String getNome() { return "Carne Bovina"; }
    @Override
    public double getPrecoBase() { return 10.0; }
}
