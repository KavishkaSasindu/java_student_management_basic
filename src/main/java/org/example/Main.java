package org.example;

import java.util.Scanner;

public class Main {

    private static int initial_students = 100;
    private static String[] student_names = new String[initial_students];
    private static int[] student_grades = new int[initial_students];

    // track students with variable
    private static int trackStudent = 0;

    public static void main(String[] args) {

        // with while loop and looping the user inputs
        while (true) {
            Scanner out = new Scanner(System.in);

            System.out.println("Student management system");
            System.out.println("======================================");
            System.out.println("1. Add Student here :");
            System.out.println("2. Display all students:");
            System.out.println("3. Search students by name:");
            System.out.println("4. Total average here:");
            System.out.println("5. Sorted grade here:");
            System.out.println("6. Highest grade here:");
            System.out.println("7. Lowest grade here:");
            System.out.println("8. Update student here:");
            System.out.println("9. Remove student here:");
            System.out.println("==========================================");
            System.out.print("Your choice here:");
            int choice = out.nextInt();
            switch (choice) {
                case 1:
                    addStudents();
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    searchStudentsByName();
                    break;
                case 4:
                    calculateAverageGrade();
                    break;
                case 5:
                    sortStudentByGrade();
                    break;
                case 6:
                    findHighestGradeStudent();
                    break;
                case 7:
                    findLowestGradeStudent();
                    break;
                case 8:
                    updateStudentGrade();
                    break;
                case 9:
                    removeStudent();
                    break;
                default:
                    break;
            }

        }
    }

    public static void addStudents() {

        Scanner out = new Scanner(System.in);
        if (trackStudent == initial_students) {
            resizeArrays();
        }

        System.out.print("Enter student name here :");
        String name = out.nextLine();
        System.out.print("Enter student grade here :");
        int grade = out.nextInt();
        student_names[trackStudent] = name;
        student_grades[trackStudent] = grade;
        trackStudent++;

    }

    public static void displayAllStudents() {
        if (trackStudent == 0) {
            System.out.println("no students in database");
        } else {
            int i;
            for (i = 0; i < trackStudent; i++) {
                System.out.println(student_names[i] + "  " + student_grades[i]);
            }
        }
    }

    public static void searchStudentsByName() {
        Scanner out = new Scanner(System.in);
        System.out.println("");
        System.out.print("Enter student name to search :");
        String name = out.nextLine();
        boolean found = false;
        int i;
        for (i = 0; i < trackStudent; i++) {
            if (student_names[i].equalsIgnoreCase(name)) {
                System.out.println("");
                System.out.println("Student found " + student_names[i] + " " + student_grades[i]);
                found = true;
            }
            if (!found) {
                System.out.println("");
                System.out.println("User not found in database");
            }
        }
    }

    public static void calculateAverageGrade() {
        if (trackStudent == 0) {
            System.out.println("");
            System.out.println("No grades or students here");
        } else {
            int i;
            int sum = 0;
            for (i = 0; i < trackStudent; i++) {
                sum += student_grades[i];
            }
            double avg = (double) sum / trackStudent;

            System.out.println(" ");
            System.out.println(" Average is " + avg);
        }
    }

    // i use bubble sort to sort th array..in here it will compare the values and
    // then swap and pop the highest grade to right corner

    public static void sortStudentByGrade() {
        int i;
        int j;
        if (trackStudent == 0) {
            System.out.println("No students or grade here");
        }
        for (i = 0; i < trackStudent - 1; i++) {
            for (j = 0; j < trackStudent - 1; j++) {
                if (student_grades[i] > student_grades[j + 1]) {
                    int tempGrade = student_grades[i];
                    student_grades[i] = student_grades[i + 1];
                    student_grades[i + 1] = tempGrade;

                    String tempName = student_names[i];
                    student_names[i] = student_names[i + 1];
                    student_names[i + 1] = tempName;

                }
            }
            System.out.println("Sorted grade ");
            int k;
            for (k = 0; k < trackStudent; k++) {
                System.out.println(student_names[i] + " " + student_grades[i]);
            }
        }
    }

    public static void findHighestGradeStudent() {
        if (trackStudent == 0) {
            System.out.println("No students here");
        }
        int i;

        int highestGrade = student_grades[0];
        String highestName = student_names[0];

        for (i = 0; i < trackStudent; i++) {
            if (student_grades[i] > highestGrade) {
                highestGrade = student_grades[i];
                highestName = student_names[i];

            }
        }

        System.out.println(highestName + " " + "student have highest " + highestGrade);
    }

    public static void findLowestGradeStudent() {
        if (trackStudent == 0) {
            System.out.println("No students here");
        }
        int i;

        int lowestGrade = student_grades[0];
        String lowestName = student_names[0];

        for (i = 0; i < trackStudent; i++) {
            if (student_grades[i] < lowestGrade) {
                lowestGrade = student_grades[i];
                lowestName = student_names[i];

            }
        }

        System.out.println(lowestName + " " + "student have lowest " + lowestGrade);
    }

    public static void updateStudentGrade() {
        Scanner out = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Enter name to update the student grade :");
        String name = out.nextLine();
        int i;
        boolean found = false;
        for (i = 0; i < trackStudent; i++) {
            if (student_names[i].equalsIgnoreCase(name)) {
                System.out.print("Enter grade you want to update");
                int newGrade = out.nextInt();
                student_grades[i] = newGrade;
                found = true;
                System.out.println("updated user grade " + student_grades[i]);
            }
        }
        if (!found) {
            System.out.println("User not found");
        }
    }

    public static void removeStudent() {
        Scanner out = new Scanner(System.in);
        System.out.println("Enter name to remove :");

        String name = out.nextLine();
        int i;
        boolean found = true;
        for (i = 0; i < trackStudent; i++) {
            if (student_names[i].equalsIgnoreCase(name)) {
                for (int j = i; j < trackStudent - 1; j++) {
                    student_names[j] = student_names[j + 1];
                    student_grades[j] = student_grades[j + 1];
                }
                trackStudent--;
                found = true;
                System.out.println("Student removed " + student_names[i]);
            }
        }
        if (!found) {
            System.out.println("Student not found");
        }
    }

    private static void resizeArrays() {
        int newCapacity = student_names.length * 10;
        String[] newNames = new String[newCapacity];
        int[] newGrades = new int[newCapacity];
        System.arraycopy(student_names, 0, newNames, 0, trackStudent);
        System.arraycopy(student_grades, 0, newGrades, 0, trackStudent);
        student_names = newNames;
        student_grades = newGrades;
    }

}