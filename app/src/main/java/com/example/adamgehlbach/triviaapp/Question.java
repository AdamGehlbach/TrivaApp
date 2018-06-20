package com.example.adamgehlbach.triviaapp;

public class Question {

    private String question;
    private String correctAnswer;
    private String incorrectAnswerOne;
    private String incorrectAnswerTwo;
    private String incorrectAnswerThree;


    public Question(String question, String correctAnswer, String incorrectAnswerOne, String incorrectAnswerTwo, String incorrectAnswerThree) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswerOne = incorrectAnswerOne;
        this.incorrectAnswerTwo = incorrectAnswerTwo;
        this.incorrectAnswerThree = incorrectAnswerThree;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getIncorrectAnswerOne() {
        return incorrectAnswerOne;
    }

    public String getIncorrectAnswerTwo() {
        return incorrectAnswerTwo;
    }

    public String getIncorrectAnswerThree() {
        return incorrectAnswerThree;
    }
}
