public class Rocket implements SpaceShip{
    int weight;
    int weightLimit;
    int cost;

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
