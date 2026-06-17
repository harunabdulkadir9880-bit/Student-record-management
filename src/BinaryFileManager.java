import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
public class BinaryFileManager {
    public static ArrayList<Student> loadAllStudents() {
        ArrayList<Student> list = new ArrayList<Student>();

        try {
            File file = new File(FileHelper.binaryFile);
            if (!file.exists() || file.length() == 0) {
                return list;
            }


            DataInputStream dis = new DataInputStream(new FileInputStream(file));


            while (dis.available() > 0) {
                String id   = dis.readUTF();
                String name = dis.readUTF();
                String dept = dis.readUTF();
                double gpa  = dis.readDouble();

                Student s = new Student(id, name, dept, gpa);
                list.add(s);
            }

            dis.close();

        } catch (Exception e) {
            System.out.println("Error loading from binary file: " + e.getMessage());
        }

        return list;
    }

    public static void saveAllStudents(ArrayList<Student> list) {
        try {

            DataOutputStream dos = new DataOutputStream(new FileOutputStream(FileHelper.binaryFile, false));

            for (int i = 0; i < list.size(); i++) {
                Student s = list.get(i);
                dos.writeUTF(s.studentID);
                dos.writeUTF(s.name);
                dos.writeUTF(s.department);
                dos.writeDouble(s.gpa);
            }

            dos.close();

        } catch (Exception e) {
            System.out.println("Error saving to binary file: " + e.getMessage());
        }
    }

    public static void addStudent(Student newStudent) {
        ArrayList<Student> list = loadAllStudents();


        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).studentID.equals(newStudent.studentID)) {
                System.out.println("A student with this ID already exists!");
                return;
            }
        }

        list.add(newStudent);
        saveAllStudents(list);
        System.out.println("Student added successfully (Binary File).");
    }
    public static Student searchStudent(String id) {
        ArrayList<Student> list = loadAllStudents();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).studentID.equals(id)) {
                return list.get(i);
            }
        }

        return null;
    }

    public static void updateStudent(String id, String newName, String newDept, double newGpa) {
        ArrayList<Student> list = loadAllStudents();
        boolean found = false;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).studentID.equals(id)) {
                list.get(i).name       = newName;
                list.get(i).department = newDept;
                list.get(i).gpa        = newGpa;
                found = true;
                break;
            }
        }

        if (found) {
            saveAllStudents(list);
            System.out.println("Student updated successfully (Binary File).");
        } else {
            System.out.println("Student not found with ID: " + id);
        }
    }







}