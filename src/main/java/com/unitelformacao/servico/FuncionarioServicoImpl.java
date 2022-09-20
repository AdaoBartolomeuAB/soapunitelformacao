package com.unitelformacao.servico;

import co.unitel.soapwebservice_funcionario.Funcionario;
import co.unitel.soapwebservice_funcionario.FuncionarioGet;
import com.unitelformacao.entidade.FuncionarioEntidade;
import com.unitelformacao.repositorio.FuncionarioReposotorio;
import com.unitelformacao.servico.mapa.FuncionarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioServicoImpl implements FuncionarioServico {

    @Autowired
    private FuncionarioReposotorio funcionarioReposotorio;

    @Override
    public void salvarFuncionario(FuncionarioEntidade funcionarioEntidade) {
        funcionarioReposotorio.save(funcionarioEntidade);
    }

    @Override
    public void eliminarFuncionario(Long id) {
        funcionarioReposotorio.deleteById(id);
    }

    @Override
    public void atualizarFuncionario(FuncionarioGet funcionarioGet, FuncionarioEntidade funcionario) {
        funcionario.setNome(funcionarioGet.getNome());
        funcionario.setBi(funcionarioGet.getBi());
        funcionario.setEmail(funcionarioGet.getEmail());
        funcionario.setTelefone(funcionarioGet.getTelefone());
        funcionarioReposotorio.save(funcionario);
    }

    @Override
    public FuncionarioEntidade procurarPorId(Long id) {
        return funcionarioReposotorio.findById(id).orElse(null);
    }

    @Override
    public List<FuncionarioEntidade> listarTodos() {
        return funcionarioReposotorio.findAll();
    }

    @Override
    public List<FuncionarioEntidade> listarPorNomeOuBilhete(String campo) {
        return funcionarioReposotorio.findAllByNomeOrBi(campo,campo);
    }
}
