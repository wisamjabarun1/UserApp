package com.example.UserApp.Models;

public class PollResponse {
    private int Id ;
    private String Title;
    private String Option1;
    private String Option2;
    private String Option3;
    private String Option4;


    public PollResponse() {

    }

    public PollResponse(int id, String option1, String option2, String option3, String option4, String title) {
        Id = id;
        Option1 = option1;
        Option2 = option2;
        Option3 = option3;
        Option4 = option4;
        Title = title;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getOption1() {
        return Option1;
    }

    public void setOption1(String option1) {
        Option1 = option1;
    }

    public String getOption2() {
        return Option2;
    }

    public void setOption2(String option2) {
        Option2 = option2;
    }

    public String getOption3() {
        return Option3;
    }

    public void setOption3(String option3) {
        Option3 = option3;
    }

    public String getOption4() {
        return Option4;
    }

    public void setOption4(String option4) {
        Option4 = option4;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }


    @Override
    public String toString() {
        return "PollResponse{" +
                "Id=" + Id +
                ", Title='" + Title + '\'' +
                ", Option1='" + Option1 + '\'' +
                ", Option2='" + Option2 + '\'' +
                ", Option3='" + Option3 + '\'' +
                ", Option4='" + Option4 + '\'' +
                '}';
    }
}


