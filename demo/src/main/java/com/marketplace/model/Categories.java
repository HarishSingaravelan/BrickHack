package com.marketplace.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categories")  // Specify the MongoDB collection name
public class Categories {

    @Id
    private String id;  // MongoDB _id field

    private String categoryName;  // category_name field

    // Constructors
    public Categories() {
    }

    public Categories(String categoryName) {
        this.categoryName = categoryName;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    // toString() for debugging
    @Override
    public String toString() {
        return "Categories{" +
                "id='" + id + '\'' +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
