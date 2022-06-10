import java.util.ArrayList;
import java.util.List;

public class VendMachineSimulator {

    public void simulate() {
        // create a inventory list
        List<Inventory> inventories = new ArrayList<>();
        inventories.add(new Inventory("coke", 4 * 25, 10));
        inventories.add(new Inventory("cookies", 6 * 25, 5));
        inventories.add(new Inventory("peanut", 3 * 25, 3));
        inventories.add(new Inventory("nut", 4 * 25, 0));

        Machine machine = new Machine(inventories);

        // normal case
        try {
            int change = machine.buy("coke", 4);
            System.out.println("Buying the " + "coke" + " successfully.\nChanging you " + change + " quarters.");
        } catch (Exception e) {
            System.out.println("Catch unexpected exception");
        }

        // no repository
        try {
            int change = machine.buy("nut", 5);
            System.out.println("Buying the " + "nut" + " successfully.\nChanging you " + change + " quarters.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Catch unexpected exception");
        }

        // upper case product name
        try {
            int change = machine.buy("COKE", 3);
            System.out.println("Buying the " + "coke" + " successfully.\nChanging you " + change + " quarters.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Catch unexpected exception");
        }

        // less money
        try {
            int change = machine.buy("coke", 3);
            System.out.println("Buying the " + "nut" + " successfully.\nChanging you " + change + " quarters.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Catch unexpected exception");
        }

        // invaild product name
        try {
            int change = machine.buy("potato", 3);
            System.out.println("Buying the " + "nut" + " successfully.\nChanging you " + change + " quarters.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Catch unexpected exception");
        }
    }

    public static void main(String[] args){
        VendMachineSimulator simulator = new VendMachineSimulator();
        simulator.simulate();
    }

}