package com.unitelformacao.repositorio;

import com.unitelformacao.entidade.FuncionarioEntidade;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface FuncionarioReposotorio extends CrudRepository<FuncionarioEntidade,Long> {

    List<FuncionarioEntidade> findAll();

    List<FuncionarioEntidade> findAllByNomeOrBi(String nome,String bi);
}
