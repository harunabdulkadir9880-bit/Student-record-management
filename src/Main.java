import java.util.Scanner;
public class Main  {
    public static void main(String[] args) {

        FileHelper.setupFiles();

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        System.out.println("\nWelcome to the Student Management System!");


     while (choice != 9) {

        printMainMenu();


        try {
            choice = Integer.parseInt(scanner.nextLine().trim());
        } catch (Exception e) {
            System.out.println("Please enter a valid number.");
            continue;
        }


        if (choice == 1) {
            menuAddStudent(scanner);

        } else if (choice == 2) {
            menuSearchStudent(scanner);

        } else if (choice == 3) {
            menuUpdateStudent(scanner);

        } else if (choice == 4) {
            menuDeleteStudent(scanner);

        } else if (choice == 5) {
            menuDisplayAll(scanner);

        } else if (choice == 6) {
            ReportGenerator.generateReport();

        } else if (choice == 7) {
            BackupManager.createBackup();

        } else if (choice == 8) {
            menuFileProperties(scanner);

        } else if (choice == 9) {
            System.out.println("Goodbye! Exiting the program.");

        } else {
            System.out.println("Invalid choice. Please enter a number between 1 and 9.");
        }
    }

        scanner.close();
    }

    static void printMainMenu() {
        System.out.println("\n========== MAIN MENU ==========");
        System.out.println("1. Add Student");
        System.out.println("2. Search Student by ID");
        System.out.println("3. Update Student Information");
        System.out.println("4. Delete Student");
        System.out.println("5. Display All Students");
        System.out.println("6. Generate Report");
        System.out.println("7. Backup Student Records");
        System.out.println("8. Show File Properties");
        System.out.println("9. Exit");
        System.out.println("================================");
        System.out.print("Enter your choice: ");
    }

    static int askFileType(Scanner scanner) {
        System.out.println("\nChoose storage type:");
        System.out.println("1. Text File");
        System.out.println("2. Binary File");
        System.out.println("3. Object File (Serialization)");
        System.out.print("Enter choice: ");

        try {
            int type = Integer.parseInt(scanner.nextLine().trim());
            return type;
        } catch (Exception e) {
            System.out.println("Invalid input. Defaulting to text file.");
            return 1;
        }
    }
}