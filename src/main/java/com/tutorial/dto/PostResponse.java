package com.tutorial.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DatabindException;
import lombok.*;

import java.util.Date;

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
public class PostResponse {

    private Long postId;
    private String title;
    private String description;
    private Date createdOn;
    private Long userId;
}
