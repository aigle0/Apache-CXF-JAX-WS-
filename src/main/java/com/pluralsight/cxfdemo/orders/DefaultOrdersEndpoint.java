package com.pluralsight.cxfdemo.orders;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.pluralsight.schema.order.AccountType;
import com.pluralsight.schema.order.ObjectFactory;
import com.pluralsight.schema.order.OrderInquiryResponseType;
import com.pluralsight.schema.order.OrderInquiryType;
import com.pluralsight.service.orders.Orders;

@WebService(portName = "OrdersSOAP", serviceName = "Orders",
endpointInterface = "com.pluralsight.service.orders.Orders",
targetNamespace = "http://www.pluralsight.com/service/Orders/")
public class DefaultOrdersEndpoint implements Orders {

	@Autowired
	private OrderService orderService;
	
	@Override
	public OrderInquiryResponseType processOrderPlacement(OrderInquiryType orderInquiry) {

		OrderInquiryResponseType response = orderService.processOrder(
				orderInquiry.getUniqueOrderId(),orderInquiry.getOrderQuantity(),
				orderInquiry.getAccountId(),orderInquiry.getEan13());		
		
		return response;
	}
	

}
