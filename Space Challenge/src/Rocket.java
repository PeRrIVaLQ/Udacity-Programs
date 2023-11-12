public class Rocket implements SpaceShip {
    int currentWeight;
    int maxWeight;

    public boolean launch() {
        // Implementation based on rocket specifications
        return true;
    }

    public boolean land() {
        // Implementation based on rocket specifications
        return true;
    }

    public boolean canCarry(Item item) {
        return (currentWeight + item.weight) <= maxWeight;
    }

    public void carry(Item item) {
        currentWeight += item.weight;
    }
}
