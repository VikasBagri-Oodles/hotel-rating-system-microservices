package com.demo.rating.service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "micro_rating")
public class Rating {

    @Id
    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;

}
