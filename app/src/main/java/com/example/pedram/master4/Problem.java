package com.example.pedram.master4;

import java.util.Random;

/**
 * Created by Pedram on 6/24/2017.
 */

public class Problem {

    private int answer;
    private String Question;

    /**
     * Make a qustion
     */
    public void generate() {
        Random random = new Random();
        int operator = random.nextInt(2);
        int A = random.nextInt(50);
        int B = random.nextInt(50);

        switch (operator) {
            case 0:
                answer = A - B;
                Question = String.valueOf(A) + " - " + String.valueOf(B) + " =";
                break;
            case 1:
                answer = A + B;
                Question = String.valueOf(A) + " + " + String.valueOf(B) + " =";
        }
    }

    public int getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return Question;
    }
}
