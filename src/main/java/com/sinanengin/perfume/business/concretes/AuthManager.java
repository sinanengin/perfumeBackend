package com.sinanengin.perfume.business.concretes;

import com.sinanengin.perfume.business.abstracts.AuthService;
import com.sinanengin.perfume.business.abstracts.UserService;
import com.sinanengin.perfume.core.utilities.results.*;
import com.sinanengin.perfume.core.utilities.security.Token;
import com.sinanengin.perfume.core.utilities.security.TokenHelper;
import com.sinanengin.perfume.entities.User;
import com.sinanengin.perfume.entities.dtos.UserForLogin;
import com.sinanengin.perfume.entities.dtos.UserForRegister;
import org.springframework.stereotype.Service;

@Service
public class AuthManager implements AuthService {
    private final UserService userService;
    private final TokenHelper tokenHelper;

    AuthManager(UserService userService){
        this.userService = userService;
        this.tokenHelper = new TokenHelper();
    }

    @Override
    public DataResult<User> register(UserForRegister userForRegister) {
        if(userExists(userForRegister.getEmail(),userForRegister.getUsername()).isSuccess()){
            User user = new User();
            user.setUsername(userForRegister.getUsername());
            user.setEmail(userForRegister.getEmail());
            user.setPassword(userForRegister.getPassword());
            userService.add(user);
            return new SuccessDataResult<>(user);
        }
        return new ErrorDataResult<>();
    }

    @Override
    public DataResult<User> login(UserForLogin userForLogin) {
        User userToCheck = userService.getByMail(userForLogin.getEmail()).getData();
        if(userToCheck == null){
            return new ErrorDataResult<>("Password or email is wrong");
        }
        if(!userToCheck.getPassword().equals(userForLogin.getPassword())){
            return new ErrorDataResult<>("Password or email is wrong");
        }

        return new SuccessDataResult<>(userToCheck);
    }

    @Override
    public Result userExists(String email, String username) {
        if(userService.getByMailOrUserName(email, username).getData() != null){
            return new ErrorResult("User already exist");
        }

        return new SuccessResult();
    }

    @Override
    public DataResult<Token> createToken(User user) {
        Token token = tokenHelper.createToken(user, userService.getPermissions(user).getData());
        return new SuccessDataResult<>(token);
    }
}
