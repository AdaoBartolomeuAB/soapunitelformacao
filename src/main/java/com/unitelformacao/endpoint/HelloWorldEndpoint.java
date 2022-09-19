package com.unitelformacao.endpoint;

import co.unitel.soapwebservice_hello_world.GetHelloWorldResponse;
import co.unitel.soapwebservice_hello_world.GetNameRequest;
import co.unitel.soapwebservice_hello_world.GetNameResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class HelloWorldEndpoint {


    @PayloadRoot(namespace = "http://unitel.co/soapwebservice_hello_world", localPart = "getHelloWorldRequest")
    @ResponsePayload
    public GetHelloWorldResponse getHelloWorldRequest(){
        GetHelloWorldResponse getHelloWorldResponse = new GetHelloWorldResponse();
        getHelloWorldResponse.setMensagem("Hello World");
        return getHelloWorldResponse;
    }

    @PayloadRoot(namespace = "http://unitel.co/soapwebservice_hello_world", localPart = "getNameRequest")
    @ResponsePayload
    public GetNameResponse getNameRequest(@RequestPayload GetNameRequest getNameRequest){
        GetNameResponse getHelloWorldResponse = new GetNameResponse();
        getHelloWorldResponse.setMensagem("Hello and Welcome " +getNameRequest.getNome());
        return getHelloWorldResponse;
    }
}
