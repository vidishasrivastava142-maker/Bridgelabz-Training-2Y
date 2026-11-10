import java.util.Scanner;

class Node {
    String text;
    Node next, prev;

    Node(String t) {
        text = t;
    }
}

public class Main {
    static Node head = null, tail = null, current = null;
    static int count = 0;
    static final int LIMIT = 10;

    static Scanner sc = new Scanner(System.in);

    static void addState() {
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        Node n = new Node(text);

        if (head == null) {
            head = tail = current = n;
            count++;
            return;
        }

        // Remove redo history
        current.next = null;
        tail = current;

        n.prev = current;
        current.next = n;
        current = n;
        tail = n;

        count++;

        // Maintain maximum 10 states
        if (count > LIMIT) {
            head = head.next;
            head.prev = null;
            count--;
        }
    }

    static void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo successful");
        } else {
            System.out.println("Nothing to undo");
        }
    }

    static void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo successful");
        } else {
            System.out.println("Nothing to redo");
        }
    }

    static void display() {
        if (current == null)
            System.out.println("Empty text");
        else
            System.out.println("Current Text: " + current.text);
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1.Add Text");
            System.out.println("2.Undo");
            System.out.println("3.Redo");
            System.out.println("4.Display Current Text");
            System.out.println("5.Exit");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1: addState(); break;
                case 2: undo(); break;
                case 3: redo(); break;
                case 4: display(); break;
                case 5: return;
                default: System.out.println("Invalid choice");
            }
        }
    }
}