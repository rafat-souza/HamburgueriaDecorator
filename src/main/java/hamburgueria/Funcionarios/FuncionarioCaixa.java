package hamburgueria.Funcionarios;

import hamburgueria.FuncionarioHamburgueria;
import hamburgueria.Solicitacoes.TipoSolicitacaoDesconto;

public class FuncionarioCaixa extends FuncionarioHamburgueria {

    public FuncionarioCaixa(FuncionarioHamburgueria superior) {
        listaSolicitacoes.add(TipoSolicitacaoDesconto.getTipoSolicitacaoDesconto());
        setFuncionarioSuperior(superior);
    }

    @Override
    public String getDescricaoCargo() {
        return "Caixa";
    }

}
