import java.io.File;
import java.util.Scanner;

public class WordsCounter
{
    public static void main(String [] args) throws Exception
    {
        File file = new File("1342-0.txt");
        Scanner input = new Scanner(file);
        int words=0;

        while(input.hasNext())
        {
            String line=input.nextLine();
            words+=line.split(" ").length;
        }

        System.out.println("The File Contain "+words + " words");
    }
}
