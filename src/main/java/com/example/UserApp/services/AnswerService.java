package com.example.UserApp.services;

import com.example.UserApp.Models.AnswerRequestDTO;
import com.example.UserApp.Models.PollResponse;
import com.example.UserApp.Repository.UserAndAnswerRepository;
import com.example.UserApp.Repository.UserRepository;
import com.example.UserApp.PollApp.PollAppInterFace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AnswerService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PollAppInterFace pollAppInterFace;

    @Autowired
    private UserAndAnswerRepository userAndAnswerRepository;

    public String saveAnswer(AnswerRequestDTO DTO) {
        var user = userRepository.getById(DTO.getUserId());
        if (user.isEmpty()) {
            return "User not found.";
        }

        PollResponse question = pollAppInterFace.GetQuestionsbyid(DTO.getQuestionId());
        if (question == null) {
            return "Question not found.";
        }

        String selected = DTO.getSelectedOption().trim();
        boolean isValid = selected.equalsIgnoreCase(question.getOption1())
                || selected.equalsIgnoreCase(question.getOption2())
                || selected.equalsIgnoreCase(question.getOption3())
                || selected.equalsIgnoreCase(question.getOption4());

        if (!isValid) {
            return "Invalid option selected.";
        }

        userAndAnswerRepository.save(DTO);
        return "Answer submitted successfully.";
    }


    public List<Map<String, Object>> getOptionCounts(int questionId) {
        return userAndAnswerRepository.getOptionCountsByQuestionId(questionId);
    }



    public List<Map<String,Object>>TotalUserCountToQuestion(int questionId){
        return userAndAnswerRepository.TotalUserCountToQuestion(questionId);
    }



    public List<Map<String,Object>>UserAnswerToEachQuestion(int userid){
        return userAndAnswerRepository.UserAnswerToEachQuestion(userid);
    }

public int TotalQuestionsThisUserAnsweredTo(int userid){
        return userAndAnswerRepository.TotalQuestionsThisUserAnsweredTo(userid);
}

public List<Map<String,Object>>returnAllQuestionsWithUserOptionCounts(){
        return userAndAnswerRepository.returnAllQuestionsWithUserOptionCounts();
}






}
