package monowheel;

import wheeledTransportation.WheeledTransportation;

public class MonoWheel extends WheeledTransportation {

    private static long nextMonowheelSerialNumber = 55000;

    private long serialNumber; // Instance variable for unique serial number

    private double maximumWeight;

    // Default constructor
    public MonoWheel() {
        super();

        this.maximumWeight = 0.0;
        this.serialNumber = getNextMonowheelSerialNumber();
    }

    // Main constructor
    public MonoWheel(int numberOfWheels, double maximumSpeed, double maximumWeight) {
        super(numberOfWheels, maximumSpeed);
        this.maximumWeight = maximumWeight;
        this.serialNumber = getNextMonowheelSerialNumber();  
    }

    // Copy constructor
    public MonoWheel(MonoWheel other) {
        super(other);
        this.maximumWeight = other.maximumWeight;
        this.serialNumber = getNextMonowheelSerialNumber();  
    }

    private static synchronized long getNextMonowheelSerialNumber() {
        return nextMonowheelSerialNumber++;
    }

    // Accessors
    public double getMaximumWeight() {
        return maximumWeight;
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    // Mutators with exception handling
    public void setMaximumWeight(double maximumWeight) {
        if (maximumWeight < 0) {
            throw new IllegalArgumentException("Maximum weight must be non-negative.");
        }
        this.maximumWeight = maximumWeight;
    }

    // toString() method
    @Override
    public String toString() {
    	return "Monowheel Serial Number: " + serialNumber + ", Number Of Wheels: " + getNumberOfWheels()
		+ ", Maximum Speed: " + getMaximumSpeed() + ", Maximum Weight: " + maximumWeight + "]";
    }

    // equals() method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        MonoWheel other = (MonoWheel) obj;

        return super.equals(obj) && Double.compare(other.maximumWeight, maximumWeight) == 0;
    }
}
