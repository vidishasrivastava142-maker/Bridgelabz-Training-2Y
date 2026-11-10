import java.util.Scanner;

class Ticket {
    int id, seat;
    String customer, movie, time;
    Ticket next;

    Ticket(int i, String c, String m, int s, String t) {
        id = i;
        customer = c;
        movie = m;
        seat = s;
        time = t;
    }
}

public class Main {
    static Ticket head = null, tail = null;
    static Scanner sc = new Scanner(System.in);

    static void add() {
        System.out.print("Ticket ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Customer Name: ");
        String c = sc.nextLine();

        System.out.print("Movie Name: ");
        String m = sc.nextLine();

        System.out.print("Seat Number: ");
        int s = sc.nextInt();
        sc.nextLine();

        System.out.print("Booking Time: ");
        String t = sc.nextLine();

        Ticket n = new Ticket(id, c, m, s, t);

        if (head == null) {
            head = tail = n;
            n.next = head;
        } else {
            tail.next = n;
            tail = n;
            tail.next = head;
        }

        System.out.println("Ticket Booked");
    }

    static void delete() {
        if (head == null) {
            System.out.println("No tickets");
            return;
        }

        System.out.print("Ticket ID: ");
        int id = sc.nextInt();

        Ticket p = head, prev = tail;

        do {
            if (p.id == id) {

                if (head == tail) {
                    head = tail = null;
                } else {
                    prev.next = p.next;

                    if (p == head)
                        head = p.next;

                    if (p == tail)
                        tail = prev;

                    tail.next = head;
                }

                System.out.println("Ticket Cancelled");
                return;
            }

            prev = p;
            p = p.next;

        } while (p != head);

        System.out.println("Ticket not found");
    }

    static void display() {
        if (head == null) {
            System.out.println("No tickets booked");
            return;
        }

        Ticket p = head;

        do {
            System.out.println("ID: " + p.id);
            System.out.println("Customer: " + p.customer);
            System.out.println("Movie: " + p.movie);
            System.out.println("Seat: " + p.seat);
            System.out.println("Time: " + p.time);

            System.out.println("----------------");

            p = p.next;

        } while (p != head);
    }

    static void search() {
        if (head == null) {
            System.out.println("No tickets");
            return;
        }

        sc.nextLine();

        System.out.println("1.Search by Customer");
        System.out.println("2.Search by Movie");

        int ch = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter name: ");
        String s = sc.nextLine();

        Ticket p = head;
        boolean found = false;

        do {
            if ((ch == 1 && p.customer.equalsIgnoreCase(s)) ||
                (ch == 2 && p.movie.equalsIgnoreCase(s))) {

                System.out.println(p.id + " " +
                        p.customer + " " + p.movie +
                        " Seat: " + p.seat);

                found = true;
            }

            p = p.next;

        } while (p != head);

        if (!found)
            System.out.println("Not found");
    }

    static void count() {
        if (head == null) {
            System.out.println("Total Tickets: 0");
            return;
        }

        int c = 0;
        Ticket p = head;

        do {
            c++;
            p = p.next;
        } while (p != head);

        System.out.println("Total Tickets: " + c);
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1.Book Ticket");
            System.out.println("2.Cancel Ticket");
            System.out.println("3.Display Tickets");
            System.out.println("4.Search Ticket");
            System.out.println("5.Count Tickets");
            System.out.println("6.Exit");

            int ch = sc.nextInt();

            switch (ch) {
                case 1: add(); break;
                case 2: delete(); break;
                case 3: display(); break;
                case 4: search(); break;
                case 5: count(); break;
                case 6: return;
                default: System.out.println("Invalid choice");
            }
        }
    }
}