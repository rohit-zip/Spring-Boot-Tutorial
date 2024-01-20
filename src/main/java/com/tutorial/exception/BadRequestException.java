package com.tutorial.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Tutorial
 * Package - com.tutorial.exception
 * Created_on - 13 December-2023
 * Created_at - 20 : 14
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BadRequestException extends RuntimeException {
    private String message;
}
