package com.sinanengin.perfume.entities.dtos;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AnswerForAddDto {
    private int userQuestionId;
    private String answerText;
}
