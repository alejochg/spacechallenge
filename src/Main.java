public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        System.out.println("Loading items for phase 1");
        simulation.loadItems("phase-1.txt");
        System.out.println("Loading items for phase 2");
        simulation.loadItems("phase-2.txt");

        /*for(Item item: simulation.items){
            System.out.println(item.name + " = " + item.weight);
        }*/
        /*simulation.loadU1(simulation.items);
        for(Rocket rocket: simulation.rockets) {
            System.out.println(rocket.weight);
        }*/
        simulation.loadU2(simulation.items);
        /*System.out.println(simulation.rockets.size() + " rocket(s) were needed.");
        for(Rocket rocket: simulation.rockets) {
            System.out.println(rocket.weight);
        }*/

        System.out.println("Our fleet consists of " + simulation.rockets.size() + " rockets.");
        int totalMoneys = simulation.runSimulation(simulation.rockets);
        System.out.println("Total budget required: $" + totalMoneys + " millions.");
    }
}
