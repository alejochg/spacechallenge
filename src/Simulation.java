import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Simulation {

    Queue<Item> items = new LinkedList<>();
    Queue<Rocket> rockets = new LinkedList<>();
    int totalBudget = 0;
    boolean successfulLaunch;
    boolean successfulLanding;

    public void loadItems(String pathname) {
        File file = new File(pathname);
        String[] values;
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                Item currentItem = new Item();
                values = scanner.nextLine().split("=");
                currentItem.name = values[0];
                currentItem.weight = Integer.parseInt(values[1]);
                items.add(currentItem);
            }
        } catch(FileNotFoundException e) {
            System.out.println("File does not exist!");
        }
    }

    public void loadU1(Queue<Item> items) {
        rockets.clear();
        while(items.size() >0) {
            U1 u1 = new U1();
            do {
                Item inspectedItem = items.poll();
                if(u1.canCarry(inspectedItem)) {
                    u1.carry(inspectedItem);
                } else {
                    rockets.add(u1);
                    break;
                }
            } while(items.size() >0);
        }
    }
    public void loadU2(Queue<Item> items) {
        rockets.clear();
        while(items.size() >0) {
            U2 u2 = new U2();
            do {
                Item inspectedItem = items.poll();
                if(u2.canCarry(inspectedItem)) {
                    u2.carry(inspectedItem);
                } else {
                    rockets.add(u2);
                    break;
                }
            } while(items.size() >0);
        }
    }

    public int runSimulation(Queue<Rocket> rockets) {
        totalBudget = 0;
        successfulLanding = false;
        successfulLaunch = false;
        int rocketCount = 1;
        while(rockets.size() > 0) {
            Rocket attempt = rockets.poll();
            do {
                totalBudget += attempt.cost;
                successfulLaunch = attempt.launch();
                successfulLanding = attempt.land();
                if(!successfulLaunch) {
                    System.out.println("Rocket " + rocketCount + " has exploded at launch. Retrying with same cargo.");
                } else if(!successfulLanding) {
                    System.out.println("Rocket " + rocketCount + " has crashed at landing. Retrying with same cargo.");
                } else {
                    System.out.println("Rocket " + rocketCount + " has successfully landed!");
                }
            } while(!(successfulLaunch && successfulLanding));
            rocketCount++;
        }
        return totalBudget;
    }
}
