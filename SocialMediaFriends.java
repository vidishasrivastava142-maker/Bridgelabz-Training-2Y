import java.util.*;

class User {
    int id, age;
    String name;
    ArrayList<Integer> friends = new ArrayList<>();
    User next;

    User(int i, String n, int a) {
        id = i;
        name = n;
        age = a;
    }
}

public class Main {
    static User head = null;
    static Scanner sc = new Scanner(System.in);

    static User find(int id) {
        User p = head;

        while (p != null) {
            if (p.id == id)
                return p;

            p = p.next;
        }

        return null;
    }

    static void addUser() {
        System.out.print("User ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (find(id) != null) {
            System.out.println("User already exists");
            return;
        }

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Age: ");
        int age = sc.nextInt();

        User n = new User(id, name, age);

        if (head == null)
            head = n;
        else {
            User p = head;
            while (p.next != null)
                p = p.next;

            p.next = n;
        }
    }

    static void addFriend() {
        System.out.print("Enter two User IDs: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        User u1 = find(a);
        User u2 = find(b);

        if (u1 == null || u2 == null || a == b) {
            System.out.println("Invalid users");
            return;
        }

        if (!u1.friends.contains(b)) {
            u1.friends.add(b);
            u2.friends.add(a);
            System.out.println("Friend added");
        } else {
            System.out.println("Already friends");
        }
    }

    static void removeFriend() {
        System.out.print("Enter two User IDs: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        User u1 = find(a);
        User u2 = find(b);

        if (u1 != null && u2 != null) {
            u1.friends.remove(Integer.valueOf(b));
            u2.friends.remove(Integer.valueOf(a));
            System.out.println("Friend removed");
        } else {
            System.out.println("User not found");
        }
    }

    static void mutualFriends() {
        System.out.print("Enter two User IDs: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        User u1 = find(a);
        User u2 = find(b);

        if (u1 == null || u2 == null) {
            System.out.println("User not found");
            return;
        }

        System.out.println("Mutual Friends:");

        for (int id : u1.friends) {
            if (u2.friends.contains(id))
                System.out.println(id);
        }
    }

    static void displayFriends() {
        System.out.print("Enter User ID: ");
        int id = sc.nextInt();

        User u = find(id);

        if (u == null) {
            System.out.println("User not found");
            return;
        }

        System.out.println("Friends: " + u.friends);
    }

    static void search() {
        sc.nextLine();

        System.out.println("Enter Name or ID:");
        String s = sc.nextLine();

        User p = head;

        while (p != null) {
            if (p.name.equalsIgnoreCase(s) ||
                    String.valueOf(p.id).equals(s)) {

                System.out.println(p.id + " " +
                        p.name + " " + p.age);
                return;
            }

            p = p.next;
        }

        System.out.println("Not found");
    }

    static void countFriends() {
        User p = head;

        while (p != null) {
            System.out.println(p.name +
                    " Friends: " + p.friends.size());

            p = p.next;
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1.Add User");
            System.out.println("2.Add Friend");
            System.out.println("3.Remove Friend");
            System.out.println("4.Mutual Friends");
            System.out.println("5.Display Friends");
            System.out.println("6.Search User");
            System.out.println("7.Count Friends");
            System.out.println("8.Exit");

            int ch = sc.nextInt();

            switch (ch) {
                case 1: addUser(); break;
                case 2: addFriend(); break;
                case 3: removeFriend(); break;
                case 4: mutualFriends(); break;
                case 5: displayFriends(); break;
                case 6: search(); break;
                case 7: countFriends(); break;
                case 8: return;
                default: System.out.println("Invalid choice");
            }
        }
    }
}