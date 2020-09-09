package com.oms.orderitem.controller;


import com.oms.orderitem.common.OrderItemConstants;
import com.oms.orderitem.exception.OrderNotFoundException;
import com.oms.orderitem.model.OrderItemDTO;
import com.oms.orderitem.service.OrderItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(OrderItemConstants.ORDER_ITEM_SERVICE_API)
public class OrderItemController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    OrderItemService orderItemService;

    @PostMapping
    public ResponseEntity<String> handleOrderItem(@Valid @RequestBody OrderItemDTO orderItemDTO) {
        try {
            orderItemService.saveOrderItem(orderItemDTO);
            ResponseEntity.ok("Product Saved Successfully");
        } catch (Exception e) {
            log.error("Unable to Save the prodcut items {}",e.getMessage());
        }
        return null;
    }

    @GetMapping("{id}")
    public  List<OrderItemDTO> getOrderItem(@PathVariable("id") int orderid) {
        List<OrderItemDTO> orderItemDTOS = null;
        try {
            orderItemDTOS = orderItemService.getOrderItem(orderid);
        } catch (Exception e) {
            log.error("Unable to retrieve the product items.. {}",e.getMessage());
            throw new OrderNotFoundException();
        }
        return orderItemDTOS;
    }

    @GetMapping("/")
    public List<OrderItemDTO> retrieveAllOrderItems() {
        List<OrderItemDTO> orderItemDTOS = null;
        try {
            orderItemDTOS = orderItemService.retrieveAllOrderItems();
        } catch (Exception e) {
            log.error("Unable to retrieve the order items... {}", e.getMessage());
            throw new OrderNotFoundException();
        }
        return orderItemDTOS;
    }

}
