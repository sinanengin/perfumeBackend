package com.sinanengin.perfume.api.controllers;

import com.sinanengin.perfume.business.abstracts.UserQuestionService;
import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.entities.UserQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userQuestions")
@CrossOrigin(origins = "http://localhost:5173/")
public class UserQuestionsController {

    private final UserQuestionService userQuestionService;

    @Autowired
    public UserQuestionsController(UserQuestionService userQuestionService){
        this.userQuestionService = userQuestionService;
    }

    @GetMapping("/user/{id}")
    public DataResult<List<UserQuestion>> getUserQuestionByUserId(@PathVariable int id){
        return userQuestionService.getUserQuestionByUserId(id);
    }

    @GetMapping("/product/{id}")
    public DataResult<List<UserQuestion>>  getUserQuestionByProductId(@PathVariable int id){
        return userQuestionService.getUserQuestionByProductId(id);
    }

    @PostMapping()
    public DataResult<UserQuestion> addQuestion(@RequestBody UserQuestion userQuestion){
        return userQuestionService.addUserQuestion(userQuestion);
    }
    @DeleteMapping()
    public DataResult<UserQuestion> deleteQuestion(@RequestParam int id){
        return userQuestionService.deleteUserQuestion(id);
    }

    @PutMapping
    public DataResult<UserQuestion> updateQuestion(@RequestBody UserQuestion userQuestion){
        return userQuestionService.updateUserQuestion(userQuestion);
    }

    @GetMapping
    public DataResult<List<UserQuestion>> getAllUserQuestion() {
        return userQuestionService.getAllUserQuestion();
    }
}