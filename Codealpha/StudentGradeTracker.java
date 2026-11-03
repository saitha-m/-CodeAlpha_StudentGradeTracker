import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> marks = new ArrayList<>();

        int n;

        // Validate number of students
        while (true) {
            System.out.print("Enter the number of students: ");

            if (sc.hasNextInt()) {
                n = sc.nextInt();
                sc.nextLine();

                if (n > 0) {
                    break;
                }
            } else {
                sc.nextLine();
            }

            System.out.println("Please enter a number greater than zero.");
        }

        // Input student details
        for (int i = 0; i < n; i++) {

            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            int mark;

            while (true) {
                System.out.print("Enter marks (0-100): ");

                if (sc.hasNextInt()) {
                    mark = sc.nextInt();
                    sc.nextLine();

                    if (mark >= 0 && mark <= 100) {
                        break;
                    }
                } else {
                    sc.nextLine();
                }

                System.out.println("Enter valid marks between 0 and 100.");
            }

            names.add(name);
            marks.add(mark);
        }

        // Calculate statistics
        int total = 0;
        int highest = marks.get(0);
        int lowest = marks.get(0);

        for (int mark : marks) {
            total += mark;

            if (mark > highest) {
                highest = mark;
            }

            if (mark < lowest) {
                lowest = mark;
            }
        }

        double average = (double) total / n;

        // Display summary report
        System.out.println("\n========== STUDENT GRADE REPORT ==========");
        System.out.printf("%-20s %s%n", "Student Name", "Marks");
        System.out.println("------------------------------------------");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-20s %d/100%n",
                    names.get(i), marks.get(i));
        }

        System.out.println("------------------------------------------");
        System.out.printf("Average Marks : %.2f%n", average);
        System.out.println("Highest Marks : " + highest);
        System.out.println("Lowest Marks  : " + lowest);
        System.out.println("==========================================");

        sc.close();
    }
}