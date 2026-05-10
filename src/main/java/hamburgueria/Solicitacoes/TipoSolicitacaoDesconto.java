package hamburgueria.Solicitacoes;

import hamburgueria.TipoSolicitacao;

public class TipoSolicitacaoDesconto implements TipoSolicitacao {

    private static TipoSolicitacaoDesconto tipoSolicitacaoDesconto =
            new TipoSolicitacaoDesconto();

    private TipoSolicitacaoDesconto() {}

    public static TipoSolicitacaoDesconto getTipoSolicitacaoDesconto() {
        return tipoSolicitacaoDesconto;
    }

}
