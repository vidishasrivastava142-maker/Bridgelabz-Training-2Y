import java.util.Scanner;

class Process {
    int id, burst, remaining, priority;
    int completion;
    Process next;

    Process(int i, int b, int p) {
        id = i;
        burst = b;
        remaining = b;
        priority = p;
    }
}

public class Main {
    static Process head = null, tail = null;
    static Scanner sc = new Scanner(System.in);

    static void add() {
        System.out.print("Process ID: ");
        int id = sc.nextInt();

        System.out.print("Burst Time: ");
        int b = sc.nextInt();

        System.out.print("Priority: ");
        int p = sc.nextInt();

        Process n = new Process(id, b, p);

        if (head == null) {
            head = tail = n;
            n.next = head;
        } else {
            tail.next = n;
            tail = n;
            tail.next = head;
        }
    }

    static void display() {
        if (head == null) {
            System.out.println("No processes");
            return;
        }

        Process p = head;

        do {
            System.out.println("P" + p.id +
                    " Remaining: " + p.remaining);
            p = p.next;
        } while (p != head);
    }

    static void schedule() {
        if (head == null) {
            System.out.println("No processes");
            return;
        }

        System.out.print("Enter Time Quantum: ");
        int quantum = sc.nextInt();

        if (quantum <= 0) {
            System.out.println("Invalid quantum");
            return;
        }

        int total = 0;
        int count = 0;

        Process p = head;

        do {
            total += p.burst;
            count++;
            p = p.next;
        } while (p != head);

        int[] waiting = new int[count];
        int[] turnaround = new int[count];

        int time = 0;

        while (head != null) {
            Process prev = tail;
            p = head;

            boolean roundDone = true;

            do {
                if (p.remaining > 0) {
                    roundDone = false;

                    int execute = Math.min(quantum, p.remaining);

                    p.remaining -= execute;
                    time += execute;

                    if (p.remaining == 0) {
                        p.completion = time;

                        int index = p.id - 1;

                        if (index >= 0 && index < count) {
                            turnaround[index] = time;
                            waiting[index] = time - p.burst;
                        }

                        System.out.println("P" + p.id + " completed");

                        if (head == tail) {
                            head = tail = null;
                            break;
                        }

                        if (p == head)
                            head = head.next;

                        if (p == tail)
                            tail = prev;

                        prev.next = p.next;

                        p = prev.next;
                        continue;
                    }
                }

                prev = p;
                p = p.next;

            } while (p != head);

            if (head != null) {
                System.out.println("After round:");
                display();
            }

            if (roundDone)
                break;
        }

        double avgWait = 0, avgTurn = 0;

        for (int i = 0; i < count; i++) {
            avgWait += waiting[i];
            avgTurn += turnaround[i];
        }

        System.out.println("Average Waiting Time: " +
                avgWait / count);

        System.out.println("Average Turnaround Time: " +
                avgTurn / count);
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1.Add Process");
            System.out.println("2.Display");
            System.out.println("3.Execute Scheduling");
            System.out.println("4.Exit");

            int ch = sc.nextInt();

            switch (ch) {
                case 1: add(); break;
                case 2: display(); break;
                case 3: schedule(); break;
                case 4: return;
                default: System.out.println("Invalid choice");
            }
        }
    }
}