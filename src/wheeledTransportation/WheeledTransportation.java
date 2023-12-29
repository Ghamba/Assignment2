package wheeledTransportation;

public class WheeledTransportation {

    private int numberOfWheels;
    private double maximumSpeed;
    protected long serialNumber;

    private static long nextSerialNumber = 1;

    public WheeledTransportation() {
        this(0, 0.0);
    }

    public WheeledTransportation(int numberOfWheels, double maximumSpeed) {
        validateInput(numberOfWheels, maximumSpeed);

        this.numberOfWheels = numberOfWheels;
        this.maximumSpeed = maximumSpeed;
        this.serialNumber = getNextSerialNumber();
    }

    public WheeledTransportation(WheeledTransportation other) {
        this.numberOfWheels = other.numberOfWheels;
        this.maximumSpeed = other.maximumSpeed;
        this.serialNumber = getNextSerialNumber();
    }

    private static synchronized long getNextSerialNumber() {
        return nextSerialNumber++;
    }

    // Getters:
    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public double getMaximumSpeed() {
        return maximumSpeed;
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    // Setters:
    public void setNumberOfWheels(int numberOfWheels) {
        validateInput(numberOfWheels, this.maximumSpeed);
        this.numberOfWheels = numberOfWheels;
    }

    public void setMaximumSpeed(double maximumSpeed) {
        validateInput(this.numberOfWheels, maximumSpeed);
        this.maximumSpeed = maximumSpeed;
    }

    // Validation method for positive input
    private void validateInput(int numberOfWheels, double maximumSpeed) {
        if (numberOfWheels < 0 || maximumSpeed < 0.0) {
            throw new IllegalArgumentException("The number cannot be negative.");
        }
    }

	@Override
	public String toString() {
		return "WheeledTransportation [numberOfWheels=" + numberOfWheels + ", maximumSpeed=" + maximumSpeed
				+ ", serialNumber=" + serialNumber + "]";
	}

    // equals() method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;

        WheeledTransportation other = (WheeledTransportation) obj;

        return this.numberOfWheels == other.numberOfWheels &&
               Double.compare(other.maximumSpeed, maximumSpeed) == 0;
    }


}