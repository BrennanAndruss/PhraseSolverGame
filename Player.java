/*
 * Activity 2.5.2
 * 
 * A Player class the PhraseSolverGame
 */
import java.util.Scanner;

public class Player
{
  /* your code here - attributes */
  private String name;
  private int score = 0;

  /* your code here - constructor(s) */ 
  public Player()
  {
    System.out.println("Enter Player Name: ");
    Scanner sc = new Scanner(System.in);
    name = sc.nextLine();
    score = 0;
    System.out.println("Welcome to the game, " + name);
  }

  public Player(String inputName)
  {
    name = inputName;
    score = 0;
    System.out.println("Welcome to the game, " + name);
  }

  /* your code here - accessor(s) */ 
  public String getName()
  {
    return name;
  }

  public int getScore()
  {
    return score;
  }

  /* your code here - mutator(s) */ 
  public void setName(String name)
  {
    this.name = name;
  }

  public void addScore(int points)
  {
    score += points;
  }
}