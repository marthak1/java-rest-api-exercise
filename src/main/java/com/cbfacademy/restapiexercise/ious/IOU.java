package com.cbfacademy.restapiexercise.ious;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Implementing the Data Model

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "ious")

public class IOU {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private final UUID id; // unique identifier for the IOU

    @Column(name = "borrower")
    private String borrower; // name of borrower

    @Column(name = "lender")
    private String lender; // name of lender

    @Column(name = "amount")
    private BigDecimal amount; // amount covered by IOU

    @Column(name = "dateTime")
    private Instant dateTime; // date and time of IOU being issued

    // Constructor that generates a new random UUID
    public IOU(String borrower, String lender, BigDecimal amount, Instant datetime) {
        this.id = UUID.randomUUID();
        this.borrower = borrower;
        this.lender = lender;
        this.amount = amount;
        this.dateTime = datetime;
    }

    /*
     * Getters and setters for all members
     * Set the appropriate accessibility modifiers for
     * all members and add appropriate property getters and setters.
     */

    public UUID getId() {
        return id;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getLender() {
        return lender;
    }

    public void setLender(String lender) {
        this.lender = lender;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Instant getDateTime() {
        return dateTime;
    }

    public void setDateTime(Instant dateTime) {
        this.dateTime = dateTime;
    }

}
