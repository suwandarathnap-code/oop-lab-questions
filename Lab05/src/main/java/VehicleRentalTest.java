package lab05;

public class VehicleRentalTest {

    public static void main(String[] args) {

        Vehicle vehicle1 =
                new Car("CAR101",
                        "Toyota",
                        5,
                        3000);

        Vehicle vehicle2 =
                new Bike("BIKE201",
                        "Yamaha",
                        10,
                        500);

        vehicle1.displayVehicleInfo();

        System.out.println("Rental Cost = "
                +vehicle1.calculateRentalCost());

        System.out.println();

        vehicle2.displayVehicleInfo();

        System.out.println("Rental Cost = "
                +vehicle2.calculateRentalCost());

        //Runtime polymorphism:
        //The overridden method is selected
        //based on the actual object type at runtime.

    }

}