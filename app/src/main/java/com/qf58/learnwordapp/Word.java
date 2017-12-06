package com.qf58.learnwordapp;

/**
 * Created by linSir
 * date at 2017/12/4.
 * describe:
 */

public class Word {

    private int id;
    private String word;
    private String type;
    private String rightSolution;
    private String errorSolution1;
    private String errorSolution2;
    private String errorSolution3;


    public Word(int id, String word, String type, String rightSolution, String errorSolution1, String errorSolution2, String errorSolution3) {
        this.id = id;
        this.word = word;
        this.type = type;
        this.rightSolution = rightSolution;
        this.errorSolution1 = errorSolution1;
        this.errorSolution2 = errorSolution2;
        this.errorSolution3 = errorSolution3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRightSolution() {
        return rightSolution;
    }

    public void setRightSolution(String rightSolution) {
        this.rightSolution = rightSolution;
    }

    public String getErrorSolution1() {
        return errorSolution1;
    }

    public void setErrorSolution1(String errorSolution1) {
        this.errorSolution1 = errorSolution1;
    }

    public String getErrorSolution2() {
        return errorSolution2;
    }

    public void setErrorSolution2(String errorSolution2) {
        this.errorSolution2 = errorSolution2;
    }

    public String getErrorSolution3() {
        return errorSolution3;
    }

    public void setErrorSolution3(String errorSolution3) {
        this.errorSolution3 = errorSolution3;
    }
}
