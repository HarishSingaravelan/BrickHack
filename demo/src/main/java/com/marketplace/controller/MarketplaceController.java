package com.marketplace.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketplace.model.Listing;
import com.marketplace.repository.ListingRepository;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/marketplace")
public class MarketplaceController {

    @Autowired
    private ListingRepository listingRepository;

    // Add a new listing with image upload
   @PostMapping("/add")
	public ResponseEntity<Listing> addListing(@RequestBody Listing listing) {
		try {
			Listing savedListing = listingRepository.save(listing);
			return new ResponseEntity<>(savedListing, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	// Get all listings
	@GetMapping("/listings")
	public ResponseEntity<List<Listing>> getAllListings() {
		List<Listing> listings = listingRepository.findAll();
		return new ResponseEntity<>(listings, HttpStatus.OK);
	}

    // Get all listings by seller ID
    @GetMapping("/seller/{sellerId}")
    public ResponseEntity<List<Listing>> getListingsBySeller(@PathVariable String sellerId) {
        List<Listing> listings = listingRepository.findBySellerId(sellerId);
        return listings.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND) 
                                  : new ResponseEntity<>(listings, HttpStatus.OK);
    }

    // Fetch and display product details based on Listing ID
    @GetMapping("/listings/{id}")
    public ResponseEntity<Listing> getListingById(@PathVariable String id) {
        Optional<Listing> listing = listingRepository.findById(id);
        return listing.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get image by listing ID
    @GetMapping("/listings/{id}/image")
    public ResponseEntity<byte[]> getListingImage(@PathVariable String id) {
        Optional<Listing> listing = listingRepository.findById(id);
        return listing.map(value -> ResponseEntity.ok().body(value.getImage()))
                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
