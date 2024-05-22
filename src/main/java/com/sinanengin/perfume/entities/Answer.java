package com.sinanengin.perfume.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "question_answer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_answer_id")
    private int answerId;

    @Column(name = "answer_text")
    private String answerText;

    //@JsonBackReference
    @ManyToOne()
    @JoinColumn(name="question_id")
    private UserQuestion userQuestion;
}
