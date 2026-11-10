import java.util.Scanner;

class Book {
    int id;
    String title, author, genre;
    boolean available;
    Book next, prev;

    Book(int i, String t, String a, String g, boolean av) {
        id = i;
        title = t;
        author = a;
        genre = g;
        available = av;
    }
}

public class Main {
    static Book head = null, tail = null;
    static Scanner sc = new Scanner(System.in);

    static void add(int pos) {
        System.out.print("Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Title: ");
        String t = sc.nextLine();

        System.out.print("Author: ");
        String a = sc.nextLine();

        System.out.print("Genre: ");
        String g = sc.nextLine();

        System.out.print("Available (true/false): ");
        boolean av = sc.nextBoolean();

        Book n = new Book(id, t, a, g, av);

        if (head == null) {
            head = tail = n;
            return;
        }

        if (pos == 1) {
            n.next = head;
            head.prev = n;
            head = n;
            return;
        }

        Book p = head;

        for (int i = 1; i < pos - 1 && p.next != null; i++)
            p = p.next;

        n.next = p.next;
        n.prev = p;

        if (p.next != null)
            p.next.prev = n;
        else
            tail = n;

        p.next = n;
    }

    static void delete() {
        System.out.print("Book ID: ");
        int id = sc.nextInt();

        Book p = head;

        while (p != null && p.id != id)
            p = p.next;

        if (p == null) {
            System.out.println("Not found");
            return;
        }

        if (p.prev != null)
            p.prev.next = p.next;
        else
            head = p.next;

        if (p.next != null)
            p.next.prev = p.prev;
        else
            tail = p.prev;

        System.out.println("Deleted");
    }

    static void search() {
        sc.nextLine();

        System.out.println("1.Title 2.Author");
        int ch = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter search value: ");
        String s = sc.nextLine();

        Book p = head;
        boolean found = false;

        while (p != null) {
            if ((ch == 1 && p.title.equalsIgnoreCase(s)) ||
                (ch == 2 && p.author.equalsIgnoreCase(s))) {

                System.out.println(p.id + " " + p.title +
                        " " + p.author);
                found = true;
            }

            p = p.next;
        }

        if (!found)
            System.out.println("Not found");
    }

    static void update() {
        System.out.print("Book ID: ");
        int id = sc.nextInt();

        Book p = head;

        while (p != null) {
            if (p.id == id) {
                System.out.print("Available (true/false): ");
                p.available = sc.nextBoolean();
                System.out.println("Updated");
                return;
            }
            p = p.next;
        }

        System.out.println("Not found");
    }

    static void forward() {
        Book p = head;

        while (p != null) {
            System.out.println(p.id + " " + p.title +
                    " " + p.author + " " + p.available);
            p = p.next;
        }
    }

    static void reverse() {
        Book p = tail;

        while (p != null) {
            System.out.println(p.title);
            p = p.prev;
        }
    }

    static void count() {
        int c = 0;
        Book p = head;

        while (p != null) {
            c++;
            p = p.next;
        }

        System.out.println("Total Books: " + c);
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1.Add Beginning");
            System.out.println("2.Add End");
            System.out.println("3.Add Position");
            System.out.println("4.Delete");
            System.out.println("5.Search");
            System.out.println("6.Update Availability");
            System.out.println("7.Forward Display");
            System.out.println("8.Reverse Display");
            System.out.println("9.Count Books");
            System.out.println("10.Exit");

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
                case 6: update(); break;
                case 7: forward(); break;
                case 8: reverse(); break;
                case 9: count(); break;
                case 10: return;
                default: System.out.println("Invalid choice");
            }
        }
    }
}