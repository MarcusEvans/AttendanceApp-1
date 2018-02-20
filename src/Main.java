package com.company;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n\n******* Welcome to the AttendanceApp!********\n");

        System.out.println("What is your name??\n");

        Scanner sc = new Scanner(System.in);

        String name = sc.next();

        System.out.println("\nHi " + name + "\n");

        //Create and output List of absences
        ArrayList<Integer> absences = storedValues(10);
        System.out.println("absences : " + absences + "\n");

        // Find the index with perfect attendance
        ArrayList perfectAbs = objects(absences);
        System.out.println("The Index with perfect Attendance's are : " + perfectAbs + "\n");

        // Find the average of all the abscences
        double average = avg(absences);
        System.out.println("The average is : " + average + "\n");

        // What percentage of students had fewer than three abscences and perfect attendance
        double attendanceFinder = perfectPercentage(absences);
        System.out.println("The percentage of students with less than three absences and perfect attendance is : " + attendanceFinder + "\n");

        // Which students had [x] abscences
        int AttendanceFinder = whichStudent(absences, 3);
        System.out.println("These are the number of students with your desired amount of absences: " + AttendanceFinder + "\n");

        // Which Percentage of Students
        double failures = whichStudentFailed(absences);
        System.out.println("The percent of people who failed: " + failures + " percent" + "\n");

        // Average of Smart Students
        double smarties = whichStudentsComeToClass(absences, 7);
        System.out.println("The Percentage of students that didn't FE: " + smarties + "\n");

        //TODO Add [X] to any elements greater than [Y]
        //ArrayList elementChanger = elementAdder(absences, 3, 5);
        // System.out.println("The new ArrayList with the changed elements: " + elementChanger + "\n");

        // sort the absences using the library function
        Collections.sort(absences);
        System.out.println("The sorted absences : " + absences + "\n");

        // shuffle the absences using the library function
        Collections.shuffle(absences);
        System.out.println("The Shuffled absences : " + absences + "\n");

        // How many absences are unique
        Set<Integer> uniqueVals = unique(absences);
        System.out.println("The unique numbers in the Array are: " + uniqueVals + "\n");

        //TODO How many of each absences are there
        HashMap<Integer, Integer> map = absenceChart(absences);
        System.out.println("****The number of absences for each number :" + map);

        // Sort the absences using a user defined sort function
        Set<Integer> userSort = sorted(absences);
        System.out.println("These Are the Sorted values : " + userSort + "\n");

        // Shuffle the absences using a user defined shuffle function
        ArrayList<Integer> shuffle = userShuffle(absences);
        System.out.println("These Are the new shuffled values ; " + shuffle + "\n");


        ///////////////////////NEXT PIVOTAL TRACKER STORY

        System.out.println("*****NEXT PIVOTAL TRACKER STORY*****\n");

        // Create and output an ArrayList of 5 distinct names.

        ArrayList<String> names = storedNames();
        System.out.println("Names in Array : " + names);

        // Shuffle the names using a user-defined shuffle function.
        ArrayList<String> nameShuffler = shuffle(names);
        System.out.println("\nThe new Array of Shuffled Names " + nameShuffler + "\n");

        // Using the 5 names, create another list that has the same size as the absences list.
        ArrayList<String> listCreator = createList(absences, names);
        System.out.println("New List with same amount of names as absences" + listCreator + "\n");

        // Were all 5 names used at least once?
        boolean uniqueStrings = uniqueString(names, listCreator);
        System.out.println("Where all names used at least once?? " + uniqueStrings + "\n");

        // What are the names of the students with perfect attendance?
        int doubleArray = stuWithNoAbs(names, absences);


        // What are the names of the students who have FE'd some course?
        int superArray = studentWhoFEd(names, absences);

        // How many courses does [name] have?
        int howManyCourses = courseCounter(absences, names, "Quavo");
        System.out.println("Your specified Name has " + howManyCourses + " courses \n");

        // Which courses did [name] FE?
        int howManyCoursesDidNameFe = courseCounterFe(absences, names, "Quavo");
        System.out.println("Your specified Name has FE'd " + howManyCoursesDidNameFe + " courses \n");

        // Generate today's date and output it.
        LocalDate todaysDate = todaysActualDate();
        System.out.println("Todays Date is : " + todaysDate + "\n");


        //TODO How many days have you been alive?  Use date1.equals(date2) to check your result.
        int howOldAmI = ageCounter(2018,1998);
        System.out.println("You are " + howOldAmI + "  many days old");

        //TODO Create a list of LocalDate objects.

        //TODO What are the names of students who have the longest number of days since an absence?

        //TODO What is the range of absence dates?

        //TODO What are the indexes of the students who have [X] absence date?

        //TODO What are the indexes of the students who have the same absence date?


    }


    private static ArrayList<Integer> storedValues(int numOfValues) {
        ArrayList<Integer> solution = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < numOfValues; i++) {
            int num = rand.nextInt(10);
            solution.add(num);
        }
        return solution;
    }

    private static ArrayList<Integer> objects(ArrayList<Integer> absences) {
        ArrayList<Integer> key = new ArrayList<>();
        for (int i = 0; i < absences.size(); i++) {
            if (absences.get(i) == 0) {
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

    public static int whichStudent(ArrayList<Integer> absences, int howManyAbsences) {
        int count = 0;
        for (int i = 0; i < absences.size(); i++) {
            if (absences.get(i) == howManyAbsences) {
                count++;
            }
        }
        return count;
    }

    public static double whichStudentFailed(ArrayList<Integer> absences) {
        double count = 0;
        for (int i = 0; i < absences.size(); i++) {
            if (absences.get(i) >= 7) {
                count++;
            }
        }
        return (count * 10);

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

    //public static ArrayList<Integer> elementAdder(ArrayList<Integer> absences, int x, int value) {
    //}


    public static Set<Integer> unique(ArrayList<Integer> numbers) {
        Set<Integer> storeUniques = new HashSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            storeUniques.add(numbers.get(i));
        }
        return storeUniques;
    }

    private static HashMap<Integer, Integer> absenceChart(ArrayList<Integer> absences) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < absences.size(); i++) {
            int key = absences.get(i);
            if (counts.containsKey(key)) {
                counts.put(key, counts.get(key) + 1);
            } else {
                counts.put(key, 1);
            }
        }
        return (HashMap<Integer, Integer>) counts;
    }


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
            absences.set(shuffle, absences.get(i));
            absences.set(i, temp);
        }
        return absences;
    }


    ///////////////////////NEXT PIVOTAL TRACKER STORY
    public static ArrayList<String> storedNames() {
        ArrayList<String> key = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            key.add("Ron");
            key.add("Quavo");
            key.add("Mike");
            key.add("Sammuel");
            key.add("G Herbo");
        }
        return key;
    }

    public static ArrayList<String> shuffle(ArrayList<String> names) {
        Random random = new Random();
        for (int i = 0; i < names.size(); i++) {
            int shuffle = random.nextInt(names.size());
            String temp = names.get(shuffle);
            names.set(shuffle, names.get(i));
            names.set(i, temp);
        }
        return names;
    }

    public static ArrayList<String> createList(ArrayList<Integer> absences, ArrayList<String> names) {
        Random random = new Random();
        ArrayList<String> solution = new ArrayList<>();
        for (int i = 0; i < absences.size(); i++) {
            int rand = random.nextInt(names.size());
            String temp = names.get(rand);
            solution.add(temp);
        }
        return solution;
    }

    private static boolean uniqueString(ArrayList<String> names, ArrayList list) {
        for (int i = 0; i < names.size(); i++) {
            if (names.size() < list.size() && names.get(i).equals(list.get(i))) {
                return false;
            }
        }

        return true;
    }

    private static int stuWithNoAbs(ArrayList<String> names, ArrayList<Integer> absences) {
        for (int i = 0; i < absences.size(); i++) {
            if (absences.get(i) == 0)
                System.out.println(names.get(i) + " has perfect attendance.\n");
        }

        return 0;
    }

    private static int studentWhoFEd(ArrayList<String> names, ArrayList<Integer> absences) {
        for (int i = 0; i < absences.size(); i++) {
            if (absences.get(i) == 7)
                System.out.println(names.get(i) + " has FE'd the course\n");
        }

        return 0;
    }

    private static int courseCounter(ArrayList<Integer> absences, ArrayList<String> names, String chosenName) {
        int absencesCounter = 0;
        for (int i = 0; i < absences.size(); i++) {
            if (names.get(i).equals(chosenName)) {
                absencesCounter++;
            }
        }
        return absencesCounter;
    }

    private static int courseCounterFe(ArrayList<Integer> absences, ArrayList<String> names, String chosenName) {
        int absencesFeCounter = 0;
        for (int i = 0; i < absences.size(); i++) {
            if (names.get(i).equals(chosenName) && absences.get(i) >= 7) {
                absencesFeCounter++;
            }
        }
        return absencesFeCounter;
    }

    private static LocalDate todaysActualDate() {
        LocalDate.now();
        return LocalDate.now();
    }

    private static int ageCounter(int currentYear, int birthYear) {
        LocalDate.now();
        int age = currentYear - birthYear;

        return age;
    }


}

