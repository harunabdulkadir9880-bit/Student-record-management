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




}