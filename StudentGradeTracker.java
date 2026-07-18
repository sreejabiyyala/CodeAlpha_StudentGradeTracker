import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    // Student Class
    static class Student {
        int id;
        String name;
        double marks;

        Student(int id, String name, double marks) {
            this.id = id;
            this.name = name;
            this.marks = marks;
        }
    }

    // Add Student
    static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Student Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(id, name, marks));

        System.out.println("Student Added Successfully!");
    }

    // View Students
    static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("\n----- Student Details -----");

        for (Student s : students) {
            System.out.println("ID    : " + s.id);
            System.out.println("Name  : " + s.name);
            System.out.println("Marks : " + s.marks);
            System.out.println("---------------------------");
        }
    }

    // Average
    static void averageMarks() {

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        double sum = 0;

        for (Student s : students) {
            sum += s.marks;
        }

        System.out.println("Average Marks = " + (sum / students.size()));
    }

    // Highest
    static void highestMarks() {

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        Student highest = students.get(0);

        for (Student s : students) {
            if (s.marks > highest.marks) {
                highest = s;
            }
        }

        System.out.println("\nHighest Scorer");
        System.out.println("ID    : " + highest.id);
        System.out.println("Name  : " + highest.name);
        System.out.println("Marks : " + highest.marks);
    }

    // Lowest
    static void lowestMarks() {

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        Student lowest = students.get(0);

        for (Student s : students) {
            if (s.marks < lowest.marks) {
                lowest = s;
            }
        }

        System.out.println("\nLowest Scorer");
        System.out.println("ID    : " + lowest.id);
        System.out.println("Name  : " + lowest.name);
        System.out.println("Marks : " + lowest.marks);
    }

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== Student Grade Tracker =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Average Marks");
            System.out.println("4. Highest Marks");
            System.out.println("5. Lowest Marks");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    averageMarks();
                    break;

                case 4:
                    highestMarks();
                    break;

                case 5:
                    lowestMarks();
                    break;

                case 6:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}