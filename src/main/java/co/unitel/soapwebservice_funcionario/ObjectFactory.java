//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.09.19 at 04:30:08 PM BST 
//


package co.unitel.soapwebservice_funcionario;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the co.unitel.soapwebservice_funcionario package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.unitel.soapwebservice_funcionario
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddFuncionarioRequest }
     * 
     */
    public AddFuncionarioRequest createAddFuncionarioRequest() {
        return new AddFuncionarioRequest();
    }

    /**
     * Create an instance of {@link Funcionario }
     * 
     */
    public Funcionario createFuncionario() {
        return new Funcionario();
    }

    /**
     * Create an instance of {@link GetFuncionarioResponse }
     * 
     */
    public GetFuncionarioResponse createGetFuncionarioResponse() {
        return new GetFuncionarioResponse();
    }

}
