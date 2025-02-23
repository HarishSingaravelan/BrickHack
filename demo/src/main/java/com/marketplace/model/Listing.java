package com.marketplace.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "listings")
public class Listing {
    @Id
    private String id;
    private String title;
    private String description;
    private String category;
    private double price;
    private String sellerId;
    private String location;
    private String condition;
    private Date createdAt;
    private String status;
    private byte[] image;  // Store image as binary data

    // Constructors
    public Listing() {}

    public Listing(String title, String description, String category, double price, 
                   String sellerId, String location, String condition, Date createdAt, 
                   String status, byte[] image) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.sellerId = sellerId;
        this.location = location;
        this.condition = condition;
        this.createdAt = createdAt;
        this.status = status;
        this.image = image;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getSellerId() { return sellerId; }
    public void setSellerId(String sellerId) { this.sellerId = sellerId; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public byte[] getImage() { return image; }
    public void setImage(byte[] image) { this.image = image; }
}
