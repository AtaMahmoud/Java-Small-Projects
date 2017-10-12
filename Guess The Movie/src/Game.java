import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game
{
    int staringScore;
    int wrongGuesses;
    String [] movieName;
    String randomMovieName;
    String correctMovieName;
    FileOperations randomMoviePicker;

    public Game() throws FileNotFoundException
    {
        randomMoviePicker=new FileOperations();
        randomMovieName =randomMoviePicker.PickRandomMovie().replaceAll("\\s","").toLowerCase();
        movieName=new String[randomMovieName.length()];
        correctMovieName =randomMovieName;
        staringScore=10;
        wrongGuesses=0;
    }

    public void view()
    {
        System.out.println("The Game is About Guessing a Name of Movie which picked up Randomly from file contain some movies");
        System.out.println("Your statring score is 10 point every wrong Guess makes you lost one point");
        System.out.println("Note : the movie Name doesn't Contain any White Spaces");
        System.out.print("Yor are guessing : ");
        for (int i=0;i<randomMovieName.length();i++)
        {
            movieName[i]="_";
            System.out.print("_ ");
        }
        System.out.println();
        System.out.println("You Have "+wrongGuesses+" Wrong Letters : ");




    }

    public void gameLogic()
    {

        view();
        Scanner userInput = new Scanner(System.in);
        String userGuess;
        String wrongCharacters="";
        int userGuessLetterIndex;
        String comparisonName="";
        while (staringScore!= wrongGuesses)
        {
            comparisonName= String.join("",movieName);
            if(correctMovieName.equals(comparisonName))
            {
                PrintResutlt(true);
                break;
            }

            System.out.print("Guess a letter : ");
            userGuess= userInput.next();


            if(randomMovieName.contains(userGuess))
            {
                userGuessLetterIndex=randomMovieName.indexOf(userGuess);
                movieName[userGuessLetterIndex]=userGuess;
                randomMovieName= CharReplacer(randomMovieName,userGuessLetterIndex);


                System.out.println("You Have "+wrongGuesses+" Wrong Letters :"+wrongCharacters);
                System.out.print("Yor are guessing : ");
                for (String movieLetter:movieName)
                {
                    System.out.print(movieLetter+" ");
                }
                System.out.println();

            }
            else
            {
                wrongGuesses++;
                wrongCharacters = wrongCharacters +" "+userGuess;
                System.out.println("You Have "+wrongGuesses+" Wrong Letters :" +wrongCharacters);
                System.out.print("Yor are guessing : ");
                for (String movieLetter:movieName)
                {
                    System.out.print(movieLetter+" ");
                }
                System.out.println();
            }
        }
        if(staringScore==wrongGuesses)
        {
            PrintResutlt(false);
        }
    }

    private void PrintResutlt(boolean result)
    {
        if(result)
        {
            System.out.println("You Win!");
            System.out.println("You Have Guessed '"+correctMovieName+"' Correctly.");
        }
        else
        {
            System.out.println("You Lose!");
            System.out.println("You couldn't Guess '"+correctMovieName+"' Correctly.");
        }
    }

    private static String CharReplacer(String movie, int index)
    {

        char [] movieChar=movie.toCharArray();
        movieChar[index]='_';
        return String.valueOf(movieChar);
    }

}
