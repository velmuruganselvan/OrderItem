package com.oms.orderitem.repo;

import com.oms.orderitem.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem, Integer> {

    @Query(value = "select * from orderitem where orderid = :orderid", nativeQuery = true)
    public List<OrderItem> findByProductCode(@Param("orderid") int orderid);
}
