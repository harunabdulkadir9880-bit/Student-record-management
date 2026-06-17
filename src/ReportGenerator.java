import java.util.ArrayList;
public class ReportGenerator{

    public static void generateReport() {

        ArrayList<Student> list = TextFileManager.loadAllStudents();

        System.out.println("\n========== STUDENT REPORT ==========");


        if (list.size() == 0) {
            System.out.println("No students found. Cannot generate report.");
            System.out.println("=====================================");
            return;
        }

        int total = list.size();
        System.out.println("Total Students : " + total);


        double highestGpa = list.get(0).gpa;
        double lowestGpa  = list.get(0).gpa;
        String highestName = list.get(0).name;
        String lowestName  = list.get(0).name;
        double totalGpa   = 0;

        for (int i = 0; i < list.size(); i++) {
            Student s = list.get(i);


            totalGpa = totalGpa + s.gpa;


            if (s.gpa > highestGpa) {
                highestGpa  = s.gpa;
                highestName = s.name;
            }


            if (s.gpa < lowestGpa) {
                lowestGpa  = s.gpa;
                lowestName = s.name;
            }
        }
        double averageGpa = totalGpa / total;


        double roundedAvg = Math.round(averageGpa * 100.0) / 100.0;

        System.out.println("Highest GPA    : " + highestGpa + " (" + highestName + ")");
        System.out.println("Lowest GPA     : " + lowestGpa  + " (" + lowestName  + ")");
        System.out.println("Average GPA    : " + roundedAvg);
        System.out.println("=====================================");
    }


}