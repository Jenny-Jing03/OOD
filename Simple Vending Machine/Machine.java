import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Machine implements IMachine {
    Map<String, Inventory> inventories;

    // constructor
    public Machine() {
        this.inventories = new HashMap<>();
    }

    public Machine(List<Inventory> inventories) {
        this.inventories = new HashMap<>();
        for (Inventory inventory : inventories) {
            this.inventories.put(inventory.getProductName(), inventory);
        }
    }

    @Override
    public int buy(String productName, int money) throws IllegalArgumentException {
        productName = productName.toLowerCase();
        if (!this.validProductName(productName))
            throw new IllegalArgumentException(
                    "The machine does not have " + productName + ". Please enter a valid product name.");

        if (!this.validRepository(productName))
            throw new IllegalArgumentException("The repository of " + productName + " is zero.");

        if (!this.enoughMoneyToBuy(productName, money))
            throw new IllegalArgumentException("The money of buying " + productName + " is not enough.");

        Inventory product = this.inventories.get(productName);
        product.sell();

        return this.change(productName, money);
    }

    @Override
    public boolean validProductName(String productName) {
        if (!this.inventories.containsKey(productName))
            return false;
        return true;
    }

    @Override
    /**
     * @param productName valid product name
     */
    public boolean validRepository(String productName) {
        if (this.inventories.get(productName).getRepository() <= 0)
            return false;
        return true;
    }

    @Override
    /**
     * @param productName valid product name
     */
    public boolean enoughMoneyToBuy(String productName, int money) {
        money = money * 25;
        if (this.inventories.get(productName).getPrice() <= money)
            return true;
        return false;
    }

    @Override
    /**
     * @param productName valid product name
     * @param money       > price
     */
    public int change(String productName, int money) {
        money = money * 25;
        return (this.inventories.get(productName).getPrice() - money) / 25;
    }

    public void addNewProduct(Inventory inventory) {
        this.inventories.put(inventory.getProductName(), inventory);
    }

    public void removeProduct(String name) {
        this.inventories.remove(name);
    }

}