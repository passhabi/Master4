package com.example.pedram.master4;

import java.util.Random;

/**
 * Created by Pedram on 6/24/2017.
 */

public class Options {
    private int a;
    private int b;
    private int c;
    private int d;
    private int answer;

    public void generate(Problem problem){
        Random random = new Random();

        switch (random.nextInt(4)){
            case 0:
                a = problem.getAnswer();
                b = random.nextInt(100);
                c = random.nextInt(100);
                d = random.nextInt(100);
                break;
            case 1:
                a = random.nextInt(100);
                b = problem.getAnswer();
                c = random.nextInt(100);
                d = random.nextInt(100);
                break;
            case 2:
                a = random.nextInt(100);
                b = random.nextInt(100);
                c = problem.getAnswer();
                d = random.nextInt(100);
                break;
            case 3:
                a = random.nextInt(100);
                b = random.nextInt(100);
                c = random.nextInt(100);
                d = problem.getAnswer();
        }
    }

    public String getOptionA() {
        return String.valueOf(a);
    }
    public String getOptionB() {
        return String.valueOf(b);
    }
    public String getOptionC() {
        return String.valueOf(c);
    }
    public String getOptionD() {
        return String.valueOf(d);
    }
}
