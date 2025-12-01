import java.util.InputMismatchException;
import java.util.Scanner;


class InvalidMarksException extends Exception {
    public InvalidMarksException(String message) {
        super(message);
    }
}


class Student {

    private int rollNumber;
    private String studentName;
    private int[] marks = new int[3];

    public Student(int rollNumber, String studentName, int[] marks) {
        this.rollNumber = rollNumber;
        this.studentName = studentName;
        this.marks = marks;
    }

    
    public void validateMarks() throws InvalidMarksException {
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] < 0 || marks[i] > 100) {
                throw new InvalidMarksException(
                        "Invalid marks for subject " + (i + 1) + ": " + marks[i]);
            }
        }
    }

    public double calculateAverage() {
        int sum = 0;
        for (int m : marks) sum += m;
        return sum / 3.0;
    }

    public String getResultStatus() {
        double avg = calculateAverage();
        return avg >= 33 ? "Pass" : "Fail";
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void displayResult() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Student Name: " + studentName);

        System.out.print("Marks: ");
        for (int m : marks) System.out.print(m + " ");
        System.out.println();

        System.out.println("Average: " + calculateAverage());
        System.out.println("Result: " + getResultStatus());
    }
}


public class ResultManager {

    private Student[] students = new Student[100];
    private int count = 0;
    private Scanner sc = new Scanner(System.in);

   
    public void addStudent() throws InvalidMarksException {

        try {
            System.out.print("Enter Roll Number: ");
            int roll = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            int[] marks = new int[3];

            for (int i = 0; i < 3; i++) {
                System.out.print("Enter marks for subject " + (i + 1) + ": ");
                marks[i] = sc.nextInt();
            }

            Student s = new Student(roll, name, marks);
            s.validateMarks();  

            students[count++] = s;
            System.out.println("Student added successfully.");

        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input type. Please enter numeric values.");
            sc.nextLine(); 
        }
    }

   
    public void showStudentDetails() {
        try {
            System.out.print("Enter Roll Number to search: ");
            int roll = sc.nextInt();

            boolean found = false;

            for (int i = 0; i < count; i++) {
                if (students[i].getRollNumber() == roll) {
                    students[i].displayResult();
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("No student found with roll number: " + roll);
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid roll number.");
            sc.nextLine();
        }
    }

   
    public void mainMenu() {

        try {
            int choice;

            while (true) {
                System.out.println("\n===== Student Result Management System =====");
                System.out.println("1. Add Student");
                System.out.println("2. Show Student Details");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        try {
                            addStudent();
                        } catch (InvalidMarksException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 2:
                        showStudentDetails();
                        break;

                    case 3:
                        System.out.println("Exiting program. Thank you!");
                        return;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        } finally {
           
            sc.close();
            System.out.println("Scanner closed. Program terminated.");
        }
    }

   
    public static void main(String[] args) {
        ResultManager manager = new ResultManager();
        manager.mainMenu();
    }
}