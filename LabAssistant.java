class LabAssistant extends StaffMember {

    private int hoursWorked;
    private double hourlyRate;

    public LabAssistant(String n,int i,String d,int h,double r){
        super(n,i,d);
        hoursWorked = h;
        hourlyRate = r;
    }

    public double calculateMonthlyPayment(){
        return hoursWorked * hourlyRate;
    }

    public void displayLabAssistantDetails(){
        displayBasicDetails();
        System.out.println(hoursWorked + " " + hourlyRate);
    }
}
