import java.util.Scanner;

class SimpleInterest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double principal = sc.nextDouble();
        double rate = sc.nextDouble();
        double time = sc.nextDouble();

        double simpleInterest = (principal * rate * time) / 100;

        System.out.println(simpleInterest);
    }
}