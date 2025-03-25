import java.util.*;
class Teacher {
    int teacherID;
    String name;
    String specialization;
    String email;
    String hireDate;
    String phoneNumber;
    String address;
    String qualification;
    int experienceYears;
    String department;
    public Teacher(int teacherID, String name, String specialization, String email, String hireDate, 
                   String phoneNumber, String address, String qualification, int experienceYears, String department) {
        this.teacherID = teacherID;
        this.name = name;
        this.specialization = specialization;
        this.email = email;
        this.hireDate = hireDate;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.qualification = qualification;
        this.experienceYears = experienceYears;
        this.department = department;
    }
    public void displayDetails() {
        System.out.println("\n--- Teacher Details ---");
        System.out.println("Teacher ID: " + teacherID);
        System.out.println("Name: " + name);
        System.out.println("Specialization: " + specialization);
        System.out.println("Email: " + email);
        System.out.println("Hire Date: " + hireDate);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Address: " + address);
        System.out.println("Qualification: " + qualification);
        System.out.println("Experience Years: " + experienceYears);
        System.out.println("Department: " + department);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of teachers: ");
        int n = sc.nextInt();
        sc.nextLine(); 
        Teacher[] ob = new Teacher[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Teacher " + (i + 1) + ":");
            System.out.print("Teacher ID: ");
            int teacherID = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Specialization: ");
            String specialization = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.print("Hire Date (DD/MM/YYYY): ");
            String hireDate = sc.nextLine();
            System.out.print("Phone Number: ");
            String phoneNumber = sc.nextLine();
            System.out.print("Address: ");
            String address = sc.nextLine();
            System.out.print("Qualification: ");
            String qualification = sc.nextLine();
            System.out.print("Experience Years: ");
            int experienceYears = sc.nextInt();
            sc.nextLine();
            System.out.print("Department: ");
            String department = sc.nextLine();
            ob[i] = new Teacher(teacherID, name, specialization, email, hireDate, phoneNumber, address, qualification, experienceYears, department);
        }
        System.out.println("\n--- Displaying Teacher Details ---");
        for (int i = 0; i < n; i++) {
            System.out.println("\nTeacher " + (i + 1) + ":");
            ob[i].displayDetails();
        }
    }
}

