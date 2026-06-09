public class ProductBill {

    private String priceText;
    private String quantityText;

    public ProductBill(String priceText, String quantityText) {
        this.priceText = priceText;
        this.quantityText = quantityText;
    }

    public double calculateTotal() {

        // NumberFormatException occurs if the text
        // cannot be converted into a number.

        double price = Double.parseDouble(priceText);
        int quantity = Integer.parseInt(quantityText);

        return price * quantity;
    }

}