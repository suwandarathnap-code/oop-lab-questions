public class Lab04Main {
    public static void main(String[] args) {

        UniversityPolicy.showPolicyHeader();
        System.out.println(UniversityPolicy.UNIVERSITY_NAME);

        Lecturer l = new Lecturer("Roshan",101,"IT",3,50000);
        LabAssistant a = new LabAssistant("Sandun",201,"IT",100,500);

        System.out.println(UniversityPolicy.calculateBonus(l.calculateMonthlyPayment()));
        
    }
}
