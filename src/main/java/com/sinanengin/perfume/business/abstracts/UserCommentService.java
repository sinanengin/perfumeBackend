package com.sinanengin.perfume.business.abstracts;

import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.entities.Order;
import com.sinanengin.perfume.entities.UserComment;

import java.util.List;

public interface UserCommentService {

    DataResult<List<UserComment>> getUserCommentByUserId(int userId);

    DataResult <List<UserComment>> getUserCommentByProductId(int productId);

    DataResult<UserComment> addUserComment(UserComment userComment);
    DataResult<UserComment> deleteUserComment(int userCommentId);
    DataResult<UserComment> updateUserComment(UserComment userComment);

}
