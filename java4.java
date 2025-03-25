import java.util.*;
abstract class Person {
    final String name;
    final String email;
    final String phoneNumber;
    final String address;
    public Person(String name, String email, String phoneNumber, String address) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    public final void displayCommonDetails() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Address: " + address);
    }
    public abstract void displayDetails();
}
class Teacher extends Person {
    int teacherID;
    String specialization;
    String hireDate;
    String qualification;
    int experienceYears;
    String department;
    public Teacher(int teacherID, String name, String specialization, String email, String hireDate,
                   String phoneNumber, String address, String qualification, int experienceYears, String department) {
        super(name, email, phoneNumber, address);
        this.teacherID = teacherID;
        this.specialization = specialization;
        this.hireDate = hireDate;
        this.qualification = qualification;
        this.experienceYears = experienceYears;
        this.department = department;
    }
    public void displayDetails() {
        System.out.println("\n--- Teacher Details ---");
        System.out.println("Teacher ID: " + teacherID);
        displayCommonDetails();
        System.out.println("Specialization: " + specialization);
        System.out.println("Hire Date: " + hireDate);
        System.out.println("Qualification: " + qualification);
        System.out.println("Experience Years: " + experienceYears);
        System.out.println("Department: " + department);
    }
    public static boolean isValidEmail(String email) {
        return email.contains("@") && email.indexOf("@") > 0 && email.indexOf(".") > email.indexOf("@");
    }
    public static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.length() == 10 && phoneNumber.chars().allMatch(Character::isDigit);
    }
    public static boolean isValidDate(String date) {
        String[] parts = date.split("/");
        if (parts.length != 3) return false;
        try {
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);
            return day > 0 && day <= 31 && month > 0 && month <= 12 && year > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean isValidExperienceYears(int experienceYears) {
        return experienceYears >= 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of teachers: ");
        int n = sc.nextInt();
        sc.nextLine();
        Teacher[] ob = new Teacher[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Teacher " + (i + 1) + ":");
            int teacherID;
            while (true) {
                System.out.print("Teacher ID: ");
                teacherID = sc.nextInt();
                if (teacherID > 0) break;
                else System.out.println("Teacher ID must be a positive integer.");
            }
            sc.nextLine();
            String name;
            while (true) {
                System.out.print("Name: ");
                name = sc.nextLine();
                if (!name.isEmpty()) break;
                else System.out.println("Name cannot be empty.");
            }
            String specialization;
            while (true) {
                System.out.print("Specialization: ");
                specialization = sc.nextLine();
                if (!specialization.isEmpty()) break;
                else System.out.println("Specialization cannot be empty.");
            }
            String email;
            while (true) {
                System.out.print("Email: ");
                email = sc.nextLine();
                if (isValidEmail(email)) break;
                else System.out.println("Invalid email format.");
            }
            String hireDate;
            while (true) {
                System.out.print("Hire Date (DD/MM/YYYY): ");
                hireDate = sc.nextLine();
                if (isValidDate(hireDate)) break;
                else System.out.println("Invalid date format. Please use DD/MM/YYYY.");
            }
            String phoneNumber;
            while (true) {
                System.out.print("Phone Number: ");
                phoneNumber = sc.nextLine();
                if (isValidPhoneNumber(phoneNumber)) break;
                else System.out.println("Phone number must be 10 digits.");
            }
            String address;
            while (true) {
                System.out.print("Address: ");
                address = sc.nextLine();
                if (!address.isEmpty()) break;
                else System.out.println("Address cannot be empty.");
            }
            String qualification;
            while (true) {
                System.out.print("Qualification: ");
                qualification = sc.nextLine();
                if (!qualification.isEmpty()) break;
                else System.out.println("Qualification cannot be empty.");
            }
            int experienceYears;
            while (true) {
                System.out.print("Experience Years: ");
                experienceYears = sc.nextInt();
                if (isValidExperienceYears(experienceYears)) break;
                else System.out.println("Experience Years must be a non-negative integer.");
            }
            sc.nextLine();
            String department;
            while (true) {
                System.out.print("Department: ");
                department = sc.nextLine();
                if (!department.isEmpty()) break;
                else System.out.println("Department cannot be empty.");
            }
            ob[i] = new Teacher(teacherID, name, specialization, email, hireDate, phoneNumber, address, qualification, experienceYears, department);
        }
        System.out.println("\n--- Displaying Teacher Details ---");
        for (int i = 0; i < n; i++) {
            System.out.println("\nTeacher " + (i + 1) + ":");
            ob[i].displayDetails();
        }
        sc.close();
    }
}
