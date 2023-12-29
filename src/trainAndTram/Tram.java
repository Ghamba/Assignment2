package trainAndTram;

import metro.Metro;

public class Tram extends Metro {

    private static long nextTramSerialNumber = 30000;

    private long serialNumber; // Instance variable for unique serial number

    private int yearOfCreation;

    public Tram() {
        super();
        this.yearOfCreation = 0;
        this.serialNumber = getNextTramSerialNumber(); // Assigns a unique tram serial number
    }

    public Tram(int numberOfWheels, double maximumSpeed, int numberOfVehicles,
                String startingStation, String destinationStation, int totalStops, int yearOfCreation) {
        super(numberOfWheels, maximumSpeed, numberOfVehicles, startingStation, destinationStation, totalStops);
        setYearOfCreation(yearOfCreation);
        this.serialNumber = getNextTramSerialNumber();  // Assigns a unique tram serial number
    }

    public Tram(Tram other) {
        super(other);
        this.yearOfCreation = other.yearOfCreation;
        this.serialNumber = getNextTramSerialNumber();  // Assigns a unique tram serial number
    }

    private static synchronized long getNextTramSerialNumber() {
        return nextTramSerialNumber++;
    }

    // Accessors
    public int getYearOfCreation() {
        return yearOfCreation;
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    // Mutators with exception handling
    public void setYearOfCreation(int yearOfCreation) {
        if (yearOfCreation < 0) {
            throw new IllegalArgumentException("Year of creation must be non-negative.");
        }
        this.yearOfCreation = yearOfCreation;
    }

    // toString method
    @Override
    public String toString() {
        return "Tram Serial Number: " + serialNumber + ", Number Of Wheels: " + getNumberOfWheels()
		+ ", Maximum Speed: " + getMaximumSpeed() + ", Number Of Vehicles: " + getNumberOfVehicles() + ", Starting Station: " + getStartingStation()
        + ", Destination Station: " + getDestinationStation() + ", Total Stops: " + getTotalStops() + ", Year Of Creation: " + yearOfCreation + "]";
    }
     
    // equals() method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Tram other = (Tram) obj;

        return super.equals(obj) && yearOfCreation == other.yearOfCreation;
    }
}

