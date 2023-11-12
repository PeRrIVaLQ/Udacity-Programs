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
            String[] parts = line.split(",");
            items.add(new Item(parts[0], Integer.parseInt(parts[1])));
        }
        scanner.close();
        return items;
    }

    public ArrayList<Rocket> loadU1(ArrayList<Item> items) {
        ArrayList<Rocket> rockets = new ArrayList<>();

        for (Item item : items) {
            Rocket rocket = new U1();
            while (!rocket.canCarry(item)) {
                rockets.add(rocket);
                rocket = new U1();
            }
            rocket.carry(item);
            rockets.add(rocket);
        }

        return rockets;
    }


    public ArrayList<Rocket> loadU2(ArrayList<Item> items) {
        ArrayList<Rocket> rockets = new ArrayList<>();

        for (Item item : items) {
            Rocket rocket = new U2(); // Create a new U1 rocket for each item
            while (!rocket.canCarry(item)) {
                rockets.add(rocket); // Add full rocket to the fleet
                rocket = new U2(); // Create a new U1 rocket
            }
            rocket.carry(item); // Carry the item
            rockets.add(rocket); // Add the rocket to the fleet
        }

        return rockets;
    }


    public long runSimulation(ArrayList<Rocket> rockets) {
        long totalBudget = 0;
        for (Rocket rocket : rockets) {
            System.out.println("Launching rocket...");
            boolean launchSuccess = rocket.launch();
            boolean landSuccess = rocket.land();

            if (!(launchSuccess && landSuccess)) {
                totalBudget += rocket.getCost();
                System.out.println("Rocket failed to launch or land. New rocket created. Cost: " + rocket.getCost());
                totalBudget += rocket.getCost(); // Add cost of the new rocket
            } else {
                System.out.println("Rocket successfully launched and landed.");
            }
        }
        return totalBudget;
    }

}
