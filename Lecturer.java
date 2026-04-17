class Lecturer extends StaffMember {

    private int courseCount;
    private double paymentPerCourse;

    public Lecturer(String name, int id, String dept, int c, double p) {
        super(name, id, dept);
        courseCount = c;
        paymentPerCourse = p;
    }

    public double calculateMonthlyPayment() {
        return courseCount * paymentPerCourse;
    }

    public void displayLecturerDetails() {
        displayBasicDetails();
        System.out.println(courseCount + " " + paymentPerCourse);
    }
}
