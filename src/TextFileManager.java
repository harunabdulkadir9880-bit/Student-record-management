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

}
