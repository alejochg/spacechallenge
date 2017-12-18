public class Rocket implements SpaceShip{
    private int weight;
    private int weightLimit;

    public boolean launch() {
        return true;
    }

    public boolean land() {
        return true;
    }

    public final boolean canCarry(Item item) {
        if(item.weight+this.weight > weightLimit) {
            return false;
        } else
            return true;
    }

    public final void carry(Item item) {
        this.weight += item.weight;
    }
}
