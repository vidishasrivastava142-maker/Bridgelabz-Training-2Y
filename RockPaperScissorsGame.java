import java.util.Scanner;

class RockPaperScissorsGame {

    // Method to find the computer's choice
    public static String getComputerChoice() {

        int choice = (int) (Math.random() * 3);

        if (choice == 0) {
            return "Rock";
        } else if (choice == 1) {
            return "Paper";
        } else {
            return "Scissors";
        }
    }

    // Method to find the winner
    public static String findWinner(String playerChoice, String computerChoice) {

        if (playerChoice.equals(computerChoice)) {
            return "Draw";
        }

        if ((playerChoice.equals("Rock") && computerChoice.equals("Scissors"))
                || (playerChoice.equals("Paper") && computerChoice.equals("Rock"))
                || (playerChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
            return "Player";
        }

        return "Computer";
    }

    // Method to calculate winning statistics
    public static String[][] calculateStatistics(int playerWins,
                                                  int computerWins,
                                                  int totalGames) {

        double playerPercentage =
                ((double) playerWins / totalGames) * 100;

        double computerPercentage =
                ((double) computerWins / totalGames) * 100;

        String[][] statistics = new String[2][3];

        statistics[0][0] = "Player";
        statistics[0][1] = String.valueOf(playerWins);
        statistics[0][2] = String.format("%.2f%%", playerPercentage);

        statistics[1][0] = "Computer";
        statistics[1][1] = String.valueOf(computerWins);
        statistics[1][2] = String.format("%.2f%%", computerPercentage);

        return statistics;
    }

    // Method to display game results
    public static void displayResults(String[][] statistics) {

        System.out.println("\nPlayer\tWins\tWinning Percentage");
        System.out.println("----------------------------------------");

        for (int i = 0; i < statistics.length; i++) {
            System.out.println(
                    statistics[i][0] + "\t"
                    + statistics[i][1] + "\t"
                    + statistics[i][2]
            );
        }
    }

    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Take number of games
        System.out.print("Enter number of games: ");
        int numberOfGames = input.nextInt();

        // Validate number of games
        if (numberOfGames <= 0) {
            System.err.println("Invalid number of games.");
            input.close();
            return;
        }

        int playerWins = 0;
        int computerWins = 0;

        // Play multiple games
        for (int game = 1; game <= numberOfGames; game++) {

            System.out.println("\nGame " + game);
            System.out.print("Enter Rock, Paper, or Scissors: ");

            String playerChoice = input.next();

            // Validate player's choice
            if (!playerChoice.equalsIgnoreCase("Rock")
                    && !playerChoice.equalsIgnoreCase("Paper")
                    && !playerChoice.equalsIgnoreCase("Scissors")) {

                System.err.println("Invalid choice. Please enter Rock, Paper, or Scissors.");
                game--;
                continue;
            }

            // Convert choice to proper format
            playerChoice = playerChoice.substring(0, 1).toUpperCase()
                    + playerChoice.substring(1).toLowerCase();

            // Get computer choice
            String computerChoice = getComputerChoice();

            // Find winner
            String winner = findWinner(playerChoice, computerChoice);

            // Display game result
            System.out.println("Player Choice: " + playerChoice);
            System.out.println("Computer Choice: " + computerChoice);
            System.out.println("Winner: " + winner);

            // Update scores
            if (winner.equals("Player")) {
                playerWins++;
            } else if (winner.equals("Computer")) {
                computerWins++;
            }
        }

        // Calculate statistics
        String[][] statistics =
                calculateStatistics(playerWins, computerWins, numberOfGames);

        // Display statistics
        displayResults(statistics);

        // Close Scanner object
        input.close();
    }
}