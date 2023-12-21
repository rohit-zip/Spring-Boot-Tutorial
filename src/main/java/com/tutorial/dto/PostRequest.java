package com.tutorial.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Tutorial
 * Package - com.tutorial.dto
 * Created_on - 15 December-2023
 * Created_at - 20 : 23
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostRequest {

    @NotBlank(message = "Title cannot be Blank")
    @Size(min = 2, max = 40)
    private String title;

    @NotBlank(message = "Description cannot be Blank")
    @Size(min = 2)
    private String description;
}