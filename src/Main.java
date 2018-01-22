import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n\nHi, AttendanceApp!\n");

        System.out.println("What is your name??\n");

        Scanner sc = new Scanner(System.in);

        String name = sc.next();

        System.out.println("\nHello " + name + "\n");
    }
}
