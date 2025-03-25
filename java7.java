import java.util.Scanner;
class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}
class InvalidStudentException extends Exception {
    public InvalidStudentException(String message) {
        super(message);
    }
}
class Student {
    private int id;
    private String name;
    private int age;
    public Student(int id, String name, int age) throws InvalidStudentException {
        if (id <= 0 || name.isEmpty() || age <= 0) {
            throw new InvalidStudentException("Invalid student details provided!");
        }
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String toString() {
        return "Student [ID: " + id + ", Name: " + name + ", Age: " + age + "]";
    }
}
class StudentManagement {
    private static final int MAX_STUDENTS = 100; 
    private Student[] students = new Student[MAX_STUDENTS];
    private int count = 0; 
    public void addStudent(int id, String name, int age) {
        try {
            if (count >= MAX_STUDENTS) {
                System.out.println("Error: Student limit reached!");
                return;
            }
            Student student = new Student(id, name, age);
            students[count++] = student;
            System.out.println("Student added successfully: " + student);
        } catch (InvalidStudentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public Student getStudent(int id) throws StudentNotFoundException {
        for (int i = 0; i < count; i++) {
            if (students[i].getId() == id) {
                return students[i];
            }
        }
        throw new StudentNotFoundException("Student with ID " + id + " not found!");
    }
    public void displayStudents() {
        if (count == 0) {
            System.out.println("No students found!");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(students[i]);
        }
    }
    public static void main(String[] args) {
        StudentManagement system = new StudentManagement();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Display All Students");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Age: ");
                        int age = scanner.nextInt();
                        system.addStudent(id, name, age);
                        break;
                    case 2:
                        System.out.print("Enter Student ID: ");
                        int searchId = scanner.nextInt();
                        Student student = system.getStudent(searchId);
                        System.out.println("Student Found: " + student);
                        break;
                    case 3:
                        system.displayStudents();
                        break;
                    case 4:
                        System.out.println("Exiting system...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option! Please try again.");
                }
            } catch (StudentNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }
}
