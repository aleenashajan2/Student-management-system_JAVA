import java.util.*;
class Student {
    int regno;
    String name;
    int sem;
    String grade;
    void get(int r, String n, int se, String g) {
        regno = r;
        name = n;
        sem = se;
        grade = g;
    }
    void display() {
        System.out.println("Register no: " + regno);
        System.out.println("Name: " + name);
        System.out.println("Semester: " + sem);
        System.out.println("Grade: " + grade);
        System.out.println("Mark List Updated!!");
    }
    public static void main(String args[]) {
        Student ob = new Student();
        Scanner sc = new Scanner(System.in);
        int regno;
        String name;
        int sem;
        String grade;
        System.out.println("Enter Register no.: ");
        regno = sc.nextInt();
        while (true) {
            System.out.print("Enter Name (only alphabets): ");
            name = sc.next();
            if (name.matches("[a-zA-Z]+")) {
                break;
            } else {
                System.out.println("Invalid name. Please enter only alphabets.");
            }
        }
        while (true) {
            System.out.print("Enter Semester (1 to 8): ");
            sem = sc.nextInt();
            if (sem >= 1 && sem <= 8) {
                break;
            } else {
                System.out.println("Invalid semester. Please enter a value between 1 and 8.");
            }
        }
        while (true) {
            System.out.print("Enter Grade (A, B, C, D, F): ");
            grade = sc.next().toUpperCase();
            if (grade.matches("[A-F]") && !grade.equals("E")) {
                break;
            } else {
                System.out.println("Invalid grade. Please enter A, B, C, D, or F.");
            }
        }
        ob.get(regno, name, sem, grade);
        ob.display();
    }
}