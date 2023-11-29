package com.demo.user.service.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating {

    private String ratingId;
    private String hotelId;
    private String userId;
    private int rating;
    private String feedback;
    private Hotel hotel;

}
