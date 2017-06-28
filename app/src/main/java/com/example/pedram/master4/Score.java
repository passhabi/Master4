package com.example.pedram.master4;

/**
 * Created by Pedram on 6/26/2017.
 */

public class Score {
    private int score = 0;
    private int numberOfCorrectAnswers;
    private int numberOfIncorrectAnswers;
    private int numberOfAnsweredQuestion;
    private int chosenOption;
    private int boostCounter = 0;
    private int highScore = 0;
    private String isCorrect;


    public void setChoice(int choice, Problem problem) {
        chosenOption = choice;
        isAnswerCorrect(problem);
    }

    public String getHighScore() {
        return String.valueOf(highScore);
    }

    public void isAnswerCorrect(Problem problem) {
        if (problem.getAnswer() == chosenOption) {
            boost();
            numberOfCorrectAnswers += 1;
            isCorrect = "TRUE";
            if (highScore < score)
                highScore = score;
        } else {
            isCorrect = "FALSE";
            boostCounter = 0;
        }
        numberOfAnsweredQuestion += 1;
        numberOfIncorrectAnswers = numberOfAnsweredQuestion - numberOfCorrectAnswers;
    }

    public String getScore() {
        return String.valueOf(score);
    }

    public String getNumberOfCorrectAnswers() {
        return String.valueOf(numberOfCorrectAnswers);
    }

    public String getNumberOfIncorrectAnswers() {
        return String.valueOf(numberOfIncorrectAnswers);
    }

    public String getNumberOfAnsweredQuestion() {
        return String.valueOf(numberOfAnsweredQuestion);
    }

    public void reset() {
        score = 0;
        boostCounter = 0;
    }

    public String getIsCorrect() {
        return isCorrect;
    }

    private void boost() {
        switch (boostCounter++) {
            case 3:
                score += 100;
                break;
            case 5:
                score += 300;
                break;
            case 10:
                score += 500;
                break;
            case 15:
                score += 1000;
                boostCounter = 5;
                break;

            default:
                score += 50;
        }
    }
}
