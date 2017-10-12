import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOperations
{
    //Fileds

    File moviesFile;
    ArrayList<String> moviesList;

    //Methods
    FileOperations()
    {
        moviesFile=new File("movies.txt");
        moviesList=new ArrayList<>();
    }
    private void readingMoviesFromFile() throws FileNotFoundException
    {
        Scanner fileInput = new Scanner(moviesFile);

        while (fileInput.hasNextLine())
        {
            moviesList.add(fileInput.nextLine());
        }

    }

    public String PickRandomMovie()throws FileNotFoundException
    {
        readingMoviesFromFile();
        int movieNumber=(int)(Math.random()*26);
        return moviesList.get(movieNumber);
    }


}
