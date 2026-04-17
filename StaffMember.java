abstract class StaffMember {
  
    private String fullName;
    private final int staffId;
    protected String department;

    public StaffMember(String fullName, int staffId, String department) {
        this.fullName = fullName;
        this.staffId = staffId;
        this.department = department;
    }

    public String getFullName() {
        return fullName;
    }

    public int getStaffId() {
        return staffId;
    }


    public String getDepartment() {
        return department;
    }

    public final void displayBasicDetails() {
        System.out.println(fullName + " " + staffId + " " + department);
    }

    public abstract double calculateMonthlyPayment();
}
