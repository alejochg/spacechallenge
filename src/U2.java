public class U2 extends Rocket {
    public U2() {
        this.weight = 18000;
        this.weightLimit = 29000;
        this.cost = 120000000;
    }

    @Override
    public boolean launch() {
        double chance = 0.04 * (weight/weightLimit);
        double random = Math.random();

        if(random <= chance)
            return false;
        else
            return true;
    }

    public boolean land() {
        double chance = 0.08 * (weight/weightLimit);
        double random = Math.random();

        if(random <= chance)
            return false;
        else
            return true;
    }
}
