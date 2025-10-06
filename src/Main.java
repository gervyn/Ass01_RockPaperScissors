import java.util.Scanner;

public class Main {

    enum Move { ROCK, PAPER, SCISSORS }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Rock–Paper–Scissors");
        boolean playAgain;

        do {
            Move a = readMove(in, "Player A");
            Move b = readMove(in, "Player B");


            System.out.printf("Player A: %s, Player B: %s%n", pretty(a), pretty(b));


            printOutcome(a, b);

            playAgain = askYesNo(in, "Play again? [Y/N]: ");

        } while (playAgain);

        System.out.println("Thanks for playing!");
        in.close();
    }

    private static Move readMove(Scanner in, String who) {
        while (true) {
            System.out.printf("%s, enter your move [R/P/S]: ", who);
            String s = in.nextLine().trim();


            if (s.equalsIgnoreCase("R")) return Move.ROCK;
            if (s.equalsIgnoreCase("P")) return Move.PAPER;
            if (s.equalsIgnoreCase("S")) return Move.SCISSORS;

            System.out.println("Invalid input. Please enter R, P, or S.");
        }
    }

    private static boolean askYesNo(Scanner in, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = in.nextLine().trim();
            if (s.equalsIgnoreCase("Y")) return true;
            if (s.equalsIgnoreCase("N")) return false;
            System.out.println("Please enter Y or N.");
        }
    }

    private static String pretty(Move m) {
        switch (m) {
            case ROCK:     return "Rock";
            case PAPER:    return "Paper";
            case SCISSORS: return "Scissors";
            default:       return "";
        }
    }

    private static void printOutcome(Move a, Move b) {
        if (a == b) {
            // Example: Rock vs Rock it's a Tie!
            System.out.printf("%s vs %s — it's a Tie!%n", pretty(a), pretty(b));
            return;
        }

        switch (a) {
            case ROCK:
                if (b == Move.SCISSORS) {
                    System.out.println("Rock breaks Scissors — Player A wins!");
                } else { // b == PAPER
                    System.out.println("Paper covers Rock — Player B wins!");
                }
                break;

            case PAPER:
                if (b == Move.ROCK) {
                    System.out.println("Paper covers Rock — Player A wins!");
                } else { // b == SCISSORS
                    System.out.println("Scissors cuts Paper — Player B wins!");
                }
                break;

            case SCISSORS:
                if (b == Move.PAPER) {
                    System.out.println("Scissors cuts Paper — Player A wins!");
                } else { // b == ROCK
                    System.out.println("Rock breaks Scissors — Player B wins!");
                }
                break;
        }
    }
}
