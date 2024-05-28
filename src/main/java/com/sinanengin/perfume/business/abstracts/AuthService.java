package com.sinanengin.perfume.business.abstracts;

import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.core.utilities.results.Result;
import com.sinanengin.perfume.core.utilities.security.Token;
import com.sinanengin.perfume.entities.User;
import com.sinanengin.perfume.entities.dtos.UserForLogin;
import com.sinanengin.perfume.entities.dtos.UserForRegister;

public interface AuthService {
    DataResult<User> register(UserForRegister userForRegisterDto);
    DataResult<User> login(UserForLogin userForLoginDto);
    Result userExists(String email, String username);
    DataResult<Token> createToken(User user);
}
