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

    static void menuAddStudent(Scanner scanner) {
        System.out.println("\n--- Add New Student ---");

        try {
            System.out.print("Enter Student ID   : ");
            String id   = scanner.nextLine().trim();

            System.out.print("Enter Name         : ");
            String name = scanner.nextLine().trim();

            System.out.print("Enter Department   : ");
            String dept = scanner.nextLine().trim();

            System.out.print("Enter GPA (0.0-4.0): ");
            double gpa  = Double.parseDouble(scanner.nextLine().trim());

            if (gpa < 0.0 || gpa > 4.0) {
                System.out.println("GPA must be between 0.0 and 4.0.");
                return;
            }

            Student newStudent = new Student(id, name, dept, gpa);

            int fileType = askFileType(scanner);

            if (fileType == 1) {
                TextFileManager.addStudent(newStudent);
            } else if (fileType == 2) {
                BinaryFileManager.addStudent(newStudent);
            } else if (fileType == 3) {
                ObjectFileManager.addStudent(newStudent);
            } else {
                System.out.println("Invalid file type.");
            }

        } catch (Exception e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    static void menuSearchStudent(Scanner scanner) {
        System.out.println("\n--- Search Student ---");
        System.out.print("Enter Student ID to search: ");
        String id = scanner.nextLine().trim();

        int fileType = askFileType(scanner);

        Student found = null;

        if (fileType == 1) {
            found = TextFileManager.searchStudent(id);
        } else if (fileType == 2) {
            found = BinaryFileManager.searchStudent(id);
        } else if (fileType == 3) {
            found = ObjectFileManager.searchStudent(id);
        } else {
            System.out.println("Invalid file type.");
            return;
        }

        if (found != null) {
            System.out.println("Student found:");
            found.displayStudent();
        } else {
            System.out.println("No student found with ID: " + id);
        }
    }

    static void menuUpdateStudent(Scanner scanner) {
        System.out.println("\n--- Update Student ---");
        System.out.print("Enter Student ID to update: ");
        String id = scanner.nextLine().trim();

        try {
            System.out.print("Enter New Name         : ");
            String newName = scanner.nextLine().trim();

            System.out.print("Enter New Department   : ");
            String newDept = scanner.nextLine().trim();

            System.out.print("Enter New GPA (0.0-4.0): ");
            double newGpa  = Double.parseDouble(scanner.nextLine().trim());

            if (newGpa < 0.0 || newGpa > 4.0) {
                System.out.println("GPA must be between 0.0 and 4.0.");
                return;
            }

            int fileType = askFileType(scanner);

            if (fileType == 1) {
                TextFileManager.updateStudent(id, newName, newDept, newGpa);
            } else if (fileType == 2) {
                BinaryFileManager.updateStudent(id, newName, newDept, newGpa);
            } else if (fileType == 3) {
                ObjectFileManager.updateStudent(id, newName, newDept, newGpa);
            } else {
                System.out.println("Invalid file type.");
            }

        } catch (Exception e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }

    static void menuDeleteStudent(Scanner scanner) {
        System.out.println("\n--- Delete Student ---");
        System.out.print("Enter Student ID to delete: ");
        String id = scanner.nextLine().trim();


        System.out.print("Are you sure you want to delete student " + id + "? (yes/no): ");
        String confirm = scanner.nextLine().trim();

        if (!confirm.equalsIgnoreCase("yes")) {
            System.out.println("Deletion cancelled.");
            return;
        }

        int fileType = askFileType(scanner);

        if (fileType == 1) {
            TextFileManager.deleteStudent(id);
        } else if (fileType == 2) {
            BinaryFileManager.deleteStudent(id);
        } else if (fileType == 3) {
            ObjectFileManager.deleteStudent(id);
        } else {
            System.out.println("Invalid file type.");
        }
    }

    static void menuDisplayAll(Scanner scanner) {
        int fileType = askFileType(scanner);

        if (fileType == 1) {
            TextFileManager.displayAllStudents();
        } else if (fileType == 2) {
            BinaryFileManager.displayAllStudents();
        } else if (fileType == 3) {
            ObjectFileManager.displayAllStudents();
        } else {
            System.out.println("Invalid file type.");
        }
    }

    static void menuFileProperties(Scanner scanner) {
        System.out.println("\nWhich file properties would you like to see?");
        System.out.println("1. Text File");
        System.out.println("2. Binary File");
        System.out.println("3. Object File");
        System.out.println("4. Backup File");
        System.out.print("Enter choice: ");

        try {
            int pick = Integer.parseInt(scanner.nextLine().trim());

            if (pick == 1) {
                FileHelper.showFileProperties(FileHelper.textFile);
            } else if (pick == 2) {
                FileHelper.showFileProperties(FileHelper.binaryFile);
            } else if (pick == 3) {
                FileHelper.showFileProperties(FileHelper.objectFile);
            } else if (pick == 4) {
                FileHelper.showFileProperties(FileHelper.backupFile);
            } else {
                System.out.println("Invalid choice.");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}