package com.unitelformacao.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;


@EnableWs
@Configuration
public class SoapConfig {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServletServletRegistrationBean(ApplicationContext applicationContext){
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return  new ServletRegistrationBean<>(servlet,"/ws/*");
    }

    @Bean(name = "helloworld")
    public Wsdl11Definition helloWorldWsdlDefinition(XsdSchema helloWorldSchema){
        DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
        defaultWsdl11Definition.setSchema(helloWorldSchema);
        defaultWsdl11Definition.setLocationUri("/ws");
        defaultWsdl11Definition.setPortTypeName("helloWorldPort");
        defaultWsdl11Definition.setTargetNamespace("http://unitel.co/soapwebservice_hello_world");
        return defaultWsdl11Definition;
    }

    @Bean
    public XsdSchema helloWorldSchema(){
        return new SimpleXsdSchema(new ClassPathResource("hello_world.xsd"));
    }

    @Bean(name = "funcionario")
    public Wsdl11Definition funcionarioslDefinition(XsdSchema funcionarioSchema){
        DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
        defaultWsdl11Definition.setSchema(funcionarioSchema);
        defaultWsdl11Definition.setLocationUri("/ws");
        defaultWsdl11Definition.setPortTypeName("funcionarioPort");
        defaultWsdl11Definition.setTargetNamespace("http://unitel.co/soapwebservice_funcionario");
        return defaultWsdl11Definition;
    }

    @Bean
    public XsdSchema funcionarioSchema(){
        return new SimpleXsdSchema(new ClassPathResource("funcionario.xsd"));
    }

}
