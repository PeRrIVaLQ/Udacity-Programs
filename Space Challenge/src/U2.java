public class U2 extends Rocket {
    public U2() {
        super(18000, 120); // Assuming the cost is 120 million
        this.maxWeight = 29000; // Max weight with cargo
    }

    @Override
    public boolean launch() {
        double launchExplosionProbability = 0.04 * (this.currentWeight / this.maxWeight);
        System.out.println("Launch probability: " + launchExplosionProbability);
        boolean launchResult = Math.random() >= launchExplosionProbability;
        System.out.println("Launch result: " + launchResult);
        return launchResult;
    }

    @Override
    public boolean land() {
        double landingCrashProbability = 0.08 * (this.currentWeight / this.maxWeight);
        System.out.println("Landing probability: " + landingCrashProbability);
        boolean landingResult = Math.random() >= landingCrashProbability;
        System.out.println("Landing result: " + landingResult);
        return landingResult;
    }
}