import javax.swing.*;
import java.awt.*;

public class BookForm extends JFrame {

    private JLabel titleLabel;
    private JLabel bookTitleLabel;
    private JLabel authorLabel;
    private JLabel pagesLabel;
    private JTextField bookTitleTextField;
    private JTextField authorTextField;
    private JTextField pagesTextField;
    private JButton showButton;
    private JTextArea outputTextArea;

    public BookForm() {
        initComponents();
    }

    private void initComponents() {
        // Frame settings
        setTitle("Book Details Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title label
        titleLabel = new JLabel("Book Details");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(titleLabel, gbc);
        gbc.gridwidth = 1;

        // Book Title
        bookTitleLabel = new JLabel("Book Title:");
        gbc.gridx = 0; gbc.gridy = 1;
        add(bookTitleLabel, gbc);

        bookTitleTextField = new JTextField(20);
        bookTitleTextField.setToolTipText("Enter the book title");
        gbc.gridx = 1; gbc.gridy = 1;
        add(bookTitleTextField, gbc);

        // Author
        authorLabel = new JLabel("Author:");
        gbc.gridx = 0; gbc.gridy = 2;
        add(authorLabel, gbc);

        authorTextField = new JTextField(20);
        authorTextField.setToolTipText("Enter the author name");
        gbc.gridx = 1; gbc.gridy = 2;
        add(authorTextField, gbc);

        // Pages
        pagesLabel = new JLabel("Number of Pages:");
        gbc.gridx = 0; gbc.gridy = 3;
        add(pagesLabel, gbc);

        pagesTextField = new JTextField(20);
        pagesTextField.setToolTipText("Enter number of pages");
        gbc.gridx = 1; gbc.gridy = 3;
        add(pagesTextField, gbc);

        // Button
        showButton = new JButton("Show Book Details");
        showButton.setToolTipText("Click to display book information");
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        add(showButton, gbc);
        gbc.gridwidth = 1;

        // Output area
        outputTextArea = new JTextArea(6, 30);
        outputTextArea.setEditable(false);
        outputTextArea.setBackground(new Color(240, 240, 240));
        outputTextArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        add(scrollPane, gbc);

        // Button event
        showButton.addActionListener(e -> showButtonActionPerformed());

        pack();
        setLocationRelativeTo(null);
    }

    private void showButtonActionPerformed() {
        String title = bookTitleTextField.getText().trim();
        String author = authorTextField.getText().trim();
        int pages = Integer.parseInt(pagesTextField.getText().trim());

        Book book = new Book(title, author, pages);

        outputTextArea.setText(
            "Book Title: " + book.getTitle() + "\n" +
            "Author: " + book.getAuthor() + "\n" +
            "Pages: " + book.getPages() + "\n" +
            "Book Type: " + book.getBookType()
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BookForm().setVisible(true));
    }
}