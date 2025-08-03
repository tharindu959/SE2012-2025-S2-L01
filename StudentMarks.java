import java.util.Scanner;

public class StudentMarks {
    static int[][] marks;  // [studentID][subjectID]
    static int n; // number of students
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter number of students: ");
        n = scanner.nextInt();
        marks = new int[n + 1][4]; // subjects: 1=Math, 2=Chem, 3=Phys

        System.out.println("\nCommands:\n- add [studentID]\n- update [studentID] [subjectID]\n- average [studentID]\n- average_s [subjectID]\n- total [studentID]\n- exit\n");

        while (true) {
            System.out.print("Enter command: ");
            String command = scanner.next();

            if (command.equals("add")) {
                int studentID = scanner.nextInt();
                addStudentMarks(studentID);

            } else if (command.equals("update")) {
                int studentID = scanner.nextInt();
                int subjectID = scanner.nextInt();
                updateStudentMark(studentID, subjectID);

            } else if (command.equals("average")) {
                int studentID = scanner.nextInt();
                averageStudent(studentID);

            } else if (command.equals("average_s")) {
                int subjectID = scanner.nextInt();
                averageSubject(subjectID);

            } else if (command.equals("total")) {
                int studentID = scanner.nextInt();
                totalMarks(studentID);

            } else if (command.equals("exit")) {
                break;

            } else {
                System.out.println("Invalid command!");
            }
        }

        scanner.close();
    }

    static void addStudentMarks(int id) {
        if (id < 1 || id > n) {
            System.out.println("Invalid student ID.");
            return;
        }
        System.out.print("Enter Mathematics mark: ");
        marks[id][1] = scanner.nextInt();
        System.out.print("Enter Chemistry mark: ");
        marks[id][2] = scanner.nextInt();
        System.out.print("Enter Physics mark: ");
        marks[id][3] = scanner.nextInt();
        System.out.println("Marks added for student " + id);
    }

    static void updateStudentMark(int id, int subjectID) {
        if (id < 1 || id > n || subjectID < 1 || subjectID > 3) {
            System.out.println("Invalid input.");
            return;
        }
        System.out.print("Enter new mark for subject " + subjectID + ": ");
        marks[id][subjectID] = scanner.nextInt();
        System.out.println("Mark updated.");
    }

    static void averageStudent(int id) {
        if (id < 1 || id > n) {
            System.out.println("Invalid student ID.");
            return;
        }
        double avg = (marks[id][1] + marks[id][2] + marks[id][3]) / 3.0;
        System.out.println("Average mark for student " + id + ": " + avg);
    }

    static void averageSubject(int subjectID) {
    if (subjectID < 1 || subjectID > 3) {
        System.out.println("Invalid subject ID.");
        return;
    }

    int total = 0;
    for (int i = 1; i <= n; i++) {
        total += marks[i][subjectID];
    }
    double avg = total / (double) n;

    String subjectName = "";
    switch (subjectID) {
        case 1:
            subjectName = "Mathematics";
            break;
        case 2:
            subjectName = "Chemistry";
            break;
        case 3:
            subjectName = "Physics";
            break;
    }

    System.out.println("Average for " + subjectName + ": " + avg);
}

    static void totalMarks(int id) {
        if (id < 1 || id > n) {
            System.out.println("Invalid student ID.");
            return;
        }
        int total = marks[id][1] + marks[id][2] + marks[id][3];
        System.out.println("Total marks for student " + id + ": " + total);
    }
}
