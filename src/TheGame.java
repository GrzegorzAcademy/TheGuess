import java.util.Scanner;

public class TheGame {
    private String movieToGuess;
    private int pointLost;
    private String wrongLetters;
    private String rightLetters;
    private Boolean gameWon;

    public TheGame(String pathName) {
        MoviesList moviesList = new MoviesList(pathName);
        movieToGuess = moviesList.getRandomFilm().trim();
        pointLost = 0;
        wrongLetters = "";
        rightLetters = "";
        gameWon = false;

    }
    public String getWrongLetters() {
        return wrongLetters;
    }
    public String getMoveTitle() {
        return movieToGuess;

    }
    public boolean WonGame() {
        return gameWon;
    }
    private String inputLetter() {
        System.out.println("Enter the letter");
        Scanner sc = new Scanner(System.in);
        String letter = sc.nextLine().toLowerCase();
        if (!letter.matches("[a-z]")) {
            System.out.println("That is not a letter");
            return inputLetter();

        } else if (wrongLetters.contains(letter) || rightLetters.contains(letter)) {
            System.out.println("you have already chosen once");
            return inputLetter();
        } else
            return letter;
    }

    public boolean gameEnd() {
        if (pointLost >= 10) {
            return true;
        }
        if (!getHiddenMoveTitle().contains("_")) {
            gameWon = true;
            return true;
        }
        return false;
    }

    public void guessLetter() {
        String guessedLetter = inputLetter();
        if (movieToGuess.toLowerCase().contains(guessedLetter)) {
            rightLetters += guessedLetter + guessedLetter.toUpperCase();

        } else pointLost++;
        wrongLetters += " " + guessedLetter;
    }

    public String getHiddenMoveTitle() {
        if (rightLetters.equals("")) {
            return movieToGuess.replaceAll("[a-zA-Z]", "_");
        } else
            return movieToGuess.replaceAll("[a-zA-Z&&[^" + rightLetters + "]]", "_");
    }
}

