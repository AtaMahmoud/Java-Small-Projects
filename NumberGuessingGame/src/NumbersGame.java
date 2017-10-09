import java.util.Scanner;

public class NumbersGame
{
    public static void main(String[] args)
    {
        int randomNumber=(int) (Math.random() *100 +1);
        Scanner intput =new Scanner(System.in);
        boolean gotIt=false;
        int guess = 0;
        System.out.println("I have randomly chosen number between [1-100] , Try to guess it. ");

        for (int i=10 ; i >0 ;i--)
        {
            System.out.println("You Have "+ i +" guess(es) left : " );
            guess=intput.nextInt();

            if(guess>randomNumber)
            {
                System.out.println("It's smaller than " + guess);
            }
            else if(guess<randomNumber)
            {
                System.out.println("It's bigger than " + guess);
            }
            else
            {
                gotIt=true;
                break;
            }
        }
        if(gotIt)
        {
            System.out.println("CORRECT...YOU WIN");
        }
        else
        {
            System.out.println("GAME OVER...The number is " +randomNumber);
        }
    }

}
