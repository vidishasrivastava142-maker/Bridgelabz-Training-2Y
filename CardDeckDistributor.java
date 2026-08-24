import java.util.Scanner;

class CardDeckDistributor {

    public static String[] initializeDeck(String[] suits, String[] ranks) {

        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];

        int index = 0;

        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[index] = ranks[j] + " of " + suits[i];
                index++;
            }
        }

        return deck;
    }

    public static String[] shuffleDeck(String[] deck) {

        int n = deck.length;

        for (int i = 0; i < n; i++) {

            int randomCardNumber =
                    i + (int) (Math.random() * (n - i));

            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }

        return deck;
    }

    public static String[][] distributeCards(
            String[] deck, int numberOfCards, int numberOfPlayers) {

        if (numberOfCards > deck.length) {
            System.out.println("Not enough cards in the deck.");
            return new String[0][0];
        }

        if (numberOfCards % numberOfPlayers != 0) {
            System.out.println(
                    "Cards cannot be equally distributed among players.");
            return new String[0][0];
        }

        int cardsPerPlayer = numberOfCards / numberOfPlayers;

        String[][] players = new String[numberOfPlayers][cardsPerPlayer];

        int index = 0;

        for (int i = 0; i < numberOfPlayers; i++) {

            for (int j = 0; j < cardsPerPlayer; j++) {
                players[i][j] = deck[index];
                index++;
            }
        }

        return players;
    }

    public static void printPlayers(String[][] players) {

        for (int i = 0; i < players.length; i++) {

            System.out.println("\nPlayer " + (i + 1) + ":");

            for (int j = 0; j < players[i].length; j++) {
                System.out.println(players[i][j]);
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] suits = {
            "Hearts", "Diamonds", "Clubs", "Spades"
        };

        String[] ranks = {
            "2", "3", "4", "5", "6", "7", "8", "9",
            "10", "Jack", "Queen", "King", "Ace"
        };

        System.out.print("Enter number of cards to distribute: ");
        int numberOfCards = scanner.nextInt();

        System.out.print("Enter number of players: ");
        int numberOfPlayers = scanner.nextInt();

        if (numberOfPlayers <= 0) {
            System.out.println("Number of players must be greater than 0.");
            scanner.close();
            return;
        }

        String[] deck = initializeDeck(suits, ranks);

        shuffleDeck(deck);

        String[][] players = distributeCards(
                deck, numberOfCards, numberOfPlayers);

        if (players.length > 0) {
            printPlayers(players);
        }

        scanner.close();
    }
}