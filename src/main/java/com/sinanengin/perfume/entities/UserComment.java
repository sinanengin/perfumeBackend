package com.sinanengin.perfume.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Entity
@Table(name = "user_comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private int userCommentId;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "comment_text")
    private String commentText;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "comment_date")
    private Date date;

    @ManyToOne()
    @JoinColumn(name="user_id")
    private User user;
}
