package com.marketplace.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;
import java.util.List;

@Document(collection = "users")  // MongoDB collection name
public class User {

    @Id
    private String id;  // MongoDB _id field

    private String name;  // User's name
    private String email;  // User's email
    private String auth0Id;  // Authentication provider ID
    private String phone;  // User's phone number
    private String location;  // User's location
    private Instant createdAt;  // Account creation timestamp
    private String profilePicture;  // URL to profile picture
    private List<String> listings;  // IDs of user's listings
    private List<String> purchaseHistory;  // IDs of user's past purchases

    // Constructors
    public User() {
    }

    public User(String name, String email, String auth0Id, String phone, String location, 
                Instant createdAt, String profilePicture, List<String> listings, 
                List<String> purchaseHistory) {
        this.name = name;
        this.email = email;
        this.auth0Id = auth0Id;
        this.phone = phone;
        this.location = location;
        this.createdAt = createdAt;
        this.profilePicture = profilePicture;
        this.listings = listings;
        this.purchaseHistory = purchaseHistory;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuth0Id() {
        return auth0Id;
    }

    public void setAuth0Id(String auth0Id) {
        this.auth0Id = auth0Id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public List<String> getListings() {
        return listings;
    }

    public void setListings(List<String> listings) {
        this.listings = listings;
    }

    public List<String> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(List<String> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }

    // toString() for debugging
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", auth0Id='" + auth0Id + '\'' +
                ", phone='" + phone + '\'' +
                ", location='" + location + '\'' +
                ", createdAt=" + createdAt +
                ", profilePicture='" + profilePicture + '\'' +
                ", listings=" + listings +
                ", purchaseHistory=" + purchaseHistory +
                '}';
    }
}
