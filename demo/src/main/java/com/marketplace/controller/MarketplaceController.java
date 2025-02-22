package com.marketplace.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketplace.model.Listing;
import com.marketplace.repository.ListingRepository;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/marketplace")
@Validated
public class MarketplaceController {

	@Autowired
	private ListingRepository listingRepository;

	// Add a new listing
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

	// Get a specific listing by ID
	@GetMapping("/listings/seller/{sellerId}")
	public ResponseEntity<List<Listing>> getListingsBySellerId(@PathVariable String sellerId) {
		List<Listing> listings = listingRepository.findBySellerId(sellerId);
		if (listings.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(listings, HttpStatus.OK);
	}

	// Delete a listing by ID
	@DeleteMapping("/listings/{id}")
	public ResponseEntity<String> deleteListing(@PathVariable String id) {
		try {
			listingRepository.deleteById(id);
			return new ResponseEntity<>("Listing deleted successfully.", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to delete listing.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Update a listing by ID
	@PutMapping("/listings/{id}")
	public ResponseEntity<Listing> updateListing(@PathVariable String id, @RequestBody Listing updatedListing) {
		Optional<Listing> existingListing = listingRepository.findById(id);

		if (existingListing.isPresent()) {
			Listing listing = existingListing.get();
			listing.setTitle(updatedListing.getTitle());
			listing.setDescription(updatedListing.getDescription());
			listing.setPrice(updatedListing.getPrice());
			listing.setCategory(updatedListing.getCategory());
			listing.setLocation(updatedListing.getLocation());
			listing.setCondition(updatedListing.getCondition());
			listing.setStatus(updatedListing.getStatus());
			listing.setImages(updatedListing.getImages());

			Listing savedListing = listingRepository.save(listing);
			return new ResponseEntity<>(savedListing, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
