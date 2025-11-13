import java.util.Scanner;


 class student {
    String usn;
    String name;
    int subjects;
    int [] credits ;
    int [] marks ;
    void acceptDetails() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter USN: ");
        usn = sc.nextLine();

        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Enter number of subjects: ");
        subjects = sc.nextInt();

        credits = new int[subjects];
        marks = new int[subjects];

        for (int i = 0; i < subjects; i++) {
            System.out.print("Enter credits for subject " + (i + 1) + ": ");
            credits[i] = sc.nextInt();

            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }
    }

    void displayDetails() {
        System.out.println("\nStudent Details:");
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);
        System.out.println("Subject-wise Credits and Marks and Grade Points:");
        for (int i = 0; i < subjects; i++) {
            System.out.println("Subject " + (i + 1) + ": Credits = " + credits[i] + ", Marks = " + marks[i]+ " Grade Points = " + getGradePoint(marks[i]));
        }
    }

    
    void calculateSGPA() {
        int totalCredits = 0;
        double weightedGradePoints = 0.0;

        for (int i = 0; i < subjects; i++) {
            int gradePoint = getGradePoint(marks[i]);
            weightedGradePoints += gradePoint * credits[i];
            totalCredits += credits[i];
        }

        double sgpa = weightedGradePoints / totalCredits;
        System.out.printf("SGPA: %.2f\n", sgpa);
    }

    
    int getGradePoint(int marks) {
        if (marks >= 90) return 10;
        else if (marks >= 80) return 9;
        else if (marks >= 70) return 8;
        else if (marks >= 60) return 7;
        else if (marks >= 50) return 6;
        else if (marks >= 40) return 5;
        else return 0; 
    }

    public static void main(String[] args) {
        student s = new student();
        s.acceptDetails();
        s.displayDetails();
        s.calculateSGPA();
    }
}