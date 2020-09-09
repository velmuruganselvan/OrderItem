package com.oms.orderitem.repo;

import com.oms.orderitem.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem, String> {

    @Query(value = "select * from orderitem where productcode = :productcode", nativeQuery = true)
    public OrderItem findByProductCode(@Param("productcode") String productcode);
}
