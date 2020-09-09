package com.oms.orderitem.exception;


import com.oms.orderitem.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductExceptionHandler {

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(OrderNotFoundException orderNotFoundException) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Order not found");
        errorResponse.setCode(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

}
