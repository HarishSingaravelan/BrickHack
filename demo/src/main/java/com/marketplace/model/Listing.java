package com.marketplace.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;
import java.util.List;

@Document(collection = "listings")  // MongoDB collection name
public class Listing {

    @Id
    private String id;  // MongoDB _id field

    private String title;
    private String description;
    private String category;
    private double price;
    private String sellerId;  // Refers to the user who listed the item
    private String location;
    private String condition;
    private List<String> images;  // List of image URLs
    private Instant createdAt;  // Timestamp of creation
    private String status;  // e.g., "available", "sold"

    private List<Bid> bids;  // List of bids

    // Inner class to represent a bid
    public static class Bid {
        private String userId;
        private double bidAmount;
        private Instant timestamp;

        public Bid() {
        }

        public Bid(String userId, double bidAmount, Instant timestamp) {
            this.userId = userId;
            this.bidAmount = bidAmount;
            this.timestamp = timestamp;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public double getBidAmount() {
            return bidAmount;
        }

        public void setBidAmount(double bidAmount) {
            this.bidAmount = bidAmount;
        }

        public Instant getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Instant timestamp) {
            this.timestamp = timestamp;
        }

        @Override
        public String toString() {
            return "Bid{" +
                    "userId='" + userId + '\'' +
                    ", bidAmount=" + bidAmount +
                    ", timestamp=" + timestamp +
                    '}';
        }
    }

    // Constructors
    public Listing() {
    }

    public Listing(String title, String description, String category, double price, String sellerId, 
                   String location, String condition, List<String> images, Instant createdAt, 
                   String status, List<Bid> bids) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.sellerId = sellerId;
        this.location = location;
        this.condition = condition;
        this.images = images;
        this.createdAt = createdAt;
        this.status = status;
        this.bids = bids;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

    @Override
    public String toString() {
        return "Listing{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", sellerId='" + sellerId + '\'' +
                ", location='" + location + '\'' +
                ", condition='" + condition + '\'' +
                ", images=" + images +
                ", createdAt=" + createdAt +
                ", status='" + status + '\'' +
                ", bids=" + bids +
                '}';
    }
}
