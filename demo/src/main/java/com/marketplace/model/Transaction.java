package com.marketplace.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Document(collection = "transactions")  // MongoDB collection name
public class Transaction {

    @Id
    private String id;  // MongoDB _id field

    private String buyerId;  // ID of the buyer
    private String sellerId;  // ID of the seller
    private String listingId;  // ID of the related listing
    private double finalPrice;  // Final price of the transaction
    private String paymentStatus;  // "pending" or "completed"
    private Instant transactionDate;  // Date and time of the transaction

    // Constructors
    public Transaction() {
    }

    public Transaction(String buyerId, String sellerId, String listingId, double finalPrice, 
                       String paymentStatus, Instant transactionDate) {
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.listingId = listingId;
        this.finalPrice = finalPrice;
        this.paymentStatus = paymentStatus;
        this.transactionDate = transactionDate;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getListingId() {
        return listingId;
    }

    public void setListingId(String listingId) {
        this.listingId = listingId;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Instant getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Instant transactionDate) {
        this.transactionDate = transactionDate;
    }

    // toString() for debugging
    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", buyerId='" + buyerId + '\'' +
                ", sellerId='" + sellerId + '\'' +
                ", listingId='" + listingId + '\'' +
                ", finalPrice=" + finalPrice +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
