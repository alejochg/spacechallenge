public class U2 extends Rocket {
    public U2() {
        this.weight = 18000;
        this.weightLimit = 29000;
        this.cost = 120;
    }

    @Override
    public boolean launch() {
        double chance = /*0.04 * ((double)weight/weightLimit)*/ 0.4;
        double random = Math.random();

        if(random <= chance)
            return false;
        else
            return true;
    }

    public boolean land() {
        double chance = /*0.08 * ((double)weight/weightLimit)*/ 0.3;
        double random = Math.random();

        if(random <= chance)
            return false;
        else
            return true;
    }
}
