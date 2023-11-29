package com.demo.rating.service.service;

import com.demo.rating.service.entity.Rating;

import java.util.List;

public interface RatingService {

    Rating createRating(Rating rating);

    Rating getRating(String ratingId);

    List<Rating> getAllRatings();

    List<Rating> getRatingsByUserId(String userId);

    List<Rating> getRatingsByHotelId(String hotelId);

}
