import java.io.File;
import java.util.Date;

public class FileHelper{

    public static String dataFolder   = "data";
    public static String backupFolder = "backup";
    public static String textFile     = "data/students.txt";
    public static String binaryFile   = "data/students.dat";
    public static String objectFile   = "data/students.obj";
    public static String backupFile   = "backup/students_backup.txt";

    public static void setupFiles() {
        try {

            File data = new File(dataFolder);
            if (!data.exists()) {
                data.mkdir();
                System.out.println("Created folder: " + dataFolder);
            }


            File backup = new File(backupFolder);
            if (!backup.exists()) {
                backup.mkdir();
                System.out.println("Created folder: " + backupFolder);
            }


            File txt = new File(textFile);
            if (!txt.exists()) {
                txt.createNewFile();
                System.out.println("Created file: " + textFile);
            }


            File dat = new File(binaryFile);
            if (!dat.exists()) {
                dat.createNewFile();
                System.out.println("Created file: " + binaryFile);
            }

        } catch (Exception e) {
            System.out.println("Error setting up files: " + e.getMessage());
        }
    }

}