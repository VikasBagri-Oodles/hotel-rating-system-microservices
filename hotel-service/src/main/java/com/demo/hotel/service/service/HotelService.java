package com.demo.hotel.service.service;

import com.demo.hotel.service.entity.Hotel;

import java.util.List;

public interface HotelService {

    Hotel createHotel(Hotel hotel);

    Hotel getHotel(String hotelId);

    List<Hotel> getAllHotels();

}
