package com.example.UserApp.PollApp;


import com.example.UserApp.Models.PollResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${external-api.PollApp.name}", url = "${external-api.PollApp.url}")

public interface PollAppInterFace {


    @GetMapping ("/Questions/{QuestionId}")
    PollResponse GetQuestionsbyid (@PathVariable int QuestionId);


}
