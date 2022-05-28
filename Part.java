public class Part {
    private final int itemID;
    private int partID;
    public String partName;
    public String partCase;
    public int quantity;
    public double price;

    public String getPartName() {
        return this.partName;
    }

    Part(int itemID, String partName, String partCase, int quantity, double price) {
        this.itemID = itemID;
        this.partName = partName;
        this.partCase = partCase;
        this.quantity = quantity;
        this.price = price;
    }
}
