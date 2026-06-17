# Student Management System

A simple Java console application to manage student records using three
different storage methods: text files, binary files, and object
serialization.

## What This Program Does

This program lets you add, search, update, delete, and display student
records. Each student has an ID, name, department, and GPA. You can choose
to save your data as a plain text file, a binary file, or a serialized
object file — all three work independently of each other.

## Project Files

| File | What it does |
|---|---|
| `Main.java` | The entry point. Shows the menu and connects everything together. |
| `Student.java` | The blueprint for a student (ID, name, department, GPA). |
| `FileHelper.java` | Creates folders/files automatically and shows file properties (size, path, last modified). |
| `TextFileManager.java` | Add/Search/Update/Delete/Display students using `Scanner` and `PrintWriter` (text file). |
| `BinaryFileManager.java` | Same operations using `DataInputStream` and `DataOutputStream` (binary file). |
| `ObjectFileManager.java` | Same operations using `ObjectInputStream` and `ObjectOutputStream` (object serialization). |
| `BackupManager.java` | Creates a backup copy of the text file using `BufferedReader` and `BufferedWriter`. |
| `ReportGenerator.java` | Calculates total students, highest GPA, lowest GPA, and average GPA. |

## How to Run It

1. Put all 8 `.java` files in the same folder.
2. Open a terminal in that folder.
3. Compile everything:
   ```
   javac *.java
   ```
4. Run the program:
   ```
   java Main
   ```

The program will automatically create a `data` folder (for the text,
binary, and object files) and a `backup` folder the first time it runs.

## Menu Options

```
1. Add Student
2. Search Student by ID
3. Update Student Information
4. Delete Student
5. Display All Students
6. Generate Report
7. Backup Student Records
8. Show File Properties
9. Exit
```

For options 1–5, you'll be asked to pick which storage type to use:
text file, binary file, or object file. Each storage type keeps its
own separate copy of the data, so a student added to the text file
won't automatically appear in the binary file unless you add it there
too.

## Where the Data Is Saved

```
data/students.txt   → text file storage
data/students.dat   → binary file storage
data/students.obj   → object (serialized) file storage
backup/students_backup.txt → backup of the text file
```

## Notes

- GPA must be between 0.0 and 4.0.
- Deleting a student asks for confirmation first.
- The report (option 6) currently reads from the text file.
- The backup (option 7) also currently backs up the text file.
- All file operations are wrapped in try/catch so the program won't
  crash if something goes wrong (like a missing file).
