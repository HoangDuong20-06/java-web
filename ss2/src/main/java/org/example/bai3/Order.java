package org.example.bai3;

import java.util.Date;

public class Order {
    private String id;
    private String productName;
    private Double amount;
    private Date orderDate;

    public Order() {
    }

    public Order(String id, String productName, Double amount, Date orderDate) {
        this.id = id;
        this.productName = productName;
        this.amount = amount;
        this.orderDate = orderDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
