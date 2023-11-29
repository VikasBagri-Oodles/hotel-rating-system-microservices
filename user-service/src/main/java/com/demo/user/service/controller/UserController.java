package com.demo.user.service.controller;

import com.demo.user.service.entity.Hotel;
import com.demo.user.service.entity.Rating;
import com.demo.user.service.entity.User;
import com.demo.user.service.external.service.HotelService;
import com.demo.user.service.external.service.RatingService;
import com.demo.user.service.service.UserService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        user = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        User user = userService.getUserById(userId);
//        Rating[] ratings = restTemplate.getForEntity("http://RATING-SERVICE/rating/user/" + user.getUserId(), Rating[].class).getBody();
        List<Rating> ratings = ratingService.getRatingByUserId(userId);
        List<Rating> listRatingWithHotel = ratings.stream()
                .map(rating -> {
//                    Hotel hotel = restTemplate.exchange("http://HOTEL-SERVICE/hotel/" + rating.getHotelId(), HttpMethod.GET, null, Hotel.class).getBody();
                    Hotel hotel = hotelService.getHotel(rating.getHotelId());
                    rating.setHotel(hotel);
                    return rating;
                }).toList();
        user.setRatings(listRatingWithHotel);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        users.forEach(user -> {
//            Rating[] ratings = restTemplate.getForObject("http://RATING-SERVICE/rating/user/" + user.getUserId(), Rating[].class);

            List<Rating> ratings = ratingService.getRatingByUserId(user.getUserId());
            List<Rating> listRatingWithHotel = ratings.stream()
                    .map(rating -> {
//                        Hotel hotel = restTemplate.exchange("http://HOTEL-SERVICE/hotel/" + rating.getHotelId(), HttpMethod.GET, null, Hotel.class).getBody();
                        Hotel hotel = hotelService.getHotel(rating.getHotelId());
                        rating.setHotel(hotel);
                        return rating;
                    }).toList();
            user.setRatings(listRatingWithHotel);
        });
        return ResponseEntity.ok(users);
    }

}
