public class Lab04Main {
    public static void main(String[] args) {

        Lecturer l = new Lecturer("Kamal",101,"IT",3,50000);

        l.displayLecturerDetails();
        System.out.println(l.calculateMonthlyPayment());
    }
}
