package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n\nHi, AttendanceApp!\n");

        System.out.println("What is your name??\n");

        Scanner sc = new Scanner(System.in);

        String name = sc.next();

        System.out.println("\nHello " + name + "\n");

        //TODO Create and output List of absences

        ArrayList<Integer> numbers = new ArrayList<>();

        Random rand = new Random();

        System.out.println("How many Absences would you like to output " + name + "\n");

        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            int ran = rand.nextInt(11);
            numbers.add(ran);
        }
        System.out.println(numbers);

        //TODO How many of the absences did people have perfect attendance

        int perfectCount = 0;
        for (int i = 0; i < num; i++) {
            if (numbers.get(i) == 0) {
                perfectCount++;
            }
        }
        System.out.println("\nThe number of perfect Attendances are: " + perfectCount);

        //TODO What is the average of the attendances

        int sum = 0;
        double avg = 0;

        for (int i = 0; i < num; i++) {
            sum = numbers.get(i) + sum;
            avg = sum / num;
        }
        System.out.println("The Average is :" + avg);


        //TODO What percent of students had fewer than three absences

        int absencesCount = 0;
        double percentageOfAbs = 0;
        for (int i = 0; i < num; i++) {
            if (numbers.get(i) < 3){
                absencesCount ++;
                percentageOfAbs = absencesCount * .10;
            }
        }
        System.out.println("The percentage of absences is :" + percentageOfAbs );
    }
}