// Inside Main.java


import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Simulation sim = new Simulation();
        ArrayList<Item> phase1Items = sim.loadItems("src/phase-1.txt");
        ArrayList<Item> phase2Items = sim.loadItems("src/phase-2.txt");

        ArrayList<Rocket> u1Rockets = sim.loadU1(phase1Items);
        ArrayList<Rocket> u2Rockets = sim.loadU2(phase2Items);

        long totalBudgetU1 = sim.runSimulation(u1Rockets);
        long totalBudgetU2 = sim.runSimulation(u2Rockets);

        System.out.println("Total budget for U1 rockets: " + totalBudgetU1);
        System.out.println("Total budget for U2 rockets: " + totalBudgetU2);
    }
}