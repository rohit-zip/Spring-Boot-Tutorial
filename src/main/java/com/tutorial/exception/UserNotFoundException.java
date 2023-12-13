package com.tutorial.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Tutorial
 * Package - com.tutorial.exception
 * Created_on - 13 December-2023
 * Created_at - 20 : 15
 */

@Getter
@Setter
@NoArgsConstructor
public class UserNotFoundException extends RuntimeException {

    private String field;
    private String source;
    private Object object;

    public UserNotFoundException(String field, String source, Object object) {
        super(String.format("%s not found with %s : %s", field, source, object));
        this.field = field;
        this.source = source;
        this.object = object;
    }
}
