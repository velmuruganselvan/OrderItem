package com.oms.orderitem.service.impl;


import com.oms.orderitem.entity.OrderItem;
import com.oms.orderitem.exception.OrderNotFoundException;
import com.oms.orderitem.model.OrderItemDTO;
import com.oms.orderitem.repo.OrderItemRepo;
import com.oms.orderitem.service.OrderItemService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {


    private static Logger log = LoggerFactory.getLogger(OrderItemServiceImpl.class);

    @Autowired
    OrderItemRepo orderItemRepo;

    @Autowired
    ModelMapper modelMapper;

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public void saveOrderItem(OrderItemDTO orderItemDTO) {
        try {
            OrderItem orderItem = modelMapper.map(orderItemDTO, OrderItem.class);
            log.info("Product Item -->{}",orderItem.toString());
            entityManager.persist(orderItem);
            log.info("Product Item Saved Successfully");
        } catch (Exception e) {
            log.error("Unable to Save the Product Details.. {}", e.getMessage());
            throw new OrderNotFoundException();
        }

    }

    @Override
    public List<OrderItemDTO> getOrderItem(int orderid) {
        List<OrderItemDTO> orderItemDTOS = null;
        try {
            List<OrderItem> orderItems = orderItemRepo.findByProductCode(orderid);
            if (orderItems!=null && orderItems.size()>0) {
                orderItemDTOS = new ArrayList<>();
                for(OrderItem orderItem : orderItems) {
                    OrderItemDTO orderItemDTO = modelMapper.map(orderItem, OrderItemDTO.class);
                    orderItemDTOS.add(orderItemDTO);
                }
            } else {
                throw new OrderNotFoundException();
            }
        } catch (Exception e) {
            log.error("Unable to retrieve the product details.. {}",e.getMessage());
            throw new OrderNotFoundException();
        }

        return orderItemDTOS;
    }

    @Override
    public List<OrderItemDTO> retrieveAllOrderItems() {
        List<OrderItemDTO> orderItemDTOS =null;
        try {
            List<OrderItem> orderItems = orderItemRepo.findAll();
            if (orderItems!=null && orderItems.size()>0) {
                orderItemDTOS = new ArrayList<>();
                for(OrderItem orderItem : orderItems) {
                    OrderItemDTO orderItemDTO = modelMapper.map(orderItem, OrderItemDTO.class);
                    orderItemDTOS.add(orderItemDTO);
                }
            } else {
                throw new OrderNotFoundException();
            }
        } catch (Exception e) {
            log.error("Unable to retrieve the Product Items... {}", e.getMessage());
            throw new OrderNotFoundException();
        }

        return orderItemDTOS;
    }
}
