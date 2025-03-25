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
class SharedResource {
    public synchronized void performTask(String task) {
        System.out.println(Thread.currentThread().getName() + " is performing: " + task);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
        System.out.println(Thread.currentThread().getName() + " completed: " + task);
    }
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
}
class TeacherThread extends Thread {
    SharedResource resource;
    public TeacherThread(SharedResource resource, String name) {
        super(name);
        this.resource = resource;
    }
    public void run() {
        resource.performTask("Processing Teacher Data");
    }
}
class TeacherRunnable implements Runnable {
    SharedResource resource;
    public TeacherRunnable(SharedResource resource) {
        this.resource = resource;
    }
    public void run() {
        resource.performTask("Generating Report");
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
        SharedResource resource = new SharedResource();
        TeacherThread t1 = new TeacherThread(resource, "Thread-1");
        Thread t2 = new Thread(new TeacherRunnable(resource), "Thread-2");
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
        scanner.close();
    }
}
