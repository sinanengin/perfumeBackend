package com.sinanengin.perfume.dataAccess.abstracts;

import com.sinanengin.perfume.entities.UserComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCommentDao extends JpaRepository<UserComment, Integer> {
    List<UserComment> getByUser_userId(int userId);
    List<UserComment> getByProduct_productId(int productId);
}
