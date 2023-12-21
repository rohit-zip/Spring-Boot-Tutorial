package com.tutorial.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Tutorial
 * Package - com.tutorial.entity
 * Created_on - 21 December-2023
 * Created_at - 20 : 06
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    private String comment;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCommented;

    @ManyToOne
    private User user;

    @ManyToOne
    private Post post;
}
