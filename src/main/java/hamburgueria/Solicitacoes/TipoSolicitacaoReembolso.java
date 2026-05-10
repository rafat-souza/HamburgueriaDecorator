package hamburgueria.Solicitacoes;

import hamburgueria.TipoSolicitacao;

public class TipoSolicitacaoReembolso implements TipoSolicitacao {

    private static TipoSolicitacaoReembolso tipoSolicitacaoReembolso =
            new TipoSolicitacaoReembolso();

    private TipoSolicitacaoReembolso() {}

    public static TipoSolicitacaoReembolso getTipoSolicitacaoReembolso() {
        return tipoSolicitacaoReembolso;
    }

}
