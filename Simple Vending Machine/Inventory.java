public class Inventory implements IInventory{
    private String name;
    private int price;
    private int repository;

    // constructor
    public Inventory(String productName, int price, int repository){
        productName = productName.toLowerCase();
        this.name = productName;
        this.price = price;
        this.repository = repository;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public int getRepository() {
        return this.repository;
    }

    public String getProductName(){
        return this.name;
    }

    public void sell(){
        this.repository --;
    }

    public void fill(int capacity){
        this.repository += capacity;
    }


}