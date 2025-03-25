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
    public void stringOperations() {
        System.out.println("\n--- String Operations ---");
        System.out.println("UpperCase Name: " + name.toUpperCase());
        System.out.println("LowerCase Name: " + name.toLowerCase());
        System.out.println("Length of Email: " + email.length());
        System.out.println("Substring of Email (first 5 chars): " + email.substring(0, 5));
        System.out.println("Does Email contain '@': " + email.contains("@"));
        System.out.println("Replace '@' with '#': " + email.replace('@', '#'));
    }
    public void stringBufferOperations() {
        System.out.println("\n--- StringBuffer Operations ---");
        StringBuffer sb = new StringBuffer(name);
        System.out.println("Original Name: " + sb);
        sb.append(" - Professor");
        System.out.println("After Append: " + sb);
        sb.insert(0, "Dr. ");
        System.out.println("After Insert: " + sb);
        sb.replace(0, 3, "Mr.");
        System.out.println("After Replace: " + sb);
        sb.reverse();
        System.out.println("After Reverse: " + sb);
        sb.delete(0, 3);
        System.out.println("After Delete: " + sb);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  
        System.out.print("Enter Teacher ID: ");
        int teacherID = scanner.nextInt();
        scanner.nextLine();      
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();       
        System.out.print("Enter Specialization: ");
        String specialization = scanner.nextLine();        
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();       
        System.out.print("Enter Hire Date (DD/MM/YYYY): ");
        String hireDate = scanner.nextLine();       
        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();       
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();       
        System.out.print("Enter Qualification: ");
        String qualification = scanner.nextLine();       
        System.out.print("Enter Experience Years: ");
        int experienceYears = scanner.nextInt();
        scanner.nextLine();       
        System.out.print("Enter Department: ");
        String department = scanner.nextLine();       
        Teacher teacher = new Teacher(teacherID, name, specialization, email, hireDate, 
                phoneNumber, address, qualification, experienceYears, department);
        teacher.displayDetails();
        teacher.stringOperations();
        teacher.stringBufferOperations();       
        scanner.close();
    }
}