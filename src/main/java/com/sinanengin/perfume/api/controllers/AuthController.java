package com.sinanengin.perfume.api.controllers;

import com.sinanengin.perfume.business.abstracts.AuthService;
import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.core.utilities.results.Result;
import com.sinanengin.perfume.entities.User;
import com.sinanengin.perfume.entities.dtos.UserForLogin;
import com.sinanengin.perfume.entities.dtos.UserForRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173/")
public class AuthController {

    AuthService authService;

    @Autowired
    AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/login")
    public Result login(@RequestBody UserForLogin userForLogin){

        DataResult<User> userToLogin = authService.login(userForLogin);
        if(!userToLogin.isSuccess()){
            return userToLogin;
        }

        return authService.createToken(userToLogin.getData());
    }

    @PostMapping("/register")
    public Result register(@RequestBody UserForRegister userForRegister){
        return authService.register(userForRegister);
    }
}