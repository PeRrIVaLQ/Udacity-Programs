public class Rocket implements SpaceShip {
    int currentWeight;
    int maxWeight;
    double cost;

    public Rocket(int weight, int cost) {
        currentWeight = weight;
        maxWeight = weight; // This should later be updated to include cargo weight if necessary
        this.cost = cost;
    }

    public boolean launch() {

        double launchExplosionProbability = 0.05 * (currentWeight / (double)maxWeight);
        return Math.random() >= launchExplosionProbability;
    }

    public boolean land() {

        double landingCrashProbability = 0.01 * (currentWeight / (double)maxWeight);
        return Math.random() >= landingCrashProbability;
    }

    public boolean canCarry(Item item) {
        return (currentWeight + item.weight) <= maxWeight;
    }

    public void carry(Item item) {
        currentWeight += item.weight;
    }

    public double getCost() {
        return this.cost;
    }

}
