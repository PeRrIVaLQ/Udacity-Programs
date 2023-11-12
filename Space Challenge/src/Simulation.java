import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    public ArrayList<Item> loadItems(String filename) throws FileNotFoundException {
        ArrayList<Item> items = new ArrayList<>();
        File file = new File(filename);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split("=");
            items.add(new Item(parts[0], Integer.parseInt(parts[1])));
        }
        scanner.close(); // Properly close the scanner
        return items;
    }

    // Implement other methods as described in the mission specs...
}
