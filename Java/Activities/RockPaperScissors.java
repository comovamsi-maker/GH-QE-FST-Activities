package Activity;

import java.util.Scanner;
import java.util.Random;

// Custom Exception
class InvalidMoveException extends Exception {
    public InvalidMoveException(String message) {
        super(message);
    }
}

// Game Class
class Game {

    String playerName;
    String[] moves = {"Rock", "Paper", "Scissors"};

    Game(String playerName) {
        this.playerName = playerName;
    }

    // Generate system move
    public String generateSystemMove() {
        Random rand = new Random();
        return moves[rand.nextInt(3)];
    }

    // Validate player move
    public void validateMove(String move) throws InvalidMoveException {
        if (!(move.equalsIgnoreCase("Rock") ||
              move.equalsIgnoreCase("Paper") ||
              move.equalsIgnoreCase("Scissors"))) {

            throw new InvalidMoveException("Invalid Move! Enter Rock, Paper, or Scissors.");
        }
    }

    // Decide winner
    public void decideWinner(String playerMove, String systemMove) {

        System.out.println("System Move: " + systemMove);

        if (playerMove.equalsIgnoreCase(systemMove)) {
            System.out.println("Result: Draw");
        }
        else if (playerMove.equalsIgnoreCase("Rock") && systemMove.equals("Scissors") ||
                 playerMove.equalsIgnoreCase("Paper") && systemMove.equals("Rock") ||
                 playerMove.equalsIgnoreCase("Scissors") && systemMove.equals("Paper")) {

            System.out.println(playerName + " Wins!");
        }
        else {
            System.out.println("System Wins!");
        }
    }
}

// Main Class
public class RockPaperScissors {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Player Name: ");
        String name = sc.nextLine();

        Game game = new Game(name);

        try {
            System.out.print("Enter Rock, Paper or Scissors: ");
            String playerMove = sc.nextLine();

            game.validateMove(playerMove);

            String systemMove = game.generateSystemMove();

            game.decideWinner(playerMove, systemMove);
        }
        catch (InvalidMoveException e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            sc.close();
            System.out.println("Game Finished");
        }
    }
}