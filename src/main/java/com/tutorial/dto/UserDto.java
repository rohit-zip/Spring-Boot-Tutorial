package com.tutorial.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.repository.query.parser.Part;

import javax.validation.constraints.*;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Tutorial
 * Package - com.tutorial.dto
 * Created_on - 06 December-2023
 * Created_at - 20 : 30
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserDto {

    @NotBlank(message = "Name should not be empty")
    @Size(min = 2, max = 20, message = "Name should be greater than 2 characters and less than 20 characters")
    private String name;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be in correct format")
    private String email;

    @NotBlank
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Password should be correct format")
    private String password;

//    @Min(value = 18, message = "Age must be greater than 18")
//    @Max(25)
//    private Integer age;
}
