package driver;

import aircraftAndWW2Airplane.Aircraft;
import ferry.Ferry;
import metro.Metro;
import monowheel.MonoWheel;
import trainAndTram.Tram;
import trainAndTram.Train;
import wheeledTransportation.WheeledTransportation;

public class DriverMain {

    public static void main(String[] args) {
        // Create at least 16 objects from the 8 classes and display their information
        WheeledTransportation transportation1 = new WheeledTransportation(3, 50.0);
        Train train1 = new Train(13, 110.0, 6, "StationA", "StationB");
        Metro metro1 = new Metro(16, 100.0, 2, "StationC", "StationD", 10);
        Tram tram1 = new Tram(2, 30.0, 4, "StationE", "StationF", 5, 2000);
        MonoWheel monowheel1 = new MonoWheel(2, 30.0, 140.0);
        Ferry ferry1 = new Ferry(25.0, 200.0);

        WheeledTransportation transportation2 = new WheeledTransportation(2, 40.0);
        Train train2 = new Train(5, 140.0, 2, "StationH", "StationY");
        Metro metro2 = new Metro(12, 44.0, 4, "StationF", "StationW", 8);
        Tram tram2 = new Tram(6, 60.0, 1, "StationV", "StationN", 2, 2020);
        MonoWheel monowheel2 = new MonoWheel(1, 23.0, 130.0);
        Ferry ferry2 = new Ferry(40.0, 156.0);

        System.out.println("Objects 1st series:");
        System.out.println(transportation1);
        System.out.println(train1);
        System.out.println(metro1);
        System.out.println(tram1);
        System.out.println(monowheel1);
        System.out.println(ferry1);
        
        System.out.println("Objects 2nd series:");
        System.out.println(transportation2);
        System.out.println(train2);
        System.out.println(metro2);
        System.out.println(tram2);
        System.out.println(monowheel2);
        System.out.println(ferry2);

        System.out.println("\nTesting Equality:");

        // Test the equality of two objects from different classes
        System.out.println("Are transportation1 and ferry1 equal? " + transportation1.equals(ferry1));

        // Test the equality of two objects from the same class with different values
        Train train3 = new Train(12, 130.0, 3, "StationG", "StationH");
        Train train4 = new Train(10, 135.0, 3, "StationG", "StationH");
        System.out.println("Are train3 and train4 equal? " + train3.equals(train4));

        // Test the equality of two objects with similar values
        MonoWheel monowheel3 = new MonoWheel(3, 45.0, 130.0);
        MonoWheel monowheel4 = new MonoWheel(3, 45.0, 130.0);
        System.out.println("Are monowheel3 and monowheel4 equal? " + monowheel3.equals(monowheel4));


    }

    
}