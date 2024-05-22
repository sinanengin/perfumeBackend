package com.sinanengin.perfume.business.concretes;

import com.sinanengin.perfume.business.abstracts.AnswerService;
import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.core.utilities.results.SuccessDataResult;
import com.sinanengin.perfume.dataAccess.abstracts.AnswerDao;
import com.sinanengin.perfume.dataAccess.abstracts.BrandDao;
import com.sinanengin.perfume.entities.Answer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AnswerManager implements AnswerService {

    AnswerDao answerDao;

    @Autowired
    public AnswerManager(AnswerDao answerDao) {
        this.answerDao = answerDao;
    }

    @Override
    public DataResult<List<Answer>> getAllAnswerByQuestionId(int questionId) {
        return new SuccessDataResult<>(answerDao.getByUserQuestion_userQuestionId(questionId));
    }

    @Override
    public DataResult<Answer> addAnswer(Answer answer) {
        answerDao.save(answer);
        return new SuccessDataResult<>(answer,"Soru cevaplandı.");
    }

    @Override
    public DataResult<Answer> deleteAnswer(int answerId) {
        answerDao.deleteById(answerId);
        return new SuccessDataResult<>("Cevap silindi.");
    }

    @Override
    public DataResult<Answer> updateAnswer(Answer answer) {
        answerDao.save(answer);
        return new SuccessDataResult<>(answer, "Cevap güncellendi.");
    }
}
