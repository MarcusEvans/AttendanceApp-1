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

        // Create and output List of absences

        ArrayList<Integer> numbers = new ArrayList<>();

        Random rand = new Random();

        System.out.println("How many Absences would you like to output " + name +"\n");

        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            int ran = rand.nextInt(10)+1;
            numbers.add(ran);
        }
        System.out.println(numbers);
    }
}
