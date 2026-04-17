public class Lab04Main {
    public static void main(String[] args) {

        StaffMember.showSystemName();
        UniversityPolicy.showPolicyHeader();

        Lecturer l1 = new Lecturer("A",1,"IT",2,1000);
        Lecturer l2 = new Lecturer("B",2,"IT",2,1000);
        LabAssistant a = new LabAssistant("C",3,"IT",50,100);

        l1.changeDepartment("SE");

        l1.displayLecturerDetails();
        l2.displayLecturerDetails();
        a.displayLabAssistantDetails();

        double total = l1.calculateMonthlyPayment()
                + l2.calculateMonthlyPayment()
                + a.calculateMonthlyPayment();

        System.out.println(total);
        System.out.println(StaffMember.getStaffCount());

        l1.showCommonNotice();
        l2.showCommonNotice();
        a.showCommonNotice();
    }
}
