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

}