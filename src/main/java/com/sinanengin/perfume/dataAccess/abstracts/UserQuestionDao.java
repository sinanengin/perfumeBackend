package com.sinanengin.perfume.dataAccess.abstracts;

import com.sinanengin.perfume.entities.UserComment;
import com.sinanengin.perfume.entities.UserQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserQuestionDao extends JpaRepository<UserQuestion, Integer> {
    List<UserQuestion> getByUser_userId(int userId);
    List<UserQuestion> getByProduct_productId(int productId);
}
