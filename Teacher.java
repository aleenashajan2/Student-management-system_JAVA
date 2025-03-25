package teacher;

public class Teacher implements Details {
    private int teacherID;
    private String name;
    private String specialization;
    private String email;
    private String hireDate;
    private String phoneNumber;
    private String address;
    private String qualification;
    private int experienceYears;
    private String department;

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
}
