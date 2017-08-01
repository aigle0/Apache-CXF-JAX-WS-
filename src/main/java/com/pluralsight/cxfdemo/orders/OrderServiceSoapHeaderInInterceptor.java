package com.pluralsight.cxfdemo.orders;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.jaxb.JAXBDataBinding;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;

/**
 * Interceptor for processing requests in to the server. As part of message
 * handling, this interceptor will retrieve the API key from the SOAP header
 * using the namespace of the orders web service.
 * 
 * @author Michael Hoffman, Pluralsight
 * 
 */
public class OrderServiceSoapHeaderInInterceptor extends
      AbstractSoapInterceptor {
	
	public OrderServiceSoapHeaderInInterceptor(){
		super(Phase.USER_PROTOCOL);
	}

	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		QName qname = new QName("http//www.pluralsgiht.com/service/Orders/","apikey");
		SoapHeader header = (SoapHeader) message.getHeader(qname);
		String apikey = ((Element) header.getObject()).getTextContent();
		System.err.println("API key = " + apikey);
	}

	
	
}
