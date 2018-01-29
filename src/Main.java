package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n\n******* Welcome to the AttendanceApp!********\n");

        System.out.println("What is your name??\n");

        Scanner sc = new Scanner(System.in);

        String name = sc.next();

        System.out.println("\nHello " + name + "\n");

        //TODO Create and output List of absences
        ArrayList<Integer> abscences = storedValues(20);
        System.out.println("Abscences : " + abscences + "\n");

        //TODO Find the index with perfect attendance
        ArrayList perfectAbs = objects(abscences);
        System.out.println("The Index with perfect Attendance's are : " + perfectAbs + "\n");

        //TODO Find the average of all the abscences
        double average = avg(abscences);
        System.out.println("The average is : " + average);

        //TODO

    }

    private static ArrayList<Integer> storedValues(int numOfValues) {
        ArrayList<Integer> solution = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < numOfValues; i++) {
            int num = rand.nextInt(11);
            solution.add(num);
        }
        return solution;
    }
    private static ArrayList<Integer> objects(ArrayList<Integer> abscences) {
        ArrayList<Integer> key = new ArrayList<>();
        for (int i = 0; i < abscences.size(); i++) {
            if (abscences.get(i)== 0){
                key.add(i);
            }
        }
        return key ;
    }
    private static double avg(ArrayList<Integer> abscences) {
        int sum = 0;
        double avg = 0;
        for (int i = 0; i < abscences.size(); i++) {
            sum = sum + abscences.get(i);
            avg = sum / abscences.size();
        }
        return avg;
    }

}


