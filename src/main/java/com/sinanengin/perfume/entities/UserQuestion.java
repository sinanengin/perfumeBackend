package com.sinanengin.perfume.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "user_question")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","answers"})
public class UserQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private int userQuestionId;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "question_text")
    private String questionText;

    @Column(name = "answered")
    private boolean answered;

    @JsonManagedReference
    @OneToMany(mappedBy = "userQuestion")
    private List<Answer> answers;

    @ManyToOne()
    @JoinColumn(name="user_id")
    private User user;

}
