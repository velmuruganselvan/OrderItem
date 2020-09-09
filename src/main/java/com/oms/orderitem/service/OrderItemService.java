package com.oms.orderitem.service;

import com.oms.orderitem.model.OrderItemDTO;

import java.util.List;

public interface OrderItemService {

    public void saveOrderItem(OrderItemDTO orderItemDTO);

    public OrderItemDTO getOrderItemByProductCode(String productCode);

    public List<OrderItemDTO> retrieveAllOrderItems();

}
