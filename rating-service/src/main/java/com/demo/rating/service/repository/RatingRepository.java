package com.demo.rating.service.repository;

import com.demo.rating.service.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, String> {

    List<Rating> findAllByUserId(String userId);

    List<Rating> findAllByHotelId(String hotelId);

}
