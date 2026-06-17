import java.io.Serializable;
public class Student implements Serializable {

    String studentID;
    String name;
    String department;
    double gpa;

    public Student(String studentID, String name, String department, double gpa) {
        this.studentID = studentID;
        this.name = name;
        this.department = department;
        this.gpa = gpa;
    }


}
