/*
 * Activity 2.5.2
 *
 * A Board class the PhraseSolverGame
 */
import java.util.Scanner;
import java.io.File;

public class  Board
{
  private String solvedPhrase;
  private String phrase;
  private int currentLetterValue; 

  /* your code here - constructor(s) */ 
  public Board()
  {
    solvedPhrase = "";
    phrase = loadPhrase();
    setLetterValue();
    System.out.println("Phrase: " + phrase); // test code
  }

  /* your code here - accessor(s) */
  public String getPhrase()
  {
    return phrase;
  }

  public String getSolvedPhrase()
  {
    return solvedPhrase;
  }

  public int getLetterValue()
  {
    return currentLetterValue;
  }
  
  /* your code here - mutator(s)  */


  /* ---------- provided code, do not modify ---------- */
  public void setLetterValue()
  {
    int randomInt = (int) ((Math.random() * 10) + 1) * 100;    
    currentLetterValue = randomInt;
  }

  public boolean isSolved(String guess)
  {
    if (phrase.equals(guess))
    {
      return true;
    }
    return false;
  }

  private String loadPhrase()
  {
    String tempPhrase = "";
    
    int numOfLines = 0;
    try 
    {
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
		int randomInt = (int) ((Math.random() * numOfLines) + 1);
    
    try 
    {
      int count = 0;
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt)
        {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
    for (int i = 0; i < tempPhrase.length(); i++)
    {
      if (tempPhrase.substring(i, i + 1).equals(" "))
      {
        solvedPhrase += "  ";
      }  
      else
      {
        solvedPhrase += "_ ";
      }
    }  
    
    return tempPhrase;
  }  

  /** Checks if each letter in phrase is equal to guessed letter
   * 
   * Precondition:
   *  String parameter length == 1
   *  phrase exists 
   * Postcondition
   *  solvedPhrase is updated to include all occurences of parameter guess in phrase
   *  returns boolean depending on if phrase contains guess
   */
  public boolean guessLetter(String guess)
  {
    // Declare and initialize variables
    boolean foundLetter = false;
    String newSolvedPhrase = "";
    
    // Iterate through each letter in phrase
    for (int i = 0; i < phrase.length(); i++)
    {
      // Check if letter in phrase is equal to guessed letter
      if (phrase.substring(i, i + 1).equals(guess))
      {
        // Add guess to newSolvedPhrase
        newSolvedPhrase += guess + " ";
        // Set foundLetter to true
        foundLetter = true;
      }
      else
      {
        // Keep what is already in solvedPhrase
        newSolvedPhrase += solvedPhrase.substring(i * 2, i * 2 + 1) + " ";  
      }
    }
    // Update solvedPhrase
    solvedPhrase = newSolvedPhrase;
    // Return whether the guess is in the phrase
    return foundLetter;
  } 
} 