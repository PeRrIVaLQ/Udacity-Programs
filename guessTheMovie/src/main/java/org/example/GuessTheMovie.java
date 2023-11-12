package org.example;
import java.util.Scanner;
import java.util.Random;

public class GuessTheMovie {
    // Lista tytułów filmów
    private static final String[] movies = {
            "Interstellar",
            "Inception",
            "The Matrix",
            "Gladiator",
            "Titanic"
    };

    // Metoda do wyświetlania listy filmów
    public static void displayMovieList() {
        for (String movie : movies) {
            System.out.println(movie);
        }
    }

    // Metoda do losowego wyboru filmu
    public static String pickRandomMovie() {
        Random random = new Random();
        int movieIndex = random.nextInt(movies.length);
        return movies[movieIndex];
    }

    // Metoda do zamiany liter na podkreślenia
    public static String hideMovieTitle(String movie) {
        return movie.replaceAll("[a-zA-Z]", "_");
    }

    // Metoda główna
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String chosenMovie = pickRandomMovie();
        String hiddenTitle = hideMovieTitle(chosenMovie);
        String guessedLetters = "";

        System.out.println("Zgadnij film: " + hiddenTitle);

        int wrongGuesses = 0;
        boolean hasWon = false;

        while (wrongGuesses < 10 && !hasWon) {
            System.out.print("Twoja litera: ");
            String guess = scanner.nextLine().toLowerCase();

            if (guessedLetters.contains(guess)) {
                System.out.println("Tę literę już podałeś!");
                continue;
            }

            guessedLetters += guess;

            if (chosenMovie.toLowerCase().contains(guess)) {
                System.out.println("Dobrze! Litera istnieje.");
                hiddenTitle = updateHiddenTitle(chosenMovie, hiddenTitle, guess);
                System.out.println("Zgadnij film: " + hiddenTitle);
            } else {
                wrongGuesses++;
                System.out.println("Nieprawidłowa litera. Pozostało prób: " + (10 - wrongGuesses));
            }

            hasWon = !hiddenTitle.contains("_");
        }

        if (hasWon) {
            System.out.println("Wygrałeś! Film to: " + chosenMovie);
        } else {
            System.out.println("Przegrałeś. Film to: " + chosenMovie);
        }
    }

        // Metoda aktualizująca ukryty tytuł filmu odkrywając poprawnie zgadnięte litery
    public static String updateHiddenTitle(String movie, String hiddenTitle, String guess) {
        StringBuilder newHiddenTitle = new StringBuilder(hiddenTitle);
        for (int i = 0; i < movie.length(); i++) {
            if (movie.toLowerCase().charAt(i) == guess.charAt(0)) {
                newHiddenTitle.setCharAt(i, movie.charAt(i));
            }
        }
        return newHiddenTitle.toString();
    }
}
