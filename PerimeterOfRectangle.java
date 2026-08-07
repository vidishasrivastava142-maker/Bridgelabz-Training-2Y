import java.util.Scanner;

class PerimeterOfRectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double length = sc.nextDouble();
        double width = sc.nextDouble();

        double perimeter = 2 * (length + width);

        System.out.println(perimeter);
    }
}