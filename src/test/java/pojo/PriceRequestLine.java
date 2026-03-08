package pojo;

public class PriceRequestLine {
    private String ingramPartNumber;
    private int quantity;

    // Constructors, Getters, and Setters
    public PriceRequestLine(String partNumber, int qty) {
        this.ingramPartNumber = partNumber;
        this.quantity = qty;
    }

    public String getIngramPartNumber() {
        return ingramPartNumber;
    }

    public void setIngramPartNumber(String ingramPartNumber) {
        this.ingramPartNumber = ingramPartNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "PriceRequestLine{" +
                "ingramPartNumber='" + ingramPartNumber + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}