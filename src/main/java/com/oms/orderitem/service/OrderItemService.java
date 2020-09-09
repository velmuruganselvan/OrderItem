package com.oms.orderitem.service;

import com.oms.orderitem.model.OrderItemDTO;

import java.util.List;

public interface OrderItemService {

    public void saveOrderItem(OrderItemDTO orderItemDTO);

    public List<OrderItemDTO> getOrderItem(int orderid);

    public List<OrderItemDTO> retrieveAllOrderItems();

}
