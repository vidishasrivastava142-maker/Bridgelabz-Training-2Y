import java.util.Scanner;

class EmployeeBonus {
    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Define constants
        int employeeCount = 10;
        double bonusRateAboveFiveYears = 0.05;
        double bonusRateFiveYearsOrLess = 0.02;

        // Create arrays to store salary, years of service, bonus and new salary
        double[] salary = new double[employeeCount];
        double[] yearsOfService = new double[employeeCount];
        double[] bonus = new double[employeeCount];
        double[] newSalary = new double[employeeCount];

        // Variables to store total old salary, total bonus and total new salary
        double totalOldSalary = 0.0;
        double totalBonus = 0.0;
        double totalNewSalary = 0.0;

        // Take input for salary and years of service
        for (int i = 0; i < salary.length; i++) {

            // Take valid salary input
            while (true) {
                System.out.print("Enter salary of employee " + (i + 1) + ": ");
                double employeeSalary = input.nextDouble();

                // Validate salary
                if (employeeSalary > 0) {
                    salary[i] = employeeSalary;
                    break;
                }

                System.err.println("Invalid salary. Please enter a positive value.");
            }

            // Take valid years of service input
            while (true) {
                System.out.print("Enter years of service of employee " + (i + 1) + ": ");
                double serviceYears = input.nextDouble();

                // Validate years of service
                if (serviceYears >= 0) {
                    yearsOfService[i] = serviceYears;
                    break;
                }

                System.err.println("Invalid years of service. Please enter a non-negative value.");
            }
        }

        // Calculate bonus and new salary for each employee
        for (int i = 0; i < salary.length; i++) {

            // Calculate bonus based on years of service
            if (yearsOfService[i] > 5) {
                bonus[i] = salary[i] * bonusRateAboveFiveYears;
            } else {
                bonus[i] = salary[i] * bonusRateFiveYearsOrLess;
            }

            // Calculate new salary
            newSalary[i] = salary[i] + bonus[i];

            // Calculate totals
            totalOldSalary += salary[i];
            totalBonus += bonus[i];
            totalNewSalary += newSalary[i];
        }

        // Display employee salary details
        System.out.println("\nEmployee Salary Details:");

        for (int i = 0; i < salary.length; i++) {
            System.out.println("Employee " + (i + 1));
            System.out.println("Old Salary: " + salary[i]);
            System.out.println("Years of Service: " + yearsOfService[i]);
            System.out.println("Bonus: " + bonus[i]);
            System.out.println("New Salary: " + newSalary[i]);
            System.out.println();
        }

        // Display total salary and bonus details
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total Bonus Payout: " + totalBonus);
        System.out.println("Total New Salary: " + totalNewSalary);

        // Close Scanner object
        input.close();
    }
}