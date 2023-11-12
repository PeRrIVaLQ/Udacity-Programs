public class U1 extends Rocket {
    public U1() {
        super(10000, 100); // Assuming the cost is 100 million
        this.maxWeight = 18000; // Max weight with cargo
    }

    @Override
    public boolean launch() {
        double launchExplosionProbability = 0.05 * (this.currentWeight / this.maxWeight);
        System.out.println("Launch probability: " + launchExplosionProbability);
        boolean launchResult = Math.random() >= launchExplosionProbability;
        System.out.println("Launch result: " + launchResult);
        return launchResult;
    }

    @Override
    public boolean land() {
        double landingCrashProbability = 0.01 * (this.currentWeight / this.maxWeight);
        System.out.println("Landing probability: " + landingCrashProbability);
        boolean landingResult = Math.random() >= landingCrashProbability;
        System.out.println("Landing result: " + landingResult);
        return landingResult;
    }
}