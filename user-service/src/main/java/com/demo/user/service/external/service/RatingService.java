package com.demo.user.service.external.service;

import com.demo.user.service.entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("RATING-SERVICE")
public interface RatingService {

    @GetMapping("/rating/user/{userId}")
    List<Rating> getRatingByUserId(@PathVariable String userId);

}
