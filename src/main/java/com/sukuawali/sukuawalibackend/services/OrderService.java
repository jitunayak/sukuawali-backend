package com.sukuawali.sukuawalibackend.services;

import com.sukuawali.sukuawalibackend.models.Order;
import com.sukuawali.sukuawalibackend.repositories.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

@Slf4j
@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Order AddeOrder(Order order) {
        order.setOrderedTime(new Timestamp(new Date().getTime()));
        return orderRepository.save(order);
    }

    public Boolean OrderDelivered(Long id) {
        try {
            Order order = orderRepository.findById(id).get();
            order.setDelivered(true);
            order.setDeliveredTime(new Timestamp(new Date().getTime()));
            orderRepository.save(order);
            return true;
        } catch (Exception e) {
            log.debug(e.getMessage());
        }
        return false;
    }

}
