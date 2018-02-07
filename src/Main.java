package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n\n******* Welcome to the AttendanceApp!********\n");

        System.out.println("What is your name??\n");

        Scanner sc = new Scanner(System.in);

        String name = sc.next();

        System.out.println("\nHi " + name + "\n");

        //TODO Create and output List of absences
        ArrayList<Integer> absences = storedValues(20);
        System.out.println("absences : " + absences + "\n");

        //TODO Find the index with perfect attendance
        ArrayList perfectAbs = objects(absences);
        System.out.println("The Index with perfect Attendance's are : " + perfectAbs + "\n");

        //TODO Find the average of all the abscences
        double average = avg(absences);
        System.out.println("The average is : " + average + "\n");

        //TODO What percentage of students had fewer than three abscences and perfect attendance
        double attendanceFinder = perfectPercentage(absences);
        System.out.println("The percentage of students with less than three absences and perfect attendance is : " + attendanceFinder + "\n");

        //TODO WHich students had [x] abscences
        ArrayList<Integer> AttendanceFinder = whichStudent(absences, 5);
        System.out.println("These are the number of students with your desired amount of absences: " + attendanceFinder + "\n");

        //TODO Which Percentage of Students
        ArrayList<Integer> failures = whichStudentFailed(absences,7);
        System.out.println("The Percentage of students who failed: " + failures + "\n");

        //TODO Average of Smart Students
        double smarties = whichStudentsComeToClass(absences,7);
        System.out.println("The Percentage of students that didnt FE: " + smarties + "\n");

        //TODO Add [X] to any elements greater than [Y]
        ArrayList<Integer> elementChanger = changer(absences, 3, 5);
        System.out.println("The new ArrayList : " + elementChanger + "\n");

        //TODO sort the absences using the library function
        Collections.sort(absences);
        System.out.println("The sorted abscences : " + absences + "\n");

        //TODO shuffle the absences using the library function
        Collections.shuffle(absences);
        System.out.println("The Shuffled abscences : " + absences + "\n");

        //TODO How many absences are unique
        Set<Integer> uniqueVals = unique(absences);
        System.out.println("The unique numbers in the Array are: " + uniqueVals + "\n");

        //TODO How many of each absences are there
      //  Set<Integer> howManyAbs = abscenceChart(abscences);
       // System.out.println("****The number of abscences for each number :" + howManyAbs);

        //TODO Sort the absences using a user defined sort function
        Set<Integer> userSort = sorted(absences);
        System.out.println("These Are the Sorted values : " + userSort + "\n");

        //TODO Shuffle the absences using a user defined shuffle function
        ArrayList<Integer> shuffle = userShuffle(absences);
        System.out.println("These Are the shuffled values ; " + shuffle + "\n");


    }

    private static ArrayList<Integer> storedValues(int numOfValues) {
        ArrayList<Integer> solution = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < numOfValues; i++) {
            int num = rand.nextInt(5);
            solution.add(num);
        }
        return solution;
    }

    private static ArrayList<Integer> objects(ArrayList<Integer> abscences) {
        ArrayList<Integer> key = new ArrayList<>();
        for (int i = 0; i < abscences.size(); i++) {
            if (abscences.get(i) == 0) {
                key.add(i);
            }
        }
        return key;
    }

    private static double avg(ArrayList<Integer> absences) {
        int sum = 0;
        double avg = 0;
        for (int i = 0; i < absences.size(); i++) {
            sum = sum + absences.get(i);
            avg = sum / absences.size();
        }
        return avg;
    }

    private static double perfectPercentage(ArrayList<Integer> absences) {
        double val1 = 0;
        double val2 = 0;
        for (int i = 0; i < absences.size(); i++) {
            if (absences.get(i) < 3) {
                val1++;
                if (absences.get(i) == 0) {
                    val2++;
                }
            }
        }
        return (val2 / val1) * 100;
    }

    public static ArrayList<Integer> whichStudent(ArrayList<Integer> absences, int howManyAbsences) {
        ArrayList<Integer> solution = new ArrayList<>();
        for (int i = 0; i < absences.size(); i++) {
            if (absences.get(i) == howManyAbsences) {
                solution.add(i);
            }
        }
        return solution;
    }

    private static ArrayList<Integer> whichStudentFailed(ArrayList<Integer> absences,int value) {
        ArrayList<Integer> key = new ArrayList<>();
        for (int i = 0; i < absences.size(); i++) {
            if (absences.get(i) == value) {
                key.add(absences.get(i));
            }
        }
        return key;

    }

    private static double whichStudentsComeToClass(ArrayList<Integer> absences, int value) {
        double sum = 0;
        double averageOfSmart = 0;
        for (int i = 0; i < absences.size(); i++) {
            if (absences.get(i) < value) {
                sum = sum + 1;
                averageOfSmart = sum / absences.size();
            }

        }
        return (averageOfSmart * 100);

    }

    public static ArrayList<Integer> changer(ArrayList<Integer> abscences, int value, int bound) {
        ArrayList<Integer> solution = new ArrayList<>();
        for (int i = 0; i < abscences.size(); i++) {
            if (abscences.get(i) > bound) {
                solution.add(abscences.get(i) + value);
            }
        }
        return solution;
    }

    public static Set<Integer> unique(ArrayList<Integer> numbers) {
        Set<Integer> storeUniques = new HashSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            storeUniques.add(numbers.get(i));
        }
        return storeUniques;
    }
//    public static Set<Integer> abscenceChart(ArrayList<Integer> numbers){
//        Set<Integer> storeUniques = new HashSet<>();
//        for (int i = 0; i < numbers.size(); i++) {
//            storeUniques.add(numbers.get(i));
//            if ()
//        }
//        return storeUniques;

    private static Set<Integer> sorted(ArrayList<Integer> absences) {
        Set<Integer> storeVals = new HashSet<>();
        for (int i = 0; i < absences.size(); i++) {
            storeVals.add(absences.get(i));
        }
        return storeVals;
    }
    private static ArrayList<Integer> userShuffle(ArrayList<Integer> absences) {
        Random rand = new Random();
        for (int i = 0; i < absences.size(); i++) {
            int shuffle = rand.nextInt(absences.size());
            int temp = absences.get(shuffle);
            absences.set(shuffle,absences.get(i));
            absences.set(i,temp);
        }
        return absences;
    }

}

