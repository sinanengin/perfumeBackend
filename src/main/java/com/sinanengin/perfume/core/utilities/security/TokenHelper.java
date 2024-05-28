package com.sinanengin.perfume.core.utilities.security;

import com.sinanengin.perfume.entities.Permission;
import com.sinanengin.perfume.entities.User;

import java.util.List;

public class TokenHelper {
    public Token createToken(User user, List<Permission> permissions){
        return new Token(user, permissions);
    }
}
