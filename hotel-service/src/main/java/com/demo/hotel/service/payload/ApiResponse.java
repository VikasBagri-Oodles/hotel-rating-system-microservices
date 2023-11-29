package com.demo.hotel.service.payload;

import lombok.*;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse {

    private String message;
    private Boolean success;
    private HttpStatus httpStatus;

}
