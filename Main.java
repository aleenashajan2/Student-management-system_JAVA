import teacher.Teachers;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter details for a Teacher:");
        System.out.print("Teacher ID: ");
        int teacherID = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Specialization: ");
        String specialization = sc.nextLine();
        String email;
        do {
            System.out.print("Email: ");
            email = sc.nextLine();
            if (!Teachers.isValidEmail(email)) {
                System.out.println("Invalid email. Please enter a valid email address.");
            }
        } while (!Teachers.isValidEmail(email));
        String hireDate;
        do {
            System.out.print("Hire Date (DD/MM/YYYY): ");
            hireDate = sc.nextLine();
            if (!Teachers.isValidDate(hireDate)) {
                System.out.println("Invalid date format. Please enter a valid date in DD/MM/YYYY format.");
            }
        } while (!Teachers.isValidDate(hireDate));
        String phoneNumber;
        do {
            System.out.print("Phone Number: ");
            phoneNumber = sc.nextLine();
            if (!Teachers.isValidPhoneNumber(phoneNumber)) {
                System.out.println("Invalid phone number. Please enter a 10-digit phone number.");
            }
        } while (!Teachers.isValidPhoneNumber(phoneNumber));
        System.out.print("Address: ");
        String address = sc.nextLine();
        System.out.print("Qualification: ");
        String qualification = sc.nextLine();
        int experienceYears;
        do {
            System.out.print("Experience Years: ");
            experienceYears = sc.nextInt();
            sc.nextLine(); 
            if (!Teachers.isValidExperienceYears(experienceYears)) {
                System.out.println("Invalid experience years. Please enter a non-negative number.");
            }
        } while (!Teachers.isValidExperienceYears(experienceYears));
        System.out.print("Department: ");
        String department = sc.nextLine();
        Teachers teacher = new Teachers(
                teacherID, name, specialization, email, hireDate,
                phoneNumber, address, qualification, experienceYears, department
        );
        System.out.println("\n--- Displaying Teacher Details ---");
        teacher.displayDetails();
    }
}
