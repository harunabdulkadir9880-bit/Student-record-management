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
}