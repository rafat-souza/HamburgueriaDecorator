package Testes;

import hamburgueria.Proteina;
import hamburgueria.Proteinas.Carne;
import hamburgueria.Proteinas.Planta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProteinasTest {
    @Test
    public void testProteinaCarneEPlantaValoresBase() {
        Proteina carne = new Carne();
        Proteina planta = new Planta();

        assertEquals("Carne Bovina", carne.getNome());
        assertEquals(10.0, carne.getPrecoBase());

        assertEquals("Proteína de Ervilha", planta.getNome());
        assertEquals(12.0, planta.getPrecoBase());
    }
}
