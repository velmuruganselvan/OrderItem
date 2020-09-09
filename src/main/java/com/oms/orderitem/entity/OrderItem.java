package com.oms.orderitem.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "orderitem")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid")
    private int productId;
    @Column(name = "productcode")
    private String productCode;
    @Column(name = "productname")
    private String productName;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "orderid")
    private int orderid;


}
