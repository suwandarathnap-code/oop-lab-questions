import javax.swing.*;
import java.awt.*;

public class ProductForm extends JFrame {

    private JLabel titleLabel;
    private JLabel productNameLabel;
    private JLabel unitPriceLabel;
    private JLabel quantityLabel;
    private JTextField productNameTextField;
    private JTextField unitPriceTextField;
    private JTextField quantityTextField;
    private JButton calculateButton;
    private JTextArea outputTextArea;

    public ProductForm() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Product Price Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        titleLabel = new JLabel("Product Price Calculator");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(titleLabel, gbc);
        gbc.gridwidth = 1;

        // Product Name
        productNameLabel = new JLabel("Product Name:");
        gbc.gridx = 0; gbc.gridy = 1;
        add(productNameLabel, gbc);

        productNameTextField = new JTextField(20);
        productNameTextField.setToolTipText("Enter the product name");
        gbc.gridx = 1; gbc.gridy = 1;
        add(productNameTextField, gbc);

        // Unit Price
        unitPriceLabel = new JLabel("Unit Price:");
        gbc.gridx = 0; gbc.gridy = 2;
        add(unitPriceLabel, gbc);

        unitPriceTextField = new JTextField(20);
        unitPriceTextField.setToolTipText("Enter the unit price");
        gbc.gridx = 1; gbc.gridy = 2;
        add(unitPriceTextField, gbc);

        // Quantity
        quantityLabel = new JLabel("Quantity:");
        gbc.gridx = 0; gbc.gridy = 3;
        add(quantityLabel, gbc);

        quantityTextField = new JTextField(20);
        quantityTextField.setToolTipText("Enter the quantity");
        gbc.gridx = 1; gbc.gridy = 3;
        add(quantityTextField, gbc);

        // Button
        calculateButton = new JButton("Calculate Total");
        calculateButton.setToolTipText("Click to calculate total price and check stock status");
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        add(calculateButton, gbc);
        gbc.gridwidth = 1;

        // Output area
        outputTextArea = new JTextArea(6, 30);
        outputTextArea.setEditable(false);
        outputTextArea.setBackground(new Color(230, 245, 255));
        outputTextArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        add(scrollPane, gbc);

        calculateButton.addActionListener(e -> calculateButtonActionPerformed());

        pack();
        setLocationRelativeTo(null);
    }

    private void calculateButtonActionPerformed() {
        String productName = productNameTextField.getText().trim();
        double unitPrice = Double.parseDouble(unitPriceTextField.getText().trim());
        int quantity = Integer.parseInt(quantityTextField.getText().trim());

        Product product = new Product(productName, unitPrice, quantity);

        outputTextArea.setText(
            "Product Name: " + product.getProductName() + "\n" +
            "Unit Price: " + product.getUnitPrice() + "\n" +
            "Quantity: " + product.getQuantity() + "\n" +
            "Total Price: " + product.calculateTotal() + "\n" +
            "Stock Status: " + product.getStockStatus()
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductForm().setVisible(true));
    }
}