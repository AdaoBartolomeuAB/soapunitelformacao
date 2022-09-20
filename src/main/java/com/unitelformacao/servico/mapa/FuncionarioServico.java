package com.unitelformacao.servico.mapa;

import co.unitel.soapwebservice_funcionario.FuncionarioGet;
import com.unitelformacao.entidade.FuncionarioEntidade;

import java.util.List;

public interface FuncionarioServico {

    void salvarFuncionario(FuncionarioEntidade funcionarioEntidade);

    void eliminarFuncionario(Long id);

    void atualizarFuncionario(FuncionarioGet funcionarioGet, FuncionarioEntidade funcionario);

    FuncionarioEntidade procurarPorId(Long id);

    List<FuncionarioEntidade> listarTodos();

    List<FuncionarioEntidade> listarPorNomeOuBilhete(String campo);
}
