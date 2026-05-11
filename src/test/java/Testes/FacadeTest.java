package Testes;

import hamburgueria.Combo;
import hamburgueria.Combos.FabricaComboVegano;
import hamburgueria.Descontos.DescontoFidelidade;
import hamburgueria.Descontos.DescontoPorcentagem;
import hamburgueria.HamburgueriaPedidoFacade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FacadeTest {

    private HamburgueriaPedidoFacade facade;

    @BeforeEach
    public void setUp() {
        facade = new HamburgueriaPedidoFacade();
    }

    // ─── Abstract Factory usada internamente ─────────────────────────────────

    @Test
    public void deveCriarPedidoTradicionalComDescricaoCorretaDaFabrica() {
        Combo combo = facade.criarPedidoTradicional();

        assertEquals("Hambúrguer Clássico de Carne Bovina",
                combo.getHamburguer().getDescricao());
    }

    @Test
    public void deveCriarPedidoTradicionalComPrecoCorretoDaFabrica() {
        Combo combo = facade.criarPedidoTradicional();

        assertEquals(16.0, combo.getPrecoFinal());
    }

    @Test
    public void deveCriarPedidoVeganoComDescricaoCorretaDaFabrica() {
        Combo combo = facade.criarPedidoVegano();

        assertEquals("Smash Burger de Proteína de Ervilha",
                combo.getHamburguer().getDescricao());
    }

    @Test
    public void deveCriarPedidoVeganoComPrecoCorretoDaFabrica() {
        Combo combo = facade.criarPedidoVegano();

        assertEquals(17.0, combo.getPrecoFinal());
    }

    @Test
    public void deveCriarPedidoPersonalizadoAceitandoQualquerFabrica() {
        Combo combo = facade.criarPedidoPersonalizado(new FabricaComboVegano());

        assertEquals("Smash Burger de Proteína de Ervilha",
                combo.getHamburguer().getDescricao());
    }

    // ─── Observer registrado pelo Builder ────────────────────────────────────

    @Test
    public void deveComboCriadoJaTerObserversRegistrados() {
        Combo combo = facade.criarPedidoTradicional();

        assertDoesNotThrow(combo::finalizarPedido);
    }

    // ─── Mediator via Atendente ───────────────────────────────────────────────

    @Test
    public void deveEnviarPedidoRotearParaCozinhaECaixaViaMediator() {
        Combo combo = facade.criarPedidoTradicional();

        String resposta = facade.enviarPedido(combo);

        assertTrue(resposta.contains("PedidoMediator"));
        assertTrue(resposta.contains("Cozinha"));
        assertTrue(resposta.contains("Caixa"));
    }

    @Test
    public void deveCancelarPedidoNotificarAmbosSetos() {
        Combo combo = facade.criarPedidoVegano();

        String resposta = facade.cancelarPedido(combo);

        assertTrue(resposta.contains("cancelamento"));
        assertTrue(resposta.contains("cancelou o preparo"));
        assertTrue(resposta.contains("estornou"));
    }

    // ─── Strategy aplicada pelo Facade ───────────────────────────────────────

    @Test
    public void deveAplicarDescontoPorcentagemEProcessarPagamento() {
        Combo combo = facade.criarPedidoTradicional();

        String resposta = facade.aplicarDescontoEProcessarPagamento(
                combo, new DescontoPorcentagem(10));

        assertTrue(resposta.contains("pagamento"));
        assertTrue(resposta.contains("14,40") || resposta.contains("14.40"));
        assertEquals(14.4, combo.getPrecoFinal(), 0.001);
    }

    @Test
    public void deveAplicarDescontoFidelidadeEProcessarPagamento() {
        Combo combo = facade.criarPedidoVegano();

        String resposta = facade.aplicarDescontoEProcessarPagamento(
                combo, new DescontoFidelidade(5.0));

        assertTrue(resposta.contains("pagamento"));
        assertEquals(12.0, combo.getPrecoFinal());
    }

    // ─── Fluxo completo via Facade ────────────────────────────────────────────

    @Test
    public void deveFluxoCompletoNaoLancarExcecao() {
        assertDoesNotThrow(() -> {
            Combo combo = facade.criarPedidoTradicional();
            facade.enviarPedido(combo);
            facade.aplicarDescontoEProcessarPagamento(combo, new DescontoPorcentagem(20));
        });
    }

    @Test
    public void deveFacadeIsolarClienteDeTodosOsSubsistemas() {
        Combo tradicional = facade.criarPedidoTradicional();
        Combo vegano      = facade.criarPedidoVegano();

        assertNotNull(tradicional);
        assertNotNull(vegano);
        assertNotEquals(tradicional.getHamburguer().getDescricao(),
                vegano.getHamburguer().getDescricao());
    }

}
