package com.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ecommerce.entity.Orders;
import com.ecommerce.entity.Sales;
import com.ecommerce.service.OrdersService;
import com.ecommerce.service.SalesService;
import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @PostMapping(value = "/order")
    public ResponseEntity<Integer> add(@RequestBody Orders orders){
        Orders order = ordersService.addOrder(orders);
        return new ResponseEntity<Integer>(order.getId(), HttpStatus.CREATED);
    }

    @GetMapping(value = "/order/checkSold/{productId}/{customerId}")
    public List checkIfCustomerReviewGiven(@PathVariable int productId, @PathVariable int customerId){
        var v = ordersService.checkIfCustomerPurchasedProduct(productId, customerId);
        return v;
    }

    @GetMapping(value = "/order/getPedingOrders")
    public ArrayList<Orders> getAllPendingOrders(){
        return ordersService.getPendingOrders();
    }

    @GetMapping(value = "/order/changeDeliveryStauts/{id}")
    public ResponseEntity<Boolean> changeDeiliveryStatus(@PathVariable int id){
        return new ResponseEntity<Boolean>(ordersService.setDeliverdStatus(id), HttpStatus.OK);
    }
}
