import java.util.*;

class Student {
    String name;
    int roll;
    String[] subjects = {"DBMS", "OOP", "FOA", "WT"};
    int[] credits = {6, 5, 5, 6};
    double totalcredits = 22;
    int[] marks = new int[4];
    double sumpoint = 0;
    double SPI;
    Scanner sc = new Scanner(System.in);

    Student(String name, int roll) {
        this.name = name;
        this.roll = roll;
    }

    void getSubjectDetails() {
        for (int i = 0; i < 4; i++) {
            System.out.println("Enter marks for " + subjects[i] + ":");
            marks[i] = sc.nextInt();
            sumpoint += calculategradepoint(marks[i], credits[i]);
        }
    }

    int calculategradepoint(int marks, int credit) {
        int gp;
        if (marks >= 90) {
            gp = 10;
        } else if (marks >= 80) {
            gp = 9;
        } else if (marks >= 70) {
            gp = 8;
        } else if (marks >= 60) {
            gp = 7;
        } else if (marks >= 50) {
            gp = 6;
        } else if (marks >= 40) {
            gp = 5;
        } else {
            gp = 0;
           
        }
        return gp * credit;
    }

    void calculateSPI() {
        SPI = sumpoint / totalcredits;
    }

    void displayresult() {
        System.out.println("Name: " + name);
        System.out.println("Roll: " + roll);
        System.out.println("SPI: " + SPI);
    }
}

public class lab_7_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of Array: ");
        int size = Integer.parseInt(args[0]);
        Student[] s = new Student[size];

        String name;
        int roll;

        for (int i = 0; i < size; i++) {
            System.out.println("Enter Name: ");
            name = sc.next();
            System.out.println("Enter roll: ");
            roll = sc.nextInt();
            s[i] = new Student(name, roll);
            s[i].getSubjectDetails();
            s[i].calculateSPI();
            s[i].displayresult();
        }
    }
}
