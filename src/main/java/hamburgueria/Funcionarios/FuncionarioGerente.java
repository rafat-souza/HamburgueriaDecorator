package hamburgueria.Funcionarios;

import hamburgueria.FuncionarioHamburgueria;
import hamburgueria.Solicitacoes.TipoSolicitacaoCancelamento;

public class FuncionarioGerente extends FuncionarioHamburgueria {

    public FuncionarioGerente(FuncionarioHamburgueria superior) {
        listaSolicitacoes.add(TipoSolicitacaoCancelamento.getTipoSolicitacaoCancelamento());
        setFuncionarioSuperior(superior);
    }

    @Override
    public String getDescricaoCargo() {
        return "Gerente";
    }

}
