package com.sukuawali.sukuawalibackend.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Timestamp orderedTime;
    boolean isDelivered = false;
    Timestamp deliveredTime;
    String location;
    @ManyToMany
    List<Sukua> items;
    int deliveryCharges;
    Long totalAmount;

    public Order() {
    }

    public Order(String location, List<Sukua> items, int deliveryCharges, Long totalAmount) {
        this.location = location;
        this.items = items;
        this.deliveryCharges = deliveryCharges;
        this.totalAmount = totalAmount;
    }

    public Order(Long id, Timestamp orderedTime, boolean isDelivered, Timestamp deliveredTime, String location, List<Sukua> items, int deliveryCharges, Long totalAmount) {
        this.id = id;
        this.orderedTime = orderedTime;
        this.isDelivered = isDelivered;
        this.deliveredTime = deliveredTime;
        this.location = location;
        this.items = items;
        this.deliveryCharges = deliveryCharges;
        this.totalAmount = totalAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public void setDelivered(boolean delivered) {
        isDelivered = delivered;
    }


    public Timestamp getOrderedTime() {
        return orderedTime;
    }

    public void setOrderedTime(Timestamp orderedTime) {
        this.orderedTime = orderedTime;
    }

    public Timestamp getDeliveredTime() {
        return deliveredTime;
    }

    public void setDeliveredTime(Timestamp deliveredTime) {
        this.deliveredTime = deliveredTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Sukua> getItems() {
        return items;
    }

    public void setItems(List<Sukua> items) {
        this.items = items;
    }

    public int getDeliveryCharges() {
        return deliveryCharges;
    }

    public void setDeliveryCharges(int deliveryCharges) {
        this.deliveryCharges = deliveryCharges;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }
}
