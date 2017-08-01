package com.pluralsight.cxfdemo.orders;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.binding.soap.interceptor.SoapOutInterceptor;
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
public class OrderServiceSoapHeaderOutInterceptor extends
      AbstractSoapInterceptor {
	
	public OrderServiceSoapHeaderOutInterceptor(){
		super(Phase.WRITE);
		this.addBefore(SoapOutInterceptor.class.getName());
		
	}

	@Override
	public void handleMessage(SoapMessage message) throws Fault {

		QName qname = new QName("http//www.pluralsgiht.com/service/Orders/","apikey");
		String apikey ="a1b2c3d4e5";
		try{
			SoapHeader header = new SoapHeader(qname, apikey, new JAXBDataBinding(apikey.getClass()));
			message.getHeaders().add(header);
		}catch (Exception e){
			throw new Fault(e);
		}
	}
	
}
