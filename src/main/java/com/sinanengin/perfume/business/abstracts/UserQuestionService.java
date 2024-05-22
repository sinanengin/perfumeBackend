package com.sinanengin.perfume.business.abstracts;

import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.entities.UserComment;
import com.sinanengin.perfume.entities.UserQuestion;

import java.util.List;

public interface UserQuestionService {

    DataResult<List<UserQuestion>> getUserQuestionByUserId(int userId);

    DataResult <List<UserQuestion>> getUserQuestionByProductId(int productId);

    DataResult<UserQuestion> addUserQuestion(UserQuestion userQuestion);
    DataResult<UserQuestion> deleteUserQuestion(int userQuestionId);
    DataResult<UserQuestion> updateUserQuestion(UserQuestion userQuestion);
}
