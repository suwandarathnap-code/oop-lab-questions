import javax.swing.*;
import java.awt.*;

public class AppointmentForm extends JFrame {

    private JLabel titleLabel;
    private JLabel patientNameLabel;
    private JLabel baseFeeLabel;
    private JLabel appointmentTypeLabel;
    private JLabel patientCategoryLabel;
    private JTextField patientNameTextField;
    private JTextField baseFeeTextField;
    private JComboBox<String> appointmentTypeComboBox;
    private JComboBox<String> patientCategoryComboBox;
    private JButton calculateButton;
    private JTextArea outputTextArea;

    public AppointmentForm() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Appointment Fee Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        titleLabel = new JLabel("Appointment Type Selector");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(titleLabel, gbc);
        gbc.gridwidth = 1;

        // Patient Name
        patientNameLabel = new JLabel("Patient Name:");
        gbc.gridx = 0; gbc.gridy = 1;
        add(patientNameLabel, gbc);

        patientNameTextField = new JTextField(20);
        patientNameTextField.setToolTipText("Enter the patient name");
        gbc.gridx = 1; gbc.gridy = 1;
        add(patientNameTextField, gbc);

        // Base Fee
        baseFeeLabel = new JLabel("Base Fee:");
        gbc.gridx = 0; gbc.gridy = 2;
        add(baseFeeLabel, gbc);

        baseFeeTextField = new JTextField(20);
        baseFeeTextField.setToolTipText("Enter the base consultation fee");
        gbc.gridx = 1; gbc.gridy = 2;
        add(baseFeeTextField, gbc);

        // Appointment Type ComboBox
        appointmentTypeLabel = new JLabel("Appointment Type:");
        gbc.gridx = 0; gbc.gridy = 3;
        add(appointmentTypeLabel, gbc);

        appointmentTypeComboBox = new JComboBox<>(new String[]{"General", "Specialist", "Online"});
        appointmentTypeComboBox.setToolTipText("Select appointment type");
        gbc.gridx = 1; gbc.gridy = 3;
        add(appointmentTypeComboBox, gbc);

        // Patient Category ComboBox
        patientCategoryLabel = new JLabel("Patient Category:");
        gbc.gridx = 0; gbc.gridy = 4;
        add(patientCategoryLabel, gbc);

        patientCategoryComboBox = new JComboBox<>(new String[]{"Adult", "Child", "Senior"});
        patientCategoryComboBox.setToolTipText("Select patient category");
        gbc.gridx = 1; gbc.gridy = 4;
        add(patientCategoryComboBox, gbc);

        // Button
        calculateButton = new JButton("Calculate Fee");
        calculateButton.setToolTipText("Click to calculate the final appointment fee");
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        add(calculateButton, gbc);
        gbc.gridwidth = 1;

        // Output area
        outputTextArea = new JTextArea(7, 30);
        outputTextArea.setEditable(false);
        outputTextArea.setLineWrap(true);
        outputTextArea.setWrapStyleWord(true);
        outputTextArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2;
        add(scrollPane, gbc);

        calculateButton.addActionListener(e -> calculateButtonActionPerformed());

        pack();
        setLocationRelativeTo(null);
    }

    private void calculateButtonActionPerformed() {
        String patientName = patientNameTextField.getText().trim();
        double baseFee = Double.parseDouble(baseFeeTextField.getText().trim());
        String appointmentType = (String) appointmentTypeComboBox.getSelectedItem();
        String patientCategory = (String) patientCategoryComboBox.getSelectedItem();

        Appointment appointment = new Appointment(patientName, appointmentType, patientCategory, baseFee);

        outputTextArea.setText(
            "Patient Name: " + appointment.getPatientName() + "\n" +
            "Appointment Type: " + appointment.getAppointmentType() + "\n" +
            "Patient Category: " + appointment.getPatientCategory() + "\n" +
            "Base Fee: " + appointment.getBaseFee() + "\n" +
            "Final Fee: " + appointment.calculateFinalFee() + "\n" +
            "Message: " + appointment.getAppointmentMessage()
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AppointmentForm().setVisible(true));
    }
}