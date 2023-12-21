package com.tutorial.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Tutorial
 * Package - com.tutorial.entity
 * Created_on - 15 December-2023
 * Created_at - 20 : 10
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String title;

    @Column(length = 5000)
    private String description;

    private Date dateCreated;

    private Date dateUpdated;

    @ManyToOne
    private User user;
}
