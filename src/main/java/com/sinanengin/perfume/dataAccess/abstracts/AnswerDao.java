package com.sinanengin.perfume.dataAccess.abstracts;

import com.sinanengin.perfume.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerDao extends JpaRepository<Answer, Integer> {
    List<Answer> getByUserQuestion_userQuestionId(int questionId);
}