import java.util.Scanner;

class Item {
    int id, quantity;
    String name;
    double price;
    Item next;

    Item(int i, String n, int q, double p) {
        id = i;
        name = n;
        quantity = q;
        price = p;
    }
}

public class Main {
    static Item head = null;
    static Scanner sc = new Scanner(System.in);

    static void add(int pos) {
        System.out.print("Item ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Item Name: ");
        String name = sc.nextLine();

        System.out.print("Quantity: ");
        int q = sc.nextInt();

        System.out.print("Price: ");
        double price = sc.nextDouble();

        Item n = new Item(id, name, q, price);

        if (pos == 1) {
            n.next = head;
            head = n;
            return;
        }

        Item p = head;

        for (int i = 1; i < pos - 1 && p != null; i++)
            p = p.next;

        if (p == null) {
            System.out.println("Invalid position");
            return;
        }

        n.next = p.next;
        p.next = n;
    }

    static void delete() {
        System.out.print("Item ID: ");
        int id = sc.nextInt();

        if (head == null) return;

        if (head.id == id) {
            head = head.next;
            return;
        }

        Item p = head;

        while (p.next != null && p.next.id != id)
            p = p.next;

        if (p.next == null)
            System.out.println("Not found");
        else
            p.next = p.next.next;
    }

    static void update() {
        System.out.print("Item ID: ");
        int id = sc.nextInt();

        Item p = head;

        while (p != null) {
            if (p.id == id) {
                System.out.print("New quantity: ");
                p.quantity = sc.nextInt();
                System.out.println("Updated");
                return;
            }
            p = p.next;
        }

        System.out.println("Not found");
    }

    static void search() {
        System.out.println("1.Search by ID");
        System.out.println("2.Search by Name");

        int ch = sc.nextInt();
        sc.nextLine();

        Item p = head;

        if (ch == 1) {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            while (p != null) {
                if (p.id == id) {
                    System.out.println(p.name + " " + p.quantity);
                    return;
                }
                p = p.next;
            }
        } else {
            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            while (p != null) {
                if (p.name.equalsIgnoreCase(name)) {
                    System.out.println(p.id + " " + p.price);
                    return;
                }
                p = p.next;
            }
        }

        System.out.println("Not found");
    }

    static void totalValue() {
        double total = 0;
        Item p = head;

        while (p != null) {
            total += p.price * p.quantity;
            p = p.next;
        }

        System.out.println("Total Inventory Value: " + total);
    }

    static void sort(int choice) {
        for (Item i = head; i != null; i = i.next) {
            for (Item j = i.next; j != null; j = j.next) {

                boolean swap = false;

                if (choice == 1)
                    swap = i.name.compareToIgnoreCase(j.name) > 0;

                if (choice == 2)
                    swap = i.price > j.price;

                if (choice == 3)
                    swap = i.price < j.price;

                if (swap) {
                    int id = i.id;
                    i.id = j.id;
                    j.id = id;

                    String name = i.name;
                    i.name = j.name;
                    j.name = name;

                    int q = i.quantity;
                    i.quantity = j.quantity;
                    j.quantity = q;

                    double price = i.price;
                    i.price = j.price;
                    j.price = price;
                }
            }
        }

        display();
    }

    static void display() {
        Item p = head;

        while (p != null) {
            System.out.println(p.id + " " + p.name +
                    " " + p.quantity + " " + p.price);
            p = p.next;
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1.Add Beginning");
            System.out.println("2.Add End");
            System.out.println("3.Add Position");
            System.out.println("4.Delete");
            System.out.println("5.Update Quantity");
            System.out.println("6.Search");
            System.out.println("7.Total Value");
            System.out.println("8.Sort by Name");
            System.out.println("9.Sort by Price Ascending");
            System.out.println("10.Sort by Price Descending");
            System.out.println("11.Display");
            System.out.println("12.Exit");

            int ch = sc.nextInt();

            switch (ch) {
                case 1: add(1); break;
                case 2: add(Integer.MAX_VALUE); break;
                case 3:
                    System.out.print("Position: ");
                    add(sc.nextInt());
                    break;
                case 4: delete(); break;
                case 5: update(); break;
                case 6: search(); break;
                case 7: totalValue(); break;
                case 8: sort(1); break;
                case 9: sort(2); break;
                case 10: sort(3); break;
                case 11: display(); break;
                case 12: return;
                default: System.out.println("Invalid choice");
            }
        }
    }
}