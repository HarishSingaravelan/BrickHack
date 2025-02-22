package com.marketplace.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Document(collection = "messages")  // MongoDB collection name
public class Message {

    @Id
    private String id;  // MongoDB _id field

    private String senderId;  // ID of the sender
    private String receiverId;  // ID of the receiver
    private String listingId;  // ID of the related listing
    private String message;  // Message content
    private Instant timestamp;  // Timestamp of when the message was sent

    // Constructors
    public Message() {
    }

    public Message(String senderId, String receiverId, String listingId, String message, Instant timestamp) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.listingId = listingId;
        this.message = message;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getListingId() {
        return listingId;
    }

    public void setListingId(String listingId) {
        this.listingId = listingId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    // toString() for debugging
    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", senderId='" + senderId + '\'' +
                ", receiverId='" + receiverId + '\'' +
                ", listingId='" + listingId + '\'' +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
