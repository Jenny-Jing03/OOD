public  interface IMachine {
    public int buy(String productName, int money) throws IllegalArgumentException; // return the charge
    // the money use quarters as unit

    public boolean validProductName(String productName);

    public boolean validRepository(String productName); 

    public boolean enoughMoneyToBuy(String productName, int money);

    public int change(String productName, int money);
}
