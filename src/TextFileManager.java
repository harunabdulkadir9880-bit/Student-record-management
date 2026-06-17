import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class TextFileManager {

    public static ArrayList<Student> loadAllStudents() {
        ArrayList<Student> list = new ArrayList<Student>();

        try {
            File file = new File(FileHelper.textFile);

            // If file doesn't exist or is empty, just return empty list
            if (!file.exists() || file.length() == 0) {
                return list;
            }

            Scanner scanner = new Scanner(file);

            // Each student is saved as 4 lines: ID, Name, Department, GPA
            while (scanner.hasNextLine()) {
                String id     = scanner.nextLine().trim();
                String name   = scanner.nextLine().trim();
                String dept   = scanner.nextLine().trim();
                double gpa    = Double.parseDouble(scanner.nextLine().trim());

                Student s = new Student(id, name, dept, gpa);
                list.add(s);
            }

            scanner.close();

        } catch (Exception e) {
            System.out.println("Error loading from text file: " + e.getMessage());
        }

        return list;
    }

    public static void saveAllStudents(ArrayList<Student> list) {
        try {

            PrintWriter writer = new PrintWriter(new FileWriter(FileHelper.textFile, false));

            for (int i = 0; i < list.size(); i++) {
                Student s = list.get(i);
                writer.println(s.studentID);
                writer.println(s.name);
                writer.println(s.department);
                writer.println(s.gpa);
            }

            writer.close();

        } catch (Exception e) {
            System.out.println("Error saving to text file: " + e.getMessage());
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
        System.out.println("Student added successfully (Text File).");
    }
    public static Student searchStudent(String id) {
        ArrayList<Student> list = loadAllStudents();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).studentID.equals(id)) {
                return list.get(i);
            }
        }

        return null; // Not found
    }


}
