package hamburgueria.Solicitacoes;

import hamburgueria.TipoSolicitacao;

public class TipoSolicitacaoCancelamento implements TipoSolicitacao {

    private static TipoSolicitacaoCancelamento tipoSolicitacaoCancelamento =
            new TipoSolicitacaoCancelamento();

    private TipoSolicitacaoCancelamento() {}

    public static TipoSolicitacaoCancelamento getTipoSolicitacaoCancelamento() {
        return tipoSolicitacaoCancelamento;
    }

}
