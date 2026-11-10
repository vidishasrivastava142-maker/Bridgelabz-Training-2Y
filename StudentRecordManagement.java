import java.util.Scanner;

class Student {
    int roll, age;
    String name, grade;
    Student next;

    Student(int r, String n, int a, String g) {
        roll = r;
        name = n;
        age = a;
        grade = g;
        next = null;
    }
}

public class Main {
    static Student head = null;
    static Scanner sc = new Scanner(System.in);

    static void add(int pos) {
        System.out.print("Roll Number: ");
        int r = sc.nextInt();
        sc.nextLine();

        System.out.print("Name: ");
        String n = sc.nextLine();

        System.out.print("Age: ");
        int a = sc.nextInt();
        sc.nextLine();

        System.out.print("Grade: ");
        String g = sc.nextLine();

        Student temp = new Student(r, n, a, g);

        if (pos == 1) {
            temp.next = head;
            head = temp;
            return;
        }

        Student p = head;

        for (int i = 1; i < pos - 1 && p != null; i++)
            p = p.next;

        if (p == null) {
            System.out.println("Invalid position");
            return;
        }

        temp.next = p.next;
        p.next = temp;
    }

    static void delete() {
        System.out.print("Enter Roll Number: ");
        int r = sc.nextInt();

        if (head == null) return;

        if (head.roll == r) {
            head = head.next;
            System.out.println("Deleted");
            return;
        }

        Student p = head;

        while (p.next != null && p.next.roll != r)
            p = p.next;

        if (p.next == null)
            System.out.println("Student not found");
        else {
            p.next = p.next.next;
            System.out.println("Deleted");
        }
    }

    static void search() {
        System.out.print("Enter Roll Number: ");
        int r = sc.nextInt();

        Student p = head;

        while (p != null) {
            if (p.roll == r) {
                System.out.println(p.roll + " " + p.name +
                        " " + p.age + " " + p.grade);
                return;
            }
            p = p.next;
        }

        System.out.println("Not found");
    }

    static void update() {
        System.out.print("Enter Roll Number: ");
        int r = sc.nextInt();
        sc.nextLine();

        Student p = head;

        while (p != null) {
            if (p.roll == r) {
                System.out.print("Enter new grade: ");
                p.grade = sc.nextLine();
                System.out.println("Updated");
                return;
            }
            p = p.next;
        }

        System.out.println("Not found");
    }

    static void display() {
        Student p = head;

        while (p != null) {
            System.out.println(p.roll + " " + p.name +
                    " " + p.age + " " + p.grade);
            p = p.next;
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1.Add Beginning");
            System.out.println("2.Add End");
            System.out.println("3.Add Position");
            System.out.println("4.Delete");
            System.out.println("5.Search");
            System.out.println("6.Display");
            System.out.println("7.Update Grade");
            System.out.println("8.Exit");

            int ch = sc.nextInt();

            switch (ch) {
                case 1: add(1); break;
                case 2: add(Integer.MAX_VALUE); break;
                case 3:
                    System.out.print("Position: ");
                    add(sc.nextInt());
                    break;
                case 4: delete(); break;
                case 5: search(); break;
                case 6: display(); break;
                case 7: update(); break;
                case 8: return;
                default: System.out.println("Invalid choice");
            }
        }
    }
}