package com.dogigiri.core.controlFlow;

public class Main {
    public static void main(String[] args) {
        int score = 95;
        char grade;
        if(score >=90) grade = 'A';
        else if (score >= 80) grade = 'B';
        else if (score >= 70) grade = 'C';
        else grade = 'D';
        System.out.println(grade);

        switch (grade) {
            case 'A':
                System.out.println("Best");
                break;
            case 'B':
                System.out.println("Good");
                break;
            case 'C':
                System.out.println("Need effort");
                break;
            default:
                System.out.println("Not Good");
        }
    }
}
