//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.09.20 at 04:12:01 PM WAT 
//


package co.unitel.soapwebservice_hello_world;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the co.unitel.soapwebservice_hello_world package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.unitel.soapwebservice_hello_world
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetHelloWorldResponse }
     * 
     */
    public GetHelloWorldResponse createGetHelloWorldResponse() {
        return new GetHelloWorldResponse();
    }

    /**
     * Create an instance of {@link GetHelloWorldRequest }
     * 
     */
    public GetHelloWorldRequest createGetHelloWorldRequest() {
        return new GetHelloWorldRequest();
    }

    /**
     * Create an instance of {@link GetNameResponse }
     * 
     */
    public GetNameResponse createGetNameResponse() {
        return new GetNameResponse();
    }

    /**
     * Create an instance of {@link GetNameRequest }
     * 
     */
    public GetNameRequest createGetNameRequest() {
        return new GetNameRequest();
    }

}
