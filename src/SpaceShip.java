public interface SpaceShip {
    /**
     * Interface that defines the basic methods that a SpaceShip should support
     */

    /**
     * Method that returns either true or false indicating if the launch was
     * successful or if the rocket has crashed.
     *
     * @return
     */
    boolean launch();

    /**
     * Method that returns either true or false based on the success of landing
     */
    boolean land();

    /**
     * Method that takes an Item as an argument and returns true if the rocket can
     * carry such item or false if it will exceed the weight limit.
     */
    boolean canCarry(Item item);

    /**
     * Method that takes an Item object and updates the current weight of the rocket.
     */
    void carry(Item item);
}
