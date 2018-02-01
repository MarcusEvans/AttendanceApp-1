package com.company;

import java.util.*;

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
        System.out.println("The average is : " + average + "\n");

        //TODO What percentage of students had fewer than three abscences and perfect attendance
        double attendanceFinder = perfectPercentage(abscences);
        System.out.println("The percentage of students with less than three abscenses and perfect attendance is : " + attendanceFinder + "\n");

        //TODO WHich students had [x] abscences
        ArrayList<Integer> AttendanceFinder = whichStudent(abscences,5);
        System.out.println("These are the number of students with your desired amount of abscences: " + attendanceFinder + "\n");

        //TODO Which Percentage of Students
        ArrayList<Integer> failures = whichStudentFailed(abscences);
        System.out.println("The Percentage of students who failed: " + failures + "\n");

        //TODO Average of Smart Students
        double smarties = whichStudentsComeToClass(abscences);
        System.out.println("The Percentage of students that didnt FE: " + smarties + "\n");

        //TODO Add [X] to any elements greater than [Y]
        ArrayList<Integer> elementChanger = changer(abscences,3,5);
        System.out.println("The new ArrayList : " + elementChanger + "\n");

        //TODO sort the abscences using the library function
        Collections.sort(abscences);
        System.out.println("The sorted abscences : " + abscences);

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
    private static double perfectPercentage(ArrayList<Integer> abscences){
        double val1 = 0;
        double val2 = 0;
        for (int i = 0; i < abscences.size(); i++) {
            if (abscences.get(i) < 3){
                val1++;
            if (abscences.get(i) == 0){
                val2++;
            }
            }
        }
        return (val2 / val1)* 100;
    }
    public static ArrayList<Integer> whichStudent(ArrayList<Integer> abscences,int howManyAbscences){
        ArrayList<Integer> solution = new ArrayList<>();
        for (int i = 0; i < abscences.size(); i++) {
            if (abscences.get(i) == howManyAbscences){
                solution.add(i);
            }
        }
        return solution;
    }
    private static ArrayList<Integer> whichStudentFailed(ArrayList<Integer> abscences) {
        ArrayList<Integer> key = new ArrayList<>();
        for (int i = 0; i < abscences.size(); i++) {
            if (abscences.get(i) == 7){
                key.add(abscences.get(i));
            }
        }
        return key;

    }
    private static double whichStudentsComeToClass(ArrayList<Integer> abscences) {
        double sum = 0;
        double averageOfSmart = 0;
        for (int i = 0; i < abscences.size(); i++) {
            if (abscences.get(i) < 7) {
                sum = sum + 1;
                averageOfSmart = sum / abscences.size();
            }

        }
        return (averageOfSmart * 100);

    }
    public static ArrayList<Integer> changer(ArrayList<Integer> abscences, int value, int bound) {
        ArrayList<Integer> solution = new ArrayList<>();
        for (int i = 0; i < abscences.size(); i++) {
            if (abscences.get(i) > bound){
                solution.add(abscences.get(i) + value);
            }
        }
        return solution;
    }
}


