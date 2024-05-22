package com.sinanengin.perfume.business.abstracts;

import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.entities.Answer;
import com.sinanengin.perfume.entities.Brand;

import java.util.List;

public interface AnswerService {

    DataResult<List<Answer>> getAllAnswerByQuestionId(int questionId);

    DataResult<Answer> addAnswer(Answer answer);
    DataResult<Answer> deleteAnswer(int answerId);
    DataResult<Answer> updateAnswer(Answer answer);
}
