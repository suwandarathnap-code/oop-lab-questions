final class UniversityPolicy {

    public static final String UNIVERSITY_NAME = "UOK";
    public static final double BONUS_RATE = 0.1;

    public static void showPolicyHeader(){
        System.out.println("Policy");
    }

    public static double calculateBonus(double x){
        return x * BONUS_RATE;
    }
}
