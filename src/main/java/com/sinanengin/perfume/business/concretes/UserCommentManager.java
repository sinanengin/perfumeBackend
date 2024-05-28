package com.sinanengin.perfume.business.concretes;

import com.sinanengin.perfume.business.abstracts.UserCommentService;
import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.core.utilities.results.SuccessDataResult;
import com.sinanengin.perfume.dataAccess.abstracts.CustomerDao;
import com.sinanengin.perfume.dataAccess.abstracts.UserCommentDao;
import com.sinanengin.perfume.entities.UserComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserCommentManager implements UserCommentService {

    UserCommentDao userCommentDao;

    @Autowired
    public UserCommentManager(UserCommentDao userCommentDao) {
        this.userCommentDao = userCommentDao;
    }

    @Override
    public DataResult<List<UserComment>> getUserCommentByUserId(int userId) {
        return new SuccessDataResult<>(userCommentDao.getByUser_userId(userId));
    }

    @Override
    public DataResult<List<UserComment>> getUserCommentByProductId(int productId) {
        return new SuccessDataResult<>(userCommentDao.getByProduct_productId(productId));
    }

    @Override
    public DataResult<UserComment> addUserComment(UserComment userComment) {
        userCommentDao.save(userComment);
        return new SuccessDataResult<>(userComment, "Yorum eklendi.");
    }

    @Override
    public DataResult<UserComment> deleteUserComment(int userCommentId) {
        userCommentDao.deleteById(userCommentId);
        return new SuccessDataResult<>("Yorum silindi.");
    }

    @Override
    public DataResult<UserComment> updateUserComment(UserComment userComment) {
        userCommentDao.save(userComment);
        return new SuccessDataResult<>(userComment, "Yorum güncellendi.");
    }
}
