package hamburgueria;

import java.util.ArrayList;

public abstract class FuncionarioHamburgueria {

    protected ArrayList<TipoSolicitacao> listaSolicitacoes = new ArrayList<>();
    private FuncionarioHamburgueria funcionarioSuperior;

    public FuncionarioHamburgueria getFuncionarioSuperior() {
        return funcionarioSuperior;
    }

    public void setFuncionarioSuperior(FuncionarioHamburgueria funcionarioSuperior) {
        this.funcionarioSuperior = funcionarioSuperior;
    }

    public abstract String getDescricaoCargo();

    public String atenderSolicitacao(Solicitacao solicitacao) {
        if (listaSolicitacoes.contains(solicitacao.getTipoSolicitacao())) {
            return getDescricaoCargo();
        } else {
            if (funcionarioSuperior != null) {
                return funcionarioSuperior.atenderSolicitacao(solicitacao);
            } else {
                return "Sem atendimento";
            }
        }
    }

}
