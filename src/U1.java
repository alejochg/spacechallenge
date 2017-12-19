public class U1 extends Rocket {
    public U1() {
        this.weight = 10000;
        this.weightLimit = 18000;
        this.cost = 100;
    }

    @Override
    public boolean launch() {
        double chance = 0.05 * ((double)weight/weightLimit);
        double random = Math.random();

        if(random <= chance)
            return false;
        else
            return true;
    }

    public boolean land() {
        double chance = 0.01 * ((double)weight/weightLimit);
        double random = Math.random();

        if(random <= chance)
            return false;
        else
            return true;
    }
}
