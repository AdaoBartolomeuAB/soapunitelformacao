package com.unitelformacao.endpoint;

import co.unitel.soapwebservice_funcionario.AddFuncionarioRequest;
import co.unitel.soapwebservice_funcionario.Funcionario;
import co.unitel.soapwebservice_funcionario.GetFuncionarioResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Slf4j
@Endpoint
public class FuncionarioEndpoint {

    @PayloadRoot(namespace = "http://unitel.co/soapwebservice_funcionario", localPart = "addFuncionarioRequest")
    @ResponsePayload
    public GetFuncionarioResponse addFuncionario(@RequestPayload AddFuncionarioRequest addFuncionarioRequest){

        log.info("A solicitação foi processada");

        GetFuncionarioResponse getFuncionarioResponse = new GetFuncionarioResponse();

        Funcionario funcionario = new Funcionario();

        BeanUtils.copyProperties(addFuncionarioRequest.getFuncionario(),funcionario);

        getFuncionarioResponse.setFuncionario(funcionario);
        return getFuncionarioResponse;
    }
}
