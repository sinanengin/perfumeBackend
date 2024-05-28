package com.sinanengin.perfume.api.controllers;

import com.sinanengin.perfume.business.abstracts.AnswerService;
import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.entities.Answer;
import com.sinanengin.perfume.entities.UserQuestion;
import com.sinanengin.perfume.entities.dtos.AnswerForAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answer")
@CrossOrigin(origins = "http://localhost:5173/")
public class AnswersController {

    AnswerService answerService;

    @Autowired
    AnswersController(AnswerService answerService) {this.answerService = answerService;}

    @GetMapping("/{id}")
    public DataResult<List<Answer>> getAllByQuestionId(@PathVariable int id){
        return answerService.getAllAnswerByQuestionId(id);
    }

    @PostMapping
    public DataResult<Answer> addAnswer(@RequestBody AnswerForAddDto answerForAdd){
        Answer answer = new Answer();
        UserQuestion userQuestion = new UserQuestion();
        userQuestion.setUserQuestionId(answerForAdd.getUserQuestionId());
        answer.setAnswerText(answerForAdd.getAnswerText());
        answer.setUserQuestion(userQuestion);
        return answerService.addAnswer(answer);
    }

    @DeleteMapping
    public DataResult<Answer> deleteAnswer(@RequestParam int id){
        return answerService.deleteAnswer(id);
    }

    @PutMapping
    public DataResult<Answer> updateAnswer(@RequestBody Answer answer){
        return answerService.updateAnswer(answer);
    }

}
