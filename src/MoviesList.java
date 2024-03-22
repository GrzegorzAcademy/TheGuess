import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MoviesList {
    public ArrayList<String> moves;


    public MoviesList(String pathName) {
        moves = new ArrayList<>();
        File file = new File(pathName);
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                moves.add(sc.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("file with the given name does not exist!! ");
        }

    }

    public String getRandomFilm() {
        int randomIndexMove = (int) (Math.random() * moves.size());
        return moves.get(randomIndexMove);
    }
}
