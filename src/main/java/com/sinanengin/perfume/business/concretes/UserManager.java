package com.sinanengin.perfume.business.concretes;

import com.sinanengin.perfume.business.abstracts.UserService;
import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.core.utilities.results.Result;
import com.sinanengin.perfume.core.utilities.results.SuccessDataResult;
import com.sinanengin.perfume.core.utilities.results.SuccessResult;
import com.sinanengin.perfume.dataAccess.abstracts.UserDao;
import com.sinanengin.perfume.entities.Permission;
import com.sinanengin.perfume.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {
    private UserDao userDao;

    @Autowired
    UserManager(UserDao userDao){
        this.userDao = userDao;
    }
    @Override
    public DataResult<List<Permission>> getPermissions(User user) {
        return new SuccessDataResult<>(userDao.getClaims(user.getUserId()));
    }

    @Override
    public Result add(User user) {
        userDao.save(user);
        return new SuccessResult();
    }

    @Override
    public DataResult<User> getByMailOrUserName(String email, String username) {
        return new SuccessDataResult<>(userDao.getByUsernameOrEmail(email, username));
    }

    @Override
    public DataResult<User> getByMail(String email) {
        return new SuccessDataResult<>(userDao.getByEmail(email));
    }
}
