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
        System.out.println("Zgadnij film: " + hiddenTitle);

        int wrongGuesses = 0;
        boolean hasWon = false;

        while (wrongGuesses < 10 && !hasWon) {
            System.out.print("Twoja litera: ");
            String guess = scanner.nextLine().toLowerCase();

            if (guess.length() == 1 && chosenMovie.toLowerCase().contains(guess)) {
                System.out.println("Dobrze! Litera istnieje.");
                // Logika odkrywania liter
            } else {
                wrongGuesses++;
                System.out.println("Nieprawidłowa litera. Pozostało prób: " + (10 - wrongGuesses));
            }

            // Logika sprawdzania, czy użytkownik zgadł wszystkie litery
        }

        if (hasWon) {
            System.out.println("Wygrałeś!");
        } else {
            System.out.println("Przegrałeś. Film to: " + chosenMovie);
        }
    }
}
