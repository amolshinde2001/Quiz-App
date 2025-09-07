package com.example.demo.service;

import com.example.demo.dto.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class QuizService {

    private List<Question> questions = new ArrayList<>(Arrays.asList(
            new Question("Which keyword is used to define a class in Java?",
                    Arrays.asList("class", "Class", "define", "struct"),
                    "Class"),

            new Question("What is the default value of a boolean variable in Java?",
                    Arrays.asList("true", "false", "0", "null"),
                    "false"),

            new Question("Which method is the entry point for any Java program?",
                    Arrays.asList("start()", "main()", "init()", "run()"),
                    "main()"),

            new Question("Which keyword is used to inherit a class in Java?",
                    Arrays.asList("extends", "implements", "inherits", "super"),
                    "extends"),

            new Question("What is the size of an int data type in Java?",
                    Arrays.asList("2 bytes", "4 bytes", "8 bytes", "Depends on the system"),
                    "2 bytes"),

            new Question("Which keyword is used to declare a constant in Java?",
                    Arrays.asList("static", "constant", "final", "immutable"),
                    "final"),

            new Question("Which operator is used to compare two values in Java?",
                    Arrays.asList("=", "==", "equals", "==="),
                    "=="),

            new Question("What is the parent class of all classes in Java?",
                    Arrays.asList("Object", "Class", "Main", "Parent"),
                    "Object"),

            new Question("Which of these is not a Java primitive data type?",
                    Arrays.asList("int", "float", "String", "char"),
                    "String"),

            new Question("Which package is automatically imported into every Java program?",
                    Arrays.asList("java.util", "java.lang", "java.io", "java.net"),
                    "java.lang")
    ));

    // Get all questions
    public List<Question> getQuestions() {
        return questions;
    }

    // Add a new question
    public String addQuestion(Question newQuestion) {
        if (newQuestion.getQuestionText() == null || newQuestion.getOptions() == null || newQuestion.getCorrectAnswer() == null) {
            return "Error: Question, options, and answer cannot be null!";
        }
        questions.add(newQuestion);
        return "Question added successfully!";
    }

    // Delete a question by index
    public String deleteQuestion(int index) {
        if (index < 0 || index >= questions.size()) {
            return "Error: Invalid question index!";
        }
        questions.remove(index);
        return "Question removed successfully!";
    }

    // Update a question by index
    public String updateQuestion(int index, Question updatedQuestion) {
        if (index < 0 || index >= questions.size()) {
            return "Error: Invalid question index!";
        }
        if (updatedQuestion.getQuestionText() == null || updatedQuestion.getOptions() == null || updatedQuestion.getCorrectAnswer() == null) {
            return "Error: Question, options, and answer cannot be null!";
        }
        questions.set(index, updatedQuestion);
        return "Question updated successfully!";
    }
}