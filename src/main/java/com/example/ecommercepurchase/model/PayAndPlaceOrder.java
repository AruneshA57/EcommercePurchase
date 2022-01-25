package com.example.ecommercepurchase.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;

@Entity
public class PayAndPlaceOrder {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long transactionId;
    private String date;
    private Long orderId;
    private Long userId;
    private Long amount;
    private String Status;

    public PayAndPlaceOrder(Long orderId, Long userId, Long amount) {
        this.orderId = orderId;
        this.userId = userId;
        this.amount = amount;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public PayAndPlaceOrder() {

    }


    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PayAndPlaceOrder{" +
                "transactionId=" + transactionId +
                ", date=" + date +
                ", orderId=" + orderId +
                ", userId=" + userId +
                ", amount=" + amount +
                ", Status='" + Status + '\'' +
                '}';
    }
}
