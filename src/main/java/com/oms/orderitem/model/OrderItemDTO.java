package com.oms.orderitem.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

import static com.oms.orderitem.common.OrderItemConstants.*;

@Data
public class OrderItemDTO {


    private int productid;
    @NotNull
    @Size(min = 1, max = 50, message = PRD_CODE_ERROR_MSG)
    private String productcode;
    @NotNull
    @Size(min = 1, max = 100, message = PRD_NAME_ERROR_MSG)
    private String productname;
    @NotNull
    @Positive
    private int quantity;
    private int orderId;

    public OrderItemDTO() {

    }


    @Override
    public String toString() {
        return "OrderItemDTO{" +
                "productid=" + productid +
                ", productcode='" + productcode + '\'' +
                ", productname='" + productname + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
