package trainAndTram;

import wheeledTransportation.WheeledTransportation;

public class Train extends WheeledTransportation {

    private static long nextTrainSerialNumber = 10000;

    private long serialNumber; 

    private int numberOfVehicles;
    private String startingStation;
    private String destinationStation;

    // Default constructor
    public Train() {
        super();
        this.numberOfVehicles = 0;
        this.startingStation = null;
        this.destinationStation = null;
        this.serialNumber = getNextTrainSerialNumber();
    }

    // Constructor main
    public Train(int numberOfWheels, double maximumSpeed, int numberOfVehicles,
                 String startingStation, String destinationStation) {
        super(numberOfWheels, maximumSpeed);
        this.numberOfVehicles = numberOfVehicles;
        this.startingStation = startingStation;
        this.destinationStation = destinationStation;
        this.serialNumber = getNextTrainSerialNumber(); // Assigns a unique train serial number
    }

    // Copy constructor
    public Train(Train other) {
        super(other);
        this.numberOfVehicles = other.numberOfVehicles;
        this.startingStation = other.startingStation;
        this.destinationStation = other.destinationStation;
        this.serialNumber = getNextTrainSerialNumber(); // Assigns a unique train serial number
    }

    private static synchronized long getNextTrainSerialNumber() {
        return nextTrainSerialNumber++;
    }

    // Accessors
    public int getNumberOfVehicles() {
        return numberOfVehicles;
    }

    public String getStartingStation() {
        return startingStation;
    }

    public String getDestinationStation() {
        return destinationStation;
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    // Mutators with exception handling
    public void setNumberOfVehicles(int numberOfVehicles) {
        if (numberOfVehicles < 0) {
            throw new IllegalArgumentException("Number of vehicles cannot be negative.");
        }
        this.numberOfVehicles = numberOfVehicles;
    }

    public void setStartingStation(String startingStation) {
        if (startingStation == null || startingStation.isEmpty()) {
            throw new IllegalArgumentException("Starting station should have a name.");
        }
        this.startingStation = startingStation;
    }

    public void setDestinationStation(String destinationStation) {
        if (destinationStation == null || destinationStation.isEmpty()) {
            throw new IllegalArgumentException("Destination station should have a name.");
        }
        this.destinationStation = destinationStation;
    }

    // toString
    @Override
    public String toString() {
        return "Train Serial Number: " + serialNumber + ", Number Of Wheels: " + getNumberOfWheels()
        		+ ", Maximum Speed: " + getMaximumSpeed() + ", Number Of Vehicles: " + numberOfVehicles + ", Starting Station: " + startingStation
                + ", Destination Station: " + destinationStation + "]";
    }

    // equals() method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Train other = (Train) obj;

        return super.equals(obj) &&
               numberOfVehicles == other.numberOfVehicles &&
               startingStation.equals(other.startingStation) &&
               destinationStation.equals(other.destinationStation);
    }
}
