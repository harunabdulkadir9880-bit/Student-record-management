import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
public class BackupManager {
    public static void createBackup() {
        try {
            File source = new File(FileHelper.textFile);


            if (!source.exists() || source.length() == 0) {
                System.out.println("No data in text file to backup.");
                return;
            }


            BufferedReader reader = new BufferedReader(new FileReader(source));


            BufferedWriter writer = new BufferedWriter(new FileWriter(FileHelper.backupFile, false));


            writer.write("===== STUDENT BACKUP =====");
            writer.newLine();
            writer.write("Backup created on: " + new Date().toString());
            writer.newLine();
            writer.write("==========================");
            writer.newLine();


            String line = reader.readLine();
            while (line != null) {
                writer.write(line);
                writer.newLine();
                line = reader.readLine();
            }

            reader.close();
            writer.close();

            System.out.println("Backup created successfully at: " + FileHelper.backupFile);

        } catch (Exception e) {
            System.out.println("Error creating backup: " + e.getMessage());
        }
    }

}