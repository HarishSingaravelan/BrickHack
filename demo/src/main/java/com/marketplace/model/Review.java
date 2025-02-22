package com.marketplace.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Document(collection = "reviews")  // MongoDB collection name
public class Review {

    @Id
    private String id;  // MongoDB _id field

    private String reviewerId;  // ID of the user giving the review
    private String revieweeId;  // ID of the user being reviewed
    private double rating;  // Rating given by the reviewer
    private String reviewText;  // Review description
    private Instant timestamp;  // Timestamp of the review

    // Constructors
    public Review() {
    }

    public Review(String reviewerId, String revieweeId, double rating, String reviewText, Instant timestamp) {
        this.reviewerId = reviewerId;
        this.revieweeId = revieweeId;
        this.rating = rating;
        this.reviewText = reviewText;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(String reviewerId) {
        this.reviewerId = reviewerId;
    }

    public String getRevieweeId() {
        return revieweeId;
    }

    public void setRevieweeId(String revieweeId) {
        this.revieweeId = revieweeId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
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
        return "Review{" +
                "id='" + id + '\'' +
                ", reviewerId='" + reviewerId + '\'' +
                ", revieweeId='" + revieweeId + '\'' +
                ", rating=" + rating +
                ", reviewText='" + reviewText + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
