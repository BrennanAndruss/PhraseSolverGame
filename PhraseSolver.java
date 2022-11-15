/*
 * Activity 2.5.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;
  
public class PhraseSolver
{
  /* your code here - attributes */
  private Player player1;
  private Player player2;
  private Board game;
  private boolean solved;

  /* your code here - constructor(s) */ 
  public PhraseSolver()
  {
    player1 = new Player();
    player2 = new Player();
    game = new Board();
    solved = false;
  }

  /* your code here - accessor(s) */
  
  /* your code here - mutator(s)  */

  public void play()
  {
    boolean solved = false;
    int currentPlayer = 0;
    String guess = "";

    Scanner input = new Scanner(System.in);
    
    boolean correct = true;
    while (!solved) 
    {
      
      /* your code here - game logic */
      // Prompt current player to make a guess
      System.out.println("Solved phrase: " + game.getSolvedPhrase());
      System.out.println("Current player: Player " + (currentPlayer + 1));
      System.out.println("Make a guess: ");
      guess = input.nextLine();
      
      // Check if the phrase has been guessed or a letter has been guessed
      
      if (game.guessLetter(guess))
      {
        // Award points to current player
        System.out.println("Good guess!");
        game.setLetterValue();
        if (currentPlayer == 0)
        {
          player1.addScore(game.getLetterValue());
        }
        else
        {
          player2.addScore(game.getLetterValue());
        }
      }
      
      /* your code here - determine how game ends */
      // Check if the phrase is solved
      if (game.getSolvedPhrase().indexOf("_") == -1 || game.isSolved(guess))
      {
        // Stop the game
        solved = true;
      }
      else
      {
        // Show status of game
        System.out.println(player1.getName() + ": " + player1.getScore());
        System.out.println(player2.getName() + ": " + player2.getScore());
        System.out.println();
        // Change players
        currentPlayer = (currentPlayer + 1) % 2;
      }
    }

    System.out.println("Solved phrase: " + game.getSolvedPhrase());

    // Determine the winner
    if (player1.getScore() > player2.getScore())
    {
      System.out.println(player1.getName() + " wins!");
    }
    else if (player2.getScore() > player1.getScore())
    {
      System.out.println(player2.getName() + " wins!");
    }
  }
}