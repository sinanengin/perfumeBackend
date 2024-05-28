package com.sinanengin.perfume.api.controllers;

import com.sinanengin.perfume.business.abstracts.UserCommentService;
import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.entities.UserComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userComments")
@CrossOrigin(origins = "http://localhost:5173/")
public class UserCommentsController {

    private final UserCommentService userCommentService;

    @Autowired
    public UserCommentsController(UserCommentService userCommentService){
        this.userCommentService = userCommentService;
    }

    @GetMapping("/user/{id}")
    public DataResult<List<UserComment>> getUserCommentByUserId(@PathVariable int id){
        return userCommentService.getUserCommentByUserId(id);
    }

    @GetMapping("/product/{id}")
    public DataResult<List<UserComment>>  getUserCommentByProductId(@PathVariable int id){
        return userCommentService.getUserCommentByProductId(id);
    }

    @PostMapping()
    public DataResult<UserComment> addComment(@RequestBody UserComment userComment){
        return userCommentService.addUserComment(userComment);
    }
    @DeleteMapping()
    public DataResult<UserComment> deleteComment(@RequestParam int id){
        return userCommentService.deleteUserComment(id);
    }

    @PutMapping
    public DataResult<UserComment> updateComment(@RequestBody UserComment userComment){
        return userCommentService.updateUserComment(userComment);
    }
}
