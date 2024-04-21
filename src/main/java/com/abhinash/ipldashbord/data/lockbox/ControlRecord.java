package com.abhinash.ipldashbord.data.lockbox;

import java.time.LocalDateTime;

public class ControlRecord implements DataEntity{
    private String orderId;
    private LocalDateTime orderDate;

    @Override
    public DataEntity map(String line) {
        return null;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "ControlRecord{" +
                "orderId='" + orderId + '\'' +
                ", orderDate=" + orderDate +
                '}';
    }
}
