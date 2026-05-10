package hamburgueria.Funcionarios;

import hamburgueria.FuncionarioHamburgueria;
import hamburgueria.Solicitacoes.TipoSolicitacaoInformacao;

public class FuncionarioAtendente extends FuncionarioHamburgueria {

    public FuncionarioAtendente(FuncionarioHamburgueria superior) {
        listaSolicitacoes.add(TipoSolicitacaoInformacao.getTipoSolicitacaoInformacao());
        setFuncionarioSuperior(superior);
    }

    @Override
    public String getDescricaoCargo() {
        return "Atendente";
    }

}
