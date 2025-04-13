package com.example.UserApp.Controllers;

import com.example.UserApp.Models.PollResponse;
import com.example.UserApp.PollApp.PollAppInterFace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("PollApp")
public class PollResponseController {

    @Autowired
    PollAppInterFace pollAppInterFace;
    @GetMapping("/{QuestionId}")
    public PollResponse GetQuestionbyid(@PathVariable int QuestionId){
        return pollAppInterFace.GetQuestionsbyid(QuestionId);
    }



}
