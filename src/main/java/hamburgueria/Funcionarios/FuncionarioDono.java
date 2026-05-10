package hamburgueria.Funcionarios;

import hamburgueria.FuncionarioHamburgueria;
import hamburgueria.Solicitacoes.TipoSolicitacaoReembolso;

public class FuncionarioDono extends FuncionarioHamburgueria {

    public FuncionarioDono() {
        listaSolicitacoes.add(TipoSolicitacaoReembolso.getTipoSolicitacaoReembolso());
        setFuncionarioSuperior(null);
    }

    @Override
    public String getDescricaoCargo() {
        return "Dono";
    }

}
