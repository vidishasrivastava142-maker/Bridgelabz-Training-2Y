import java.util.Scanner;

class Movie {
    String title, director;
    int year;
    double rating;
    Movie next, prev;

    Movie(String t, String d, int y, double r) {
        title = t;
        director = d;
        year = y;
        rating = r;
    }
}

public class Main {
    static Movie head = null, tail = null;
    static Scanner sc = new Scanner(System.in);

    static void add(int pos) {
        sc.nextLine();

        System.out.print("Title: ");
        String t = sc.nextLine();

        System.out.print("Director: ");
        String d = sc.nextLine();

        System.out.print("Year: ");
        int y = sc.nextInt();

        System.out.print("Rating: ");
        double r = sc.nextDouble();

        Movie n = new Movie(t, d, y, r);

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

        Movie p = head;
        int i = 1;

        while (i < pos - 1 && p.next != null) {
            p = p.next;
            i++;
        }

        n.next = p.next;
        n.prev = p;

        if (p.next != null)
            p.next.prev = n;
        else
            tail = n;

        p.next = n;
    }

    static void delete() {
        sc.nextLine();
        System.out.print("Enter title: ");
        String t = sc.nextLine();

        Movie p = head;

        while (p != null && !p.title.equalsIgnoreCase(t))
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
        System.out.println("1.Director 2.Rating");
        int ch = sc.nextInt();
        sc.nextLine();

        Movie p = head;

        if (ch == 1) {
            System.out.print("Director: ");
            String d = sc.nextLine();

            while (p != null) {
                if (p.director.equalsIgnoreCase(d))
                    System.out.println(p.title + " " + p.rating);
                p = p.next;
            }
        } else {
            System.out.print("Rating: ");
            double r = sc.nextDouble();

            while (p != null) {
                if (p.rating == r)
                    System.out.println(p.title);
                p = p.next;
            }
        }
    }

    static void update() {
        sc.nextLine();
        System.out.print("Enter title: ");
        String t = sc.nextLine();

        Movie p = head;

        while (p != null) {
            if (p.title.equalsIgnoreCase(t)) {
                System.out.print("New rating: ");
                p.rating = sc.nextDouble();
                System.out.println("Updated");
                return;
            }
            p = p.next;
        }

        System.out.println("Not found");
    }

    static void displayForward() {
        Movie p = head;

        while (p != null) {
            System.out.println(p.title + " " + p.director +
                    " " + p.year + " " + p.rating);
            p = p.next;
        }
    }

    static void displayReverse() {
        Movie p = tail;

        while (p != null) {
            System.out.println(p.title);
            p = p.prev;
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1.Add Beginning");
            System.out.println("2.Add End");
            System.out.println("3.Add Position");
            System.out.println("4.Delete");
            System.out.println("5.Search");
            System.out.println("6.Forward Display");
            System.out.println("7.Reverse Display");
            System.out.println("8.Update Rating");
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
                case 5: search(); break;
                case 6: displayForward(); break;
                case 7: displayReverse(); break;
                case 8: update(); break;
                case 9: return;
                default: System.out.println("Invalid choice");
            }
        }
    }
}