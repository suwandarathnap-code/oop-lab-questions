import javax.swing.*;
import java.awt.*;

public class MemberForm extends JFrame {

    private JLabel titleLabel;
    private JLabel memberNameLabel;
    private JLabel monthsLabel;
    private JLabel membershipTypeLabel;
    private JTextField memberNameTextField;
    private JTextField numberOfMonthsTextField;
    private JRadioButton regularRadioButton;
    private JRadioButton premiumRadioButton;
    private ButtonGroup membershipButtonGroup;
    private JCheckBox newsletterCheckBox;
    private JButton registerButton;
    private JTextArea outputTextArea;

    public MemberForm() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Membership Registration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        titleLabel = new JLabel("Membership Registration Form");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(titleLabel, gbc);
        gbc.gridwidth = 1;

        // Member Name
        memberNameLabel = new JLabel("Member Name:");
        gbc.gridx = 0; gbc.gridy = 1;
        add(memberNameLabel, gbc);

        memberNameTextField = new JTextField(20);
        memberNameTextField.setToolTipText("Enter member's full name");
        gbc.gridx = 1; gbc.gridy = 1;
        add(memberNameTextField, gbc);

        // Number of Months
        monthsLabel = new JLabel("Number of Months:");
        gbc.gridx = 0; gbc.gridy = 2;
        add(monthsLabel, gbc);

        numberOfMonthsTextField = new JTextField(20);
        numberOfMonthsTextField.setToolTipText("Enter number of months for membership");
        gbc.gridx = 1; gbc.gridy = 2;
        add(numberOfMonthsTextField, gbc);

        // Membership Type (Radio Buttons)
        membershipTypeLabel = new JLabel("Membership Type:");
        gbc.gridx = 0; gbc.gridy = 3;
        add(membershipTypeLabel, gbc);

        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        regularRadioButton = new JRadioButton("Regular");
        regularRadioButton.setSelected(true);
        regularRadioButton.setToolTipText("Regular membership - Rs. 1000/month");

        premiumRadioButton = new JRadioButton("Premium");
        premiumRadioButton.setToolTipText("Premium membership - Rs. 2500/month");

        membershipButtonGroup = new ButtonGroup();
        membershipButtonGroup.add(regularRadioButton);
        membershipButtonGroup.add(premiumRadioButton);

        radioPanel.add(regularRadioButton);
        radioPanel.add(premiumRadioButton);
        gbc.gridx = 1; gbc.gridy = 3;
        add(radioPanel, gbc);

        // Newsletter Checkbox
        newsletterCheckBox = new JCheckBox("Subscribe to Newsletter (+Rs. 200)");
        newsletterCheckBox.setToolTipText("Check to add newsletter subscription");
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        add(newsletterCheckBox, gbc);
        gbc.gridwidth = 1;

        // Register Button
        registerButton = new JButton("Register Member");
        registerButton.setToolTipText("Click to complete registration and view summary");
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        add(registerButton, gbc);
        gbc.gridwidth = 1;

        // Output area
        outputTextArea = new JTextArea(7, 30);
        outputTextArea.setEditable(false);
        outputTextArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2;
        add(scrollPane, gbc);

        registerButton.addActionListener(e -> registerButtonActionPerformed());

        pack();
        setLocationRelativeTo(null);
    }

    private void registerButtonActionPerformed() {
        String memberName = memberNameTextField.getText().trim();
        int numberOfMonths = Integer.parseInt(numberOfMonthsTextField.getText().trim());
        String membershipType = regularRadioButton.isSelected() ? "Regular" : "Premium";
        boolean newsletterSelected = newsletterCheckBox.isSelected();

        Member member = new Member(memberName, membershipType, newsletterSelected, numberOfMonths);

        outputTextArea.setText(
            "Member Name: " + member.getMemberName() + "\n" +
            "Membership Type: " + member.getMembershipType() + "\n" +
            "Months: " + member.getNumberOfMonths() + "\n" +
            "Newsletter: " + member.getNewsletterText() + "\n" +
            "Total Fee: " + member.getMembershipFee()
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MemberForm().setVisible(true));
    }
}