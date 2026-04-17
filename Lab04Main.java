public class Lab04Main {
    public static void main(String[] args) {

        Lecturer l = new Lecturer("Roshan",101,"IT",3,50000);
        LabAssistant a = new LabAssistant("Sandun",201,"IT",100,500);

         l.displayLecturerDetails();
         a.displayLabAssistantDetails();
    }
}
