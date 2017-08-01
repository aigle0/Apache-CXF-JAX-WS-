package com.pluralsight.cxfdemo.orders;

import com.pluralsight.schema.order.OrderInquiryResponseType;

public interface OrderService {

	OrderInquiryResponseType processOrder(
			int uniqueOrderId, 
			int orderQunatity,
			int accountId, 
			long ean13);
}
