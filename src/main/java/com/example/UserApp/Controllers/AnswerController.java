package com.example.UserApp.Controllers;

import com.example.UserApp.Models.AnswerRequestDTO;
import com.example.UserApp.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/answers")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PostMapping
    public String submitAnswer(@RequestBody AnswerRequestDTO dto) {
        return answerService.saveAnswer(dto);
    }

    @GetMapping("/stats/question/{questionId}/options")
    public List<Map<String, Object>> getOptionCounts(@PathVariable int questionId) {
        return answerService.getOptionCounts(questionId);
    }

    @GetMapping("/stats/question/{questionId}/users")
    public List<Map<String, Object>> TotalUserCountToQuestion(@PathVariable int questionId) {
        try {
            return answerService.TotalUserCountToQuestion(questionId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @GetMapping("/stats/question/{userid}/usersanswers")
    public List<Map<String, Object>> UserAnswerToEachQuestion(@PathVariable int userid) {
        try {
            return answerService.UserAnswerToEachQuestion(userid)
                    ;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }


    @GetMapping("/stats/question/{userid}/answerscount")
    public int TotalQuestionsThisUserAnsweredTo(@PathVariable int userid) {
        try {
            return answerService.TotalQuestionsThisUserAnsweredTo(userid);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 1;

        }

    }



    @GetMapping("/stats/questionandanswerscounts")
public List<Map<String, Object>> returnAllQuestionsWithUserOptionCounts(){

 return answerService.returnAllQuestionsWithUserOptionCounts();
    }











}














