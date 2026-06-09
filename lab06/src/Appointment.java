public class Appointment {
    private String patientName;
    private String appointmentType;
    private String patientCategory;
    private double baseFee;

    public Appointment(String patientName, String appointmentType, String patientCategory, double baseFee) {
        this.patientName = patientName;
        this.appointmentType = appointmentType;
        this.patientCategory = patientCategory;
        this.baseFee = baseFee;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public String getPatientCategory() {
        return patientCategory;
    }

    public double getBaseFee() {
        return baseFee;
    }

    public double calculateFinalFee() {
        double fee = baseFee;

        // Apply appointment type adjustment
        if (appointmentType.equals("Specialist")) {
            fee += 1500;
        } else if (appointmentType.equals("Online")) {
            fee -= 500;
        }
        // General: no change

        // Apply patient category discount
        if (patientCategory.equals("Child")) {
            fee -= 300;
        } else if (patientCategory.equals("Senior")) {
            fee -= 500;
        }
        // Adult: no extra reduction

        return fee;
    }

    public String getAppointmentMessage() {
        return appointmentType + " appointment selected";
    }
}