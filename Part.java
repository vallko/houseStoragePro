public class Part {
    static String partName;

    public static String getPartName(Object o) {
        return partName;
    }

    public static void setPartName(String partName) {
        Part.partName = partName;
    }

    public static String getPartCase() {
        return partCase;
    }

    public static void setPartCase(String partCase) {
        Part.partCase = partCase;
    }

    public static int getQuantity() {
        return quantity;
    }

    public static void setQuantity(int quantity) {
        Part.quantity = quantity;
    }

    public static double getPrice() {
        return price;
    }

    public static void setPrice(double price) {
        Part.price = price;
    }

    static String partCase;
    static int quantity;
    static double price;

    public Part(Object itemID, String partName, String partCase, int quantity, double price) {
        Part.partName = partName;
        Part.partCase = partCase;
        Part.quantity = quantity;
        Part.price = price;

    }
}
