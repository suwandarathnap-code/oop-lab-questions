package lab05;

public class DeliveryChargeTest {

    public static void main(String[] args) {

        DeliveryChargeCalculator calculator =
                new DeliveryChargeCalculator();

        System.out.println("Base Charge = "
                + calculator.calculateCharge(1000));

        System.out.println("Distance Charge = "
                + calculator.calculateCharge(1000,5));

        System.out.println("Distance + Weight = "
                + calculator.calculateCharge(1000,5,2));

        System.out.println("Express Delivery = "
                + calculator.calculateCharge(1000,true));

        //Compile-time polymorphism:
        //Java selects the correct overloaded method
        //based on the parameter list during compilation.

    }

}