package com.example.demo.controller;

import com.example.demo.dto.Question;
import com.example.demo.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") // Adjust the origins as needed
@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    // GET endpoint to retrieve all questions
    @GetMapping("/questions")
    public List<Question> getQuestions() {
        return quizService.getQuestions();
    }

    // POST endpoint to add a new question
    @PostMapping("/questions")
    public String addQuestion(@RequestBody Question newQuestion) {
        return quizService.addQuestion(newQuestion);
    }

    // DELETE endpoint to remove a question by index
    @DeleteMapping("/questions/{index}")
    public String deleteQuestion(@PathVariable int index) {
        return quizService.deleteQuestion(index);
    }

    // PUT endpoint to update an existing question
    @PutMapping("/questions/{index}")
    public String updateQuestion(@PathVariable int index, @RequestBody Question updatedQuestion) {
        return quizService.updateQuestion(index, updatedQuestion);
    }
}