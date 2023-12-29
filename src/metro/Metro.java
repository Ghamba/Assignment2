package metro;

import trainAndTram.Train;

public class Metro extends Train {

    private static long nextMetroSerialNumber = 25000;

    private long serialNumber; 

    private int totalStops;

    // Default constructor
    public Metro() {
        super();
        this.totalStops = 0;
        this.serialNumber = getNextMetroSerialNumber();
    }

    // Main constructor
    public Metro(int numberOfWheels, double maximumSpeed, int numberOfVehicles,
                 String startingStation, String destinationStation, int totalStops) {
        super(numberOfWheels, maximumSpeed, numberOfVehicles, startingStation, destinationStation);
        this.totalStops = totalStops;
        this.serialNumber = getNextMetroSerialNumber();  
    }

    // Copy constructor
    public Metro(Metro other) {
        super(other);
        this.totalStops = other.totalStops;
        this.serialNumber = getNextMetroSerialNumber();  
    }

    private static synchronized long getNextMetroSerialNumber() {
        return nextMetroSerialNumber++;
    }

    // Accessors
    public int getTotalStops() {
        return totalStops;
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    // Mutators with exception handling
    public void setTotalStops(int totalStops) {
        if (totalStops < 0) {
            throw new IllegalArgumentException("Total stops cannot be negative.");
        }
        this.totalStops = totalStops;
    }

    // toString() method override
    @Override
    public String toString() {
        return "Metro Serial Number: " + serialNumber + ", Number Of Wheels: " + getNumberOfWheels()
		+ ", Maximum Speed: " + getMaximumSpeed() + ", Number Of Vehicles: " + getNumberOfVehicles() + ", Starting Station: " + getStartingStation()
        + ", Destination Station: " + getDestinationStation() + ", Total Stops: " + totalStops + "]";
        }

    // equals() method override
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Metro other = (Metro) obj;

        return super.equals(obj) && totalStops == other.totalStops;
    }
}
