package com.example.UserApp.Models;

public class AnswerRequestDTO {
    private int userId;
    private int questionId;
    private String selectedOption;

    public AnswerRequestDTO() {

    }

    public AnswerRequestDTO(int questionId, String selectedOption, int userId) {
        this.questionId = questionId;
        this.selectedOption = selectedOption;
        this.userId = userId;
    }





    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(String selectedOption) {
        this.selectedOption = selectedOption;
    }

    @Override
    public String toString() {
        return "AnswerRequestDTO{" +
                "questionId=" + questionId +
                ", userId=" + userId +
                ", selectedOption='" + selectedOption + '\'' +
                '}';
    }
}
