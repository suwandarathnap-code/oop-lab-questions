public class Lab04Main {
    public static void main(String[] args) {

        StaffMember.showSystemName();

        Lecturer l1 = new Lecturer("A",1,"IT",2,1000);
        Lecturer l2 = new Lecturer("B",2,"IT",2,1000);
        LabAssistant a = new LabAssistant("C",3,"IT",50,100);
        
        System.out.println(StaffMember.getStaffCount());
        
    }
}
