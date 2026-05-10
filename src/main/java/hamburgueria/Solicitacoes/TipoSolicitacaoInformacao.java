package hamburgueria.Solicitacoes;

import hamburgueria.TipoSolicitacao;

public class TipoSolicitacaoInformacao implements TipoSolicitacao {

    private static TipoSolicitacaoInformacao tipoSolicitacaoInformacao =
            new TipoSolicitacaoInformacao();

    private TipoSolicitacaoInformacao() {}

    public static TipoSolicitacaoInformacao getTipoSolicitacaoInformacao() {
        return tipoSolicitacaoInformacao;
    }

}
