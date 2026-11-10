import java.util.Scanner;

class Task {
    int id, priority;
    String name, date;
    Task next;

    Task(int i, String n, int p, String d) {
        id = i;
        name = n;
        priority = p;
        date = d;
    }
}

public class Main {
    static Task head = null, current = null;
    static Scanner sc = new Scanner(System.in);

    static void add(int pos) {
        System.out.print("Task ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Task Name: ");
        String name = sc.nextLine();

        System.out.print("Priority: ");
        int p = sc.nextInt();
        sc.nextLine();

        System.out.print("Due Date: ");
        String d = sc.nextLine();

        Task n = new Task(id, name, p, d);

        if (head == null) {
            head = n;
            n.next = n;
            current = head;
            return;
        }

        if (pos == 1) {
            Task last = head;

            while (last.next != head)
                last = last.next;

            n.next = head;
            last.next = n;
            head = n;
            return;
        }

        Task temp = head;

        for (int i = 1; i < pos - 1 && temp.next != head; i++)
            temp = temp.next;

        n.next = temp.next;
        temp.next = n;
    }

    static void delete() {
        if (head == null) return;

        System.out.print("Task ID: ");
        int id = sc.nextInt();

        Task p = head, prev = null;

        do {
            if (p.id == id) {
                if (p == head && p.next == head) {
                    head = current = null;
                } else {
                    if (prev == null) {
                        Task last = head;
                        while (last.next != head)
                            last = last.next;

                        head = head.next;
                        last.next = head;
                    } else {
                        prev.next = p.next;
                    }

                    if (current == p)
                        current = p.next;
                }

                System.out.println("Deleted");
                return;
            }

            prev = p;
            p = p.next;

        } while (p != head);

        System.out.println("Not found");
    }

    static void viewCurrent() {
        if (current == null) {
            System.out.println("No tasks");
            return;
        }

        System.out.println(current.id + " " +
                current.name + " " + current.priority);
    }

    static void nextTask() {
        if (current == null) {
            System.out.println("No tasks");
            return;
        }

        current = current.next;
        viewCurrent();
    }

    static void display() {
        if (head == null) return;

        Task p = head;

        do {
            System.out.println(p.id + " " + p.name +
                    " " + p.priority + " " + p.date);
            p = p.next;
        } while (p != head);
    }

    static void search() {
        if (head == null) return;

        System.out.print("Enter priority: ");
        int priority = sc.nextInt();

        Task p = head;

        do {
            if (p.priority == priority)
                System.out.println(p.name);
            p = p.next;
        } while (p != head);
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1.Add Beginning");
            System.out.println("2.Add End");
            System.out.println("3.Add Position");
            System.out.println("4.Delete");
            System.out.println("5.Current Task");
            System.out.println("6.Next Task");
            System.out.println("7.Display");
            System.out.println("8.Search Priority");
            System.out.println("9.Exit");

            int ch = sc.nextInt();

            switch (ch) {
                case 1: add(1); break;
                case 2: add(Integer.MAX_VALUE); break;
                case 3:
                    System.out.print("Position: ");
                    add(sc.nextInt());
                    break;
                case 4: delete(); break;
                case 5: viewCurrent(); break;
                case 6: nextTask(); break;
                case 7: display(); break;
                case 8: search(); break;
                case 9: return;
                default: System.out.println("Invalid choice");
            }
        }
    }
}