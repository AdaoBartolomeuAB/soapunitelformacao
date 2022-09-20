package com.unitelformacao.endpoint;

import co.unitel.soapwebservice_funcionario.*;
import com.unitelformacao.entidade.FuncionarioEntidade;
import com.unitelformacao.servico.mapa.FuncionarioServico;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Endpoint
public class FuncionarioEndpoint {

    @Autowired
    private FuncionarioServico funcionarioServico;

    @PayloadRoot(namespace = "http://unitel.co/soapwebservice_funcionario", localPart = "addFuncionarioRequest")
    @ResponsePayload
    public SucessoResponse addFuncionario(@RequestPayload AddFuncionarioRequest addFuncionarioRequest){

        log.info("A solicitação foi processada");

        SucessoResponse sucessoResponse = new SucessoResponse();

        FuncionarioEntidade funcionarioEntidade = new FuncionarioEntidade();

        BeanUtils.copyProperties(addFuncionarioRequest.getFuncionario(),funcionarioEntidade);

        funcionarioServico.salvarFuncionario(funcionarioEntidade);

        sucessoResponse.setMensagem("Funcionario salvo com sucesso");
        return sucessoResponse;
    }

    @PayloadRoot(namespace = "http://unitel.co/soapwebservice_funcionario", localPart = "getFuncionariosRequest")
    @ResponsePayload
    public GetFuncionariosResponse listarTodosFuncionarios(){

        List<FuncionarioEntidade> funcionarioEntidades = funcionarioServico.listarTodos();

        List<FuncionarioGet> funcionarios = new ArrayList<>();

        for (FuncionarioEntidade funcionarioEntidade : funcionarioEntidades){

            FuncionarioGet funcionarioGet = new FuncionarioGet();

            BeanUtils.copyProperties(funcionarioEntidade,funcionarioGet);

            funcionarios.add(funcionarioGet);
        }

        GetFuncionariosResponse getFuncionariosResponse = new GetFuncionariosResponse();

        getFuncionariosResponse.getFuncionario().addAll(funcionarios);
        return getFuncionariosResponse;
    }

    @PayloadRoot(namespace = "http://unitel.co/soapwebservice_funcionario", localPart = "findFuncionarioRequest")
    @ResponsePayload
    public GetFuncionariosResponse procurarPorNomeOuBilhete(@RequestPayload FindFuncionarioRequest findFuncionarioRequest){

        List<FuncionarioEntidade> funcionarioEntidades = funcionarioServico.listarPorNomeOuBilhete(findFuncionarioRequest.getCampo());

        List<FuncionarioGet> funcionarios = new ArrayList<>();

        for (FuncionarioEntidade funcionarioEntidade : funcionarioEntidades){

            FuncionarioGet funcionarioGet = new FuncionarioGet();

            BeanUtils.copyProperties(funcionarioEntidade,funcionarioGet);

            funcionarios.add(funcionarioGet);
        }

        GetFuncionariosResponse getFuncionariosResponse = new GetFuncionariosResponse();

        getFuncionariosResponse.getFuncionario().addAll(funcionarios);
        return getFuncionariosResponse;
    }

    @PayloadRoot(namespace = "http://unitel.co/soapwebservice_funcionario", localPart = "eliminarFuncionarioRequest")
    @ResponsePayload
    public MensagemResponse eliminarFuncionario(@RequestPayload EliminarFuncionarioRequest eliminarFuncionarioRequest){

        FuncionarioEntidade funcionarioEntidade = funcionarioServico.procurarPorId(eliminarFuncionarioRequest.getId());

        MensagemResponse mensagemResponse = new MensagemResponse();

        if (funcionarioEntidade==null){
            mensagemResponse.setMensagem("Funcionario não existe, erro ao eliminar");
            return mensagemResponse;
        }

        funcionarioServico.eliminarFuncionario(funcionarioEntidade.getId());
        mensagemResponse.setMensagem("Funcionario eliminado com sucesso!");
        return mensagemResponse;
    }

    @PayloadRoot(namespace = "http://unitel.co/soapwebservice_funcionario", localPart = "updateFuncionarioRequest")
    @ResponsePayload
    public MensagemResponse atualizarFuncionario(@RequestPayload UpdateFuncionarioRequest updateFuncionarioRequest){

        FuncionarioEntidade funcionarioEntidade = funcionarioServico.procurarPorId(updateFuncionarioRequest.getFuncionario().getId());

        MensagemResponse mensagemResponse = new MensagemResponse();

        if (funcionarioEntidade==null){
            mensagemResponse.setMensagem("Funcionario não existe, erro ao atualizar");
            return mensagemResponse;
        }

        funcionarioServico.atualizarFuncionario(updateFuncionarioRequest.getFuncionario(),funcionarioEntidade);
        mensagemResponse.setMensagem("Funcionario atualizado com sucesso!");
        return mensagemResponse;
    }
}
