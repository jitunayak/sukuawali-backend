package com.sukuawali.sukuawalibackend.controller;

import com.sukuawali.sukuawalibackend.models.Order;
import com.sukuawali.sukuawalibackend.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping(path = "/add")
    public ResponseEntity<Order> PlaceOrder(@RequestBody Order order) {
        return new ResponseEntity(orderService.AddeOrder(order), HttpStatus.ACCEPTED);
    }

    @PutMapping (path = "/delivered/")
    public ResponseEntity<Order> OrderDelivered(@RequestParam Long id) {
        return new ResponseEntity(orderService.OrderDelivered(id), HttpStatus.ACCEPTED);
    }
}
