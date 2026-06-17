import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
public class ObjectFileManager{
    public static ArrayList<Student> loadAllStudents() {
        ArrayList<Student> list = new ArrayList<Student>();

        try {
            File file = new File(FileHelper.objectFile);


            if (!file.exists() || file.length() == 0) {
                return list;
            }


            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));


            list = (ArrayList<Student>) ois.readObject();

            ois.close();

        } catch (Exception e) {
            System.out.println("Error loading from object file: " + e.getMessage());
        }

        return list;
    }

    public static void saveAllStudents(ArrayList<Student> list) {
        try {

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FileHelper.objectFile, false));


            oos.writeObject(list);

            oos.close();

        } catch (Exception e) {
            System.out.println("Error saving to object file: " + e.getMessage());
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
        System.out.println("Student added successfully (Object File).");
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
            System.out.println("Student updated successfully (Object File).");
        } else {
            System.out.println("Student not found with ID: " + id);
        }
    }

    public static void deleteStudent(String id) {
        ArrayList<Student> list = loadAllStudents();
        boolean found = false;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).studentID.equals(id)) {
                list.remove(i);
                found = true;
                break;
            }
        }

        if (found) {
            saveAllStudents(list);
            System.out.println("Student deleted successfully (Object File).");
        } else {
            System.out.println("Student not found with ID: " + id);
        }
    }



}