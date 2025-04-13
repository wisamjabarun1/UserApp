package com.example.UserApp.Repository;

import com.example.UserApp.Models.AnswerRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserAndAnswerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(AnswerRequestDTO DTO) {
        String sql = "INSERT INTO UserAndQuestionAndAnswer (user_id, question_id, selected_option) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, DTO.getUserId(), DTO.getQuestionId(), DTO.getSelectedOption());
    }


    public List<Map<String, Object>> getOptionCountsByQuestionId(int questionId) {
        String sql = "SELECT selected_option, COUNT(DISTINCT user_id) AS user_count " +
                "FROM UserAndQuestionAndAnswer " +
                "WHERE question_id = ? " +
                "GROUP BY selected_option";

        return jdbcTemplate.queryForList(sql, questionId);
    }

    public List<Map<String, Object>> TotalUserCountToQuestion(int questionId ){
        String sql="SELECT question_id, COUNT(DISTINCT user_id) AS user_count " +
                "FROM UserAndQuestionAndAnswer " +
                "WHERE question_id = ? " +
                "GROUP BY question_id";

        return jdbcTemplate.queryForList(sql, questionId);
    }


    public  List<Map<String,Object>> UserAnswerToEachQuestion(int userid){
        String sql = "SELECT question_id, selected_option " +
                "FROM UserAndQuestionAndAnswer " +
                "WHERE user_id = ?";
        return jdbcTemplate.queryForList(sql, userid);
    }




    public int TotalQuestionsThisUserAnsweredTo(int userId) {
        String sql = "SELECT COUNT(DISTINCT question_id) FROM UserAndQuestionAndAnswer WHERE user_id = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, userId);
    }




    public List<Map<String, Object>> returnAllQuestionsWithUserOptionCounts() {
        String sql = "SELECT " +
                "    question_id, " +
                "    selected_option, " +
                "    COUNT(*) AS user_count " +
                "FROM " +
                "    UserAndQuestionAndAnswer " +
                "GROUP BY " +
                "    question_id, selected_option " +
                "ORDER BY " +
                "    question_id, selected_option;";

        return jdbcTemplate.queryForList(sql);
    }



    public String deleteAnswer(int id) {
        try {
            String sql = "DELETE FROM UserAndQuestionAndAnswer WHERE Id = ?";
            jdbcTemplate.update(sql, id);
            return "the Answers Are Deleted and so the user ! ";

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }




















}
