package com.sinanengin.perfume.business.concretes;

import com.sinanengin.perfume.business.abstracts.UserQuestionService;
import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.core.utilities.results.SuccessDataResult;
import com.sinanengin.perfume.dataAccess.abstracts.CustomerDao;
import com.sinanengin.perfume.dataAccess.abstracts.UserQuestionDao;
import com.sinanengin.perfume.entities.UserQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserQuestionManager implements UserQuestionService {

    UserQuestionDao userQuestionDao;

    @Autowired
    public UserQuestionManager(UserQuestionDao userQuestionDao) {
        this.userQuestionDao = userQuestionDao;
    }

    @Override
    public DataResult<List<UserQuestion>> getUserQuestionByUserId(int userId) {
        return new SuccessDataResult<>(userQuestionDao.getByUser_userId(userId));
    }

    @Override
    public DataResult<List<UserQuestion>> getUserQuestionByProductId(int productId) {
        return new SuccessDataResult<>(userQuestionDao.getByProduct_productId(productId));
    }

    @Override
    public DataResult<UserQuestion> getUserQuestionById(int id) {
        return new SuccessDataResult<>(userQuestionDao.findById(id).get());
    }

    @Override
    public DataResult<List<UserQuestion>> getAllUserQuestion() {
        return new SuccessDataResult<>(userQuestionDao.getByIsAnswered(false));
    }

    @Override
    public DataResult<UserQuestion> addUserQuestion(UserQuestion userQuestion) {
        userQuestionDao.save(userQuestion);
        return new SuccessDataResult<>(userQuestion, "Soru eklendi.");
    }

    @Override
    public DataResult<UserQuestion> deleteUserQuestion(int userQuestionId) {
        userQuestionDao.deleteById(userQuestionId);
        return new SuccessDataResult<>("Soru silindi.");
    }

    @Override
    public DataResult<UserQuestion> updateUserQuestion(UserQuestion userQuestion) {
        userQuestionDao.save(userQuestion);
        return new SuccessDataResult<>("Soru güncellendi.");
    }
}
