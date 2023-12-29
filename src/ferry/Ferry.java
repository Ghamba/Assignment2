package ferry;

public class Ferry {

    private static long nextFerrySerialNumber = 70000;

    private double maximumSpeed;
    private double maximumLoad;
    private long serialNumber;

    public Ferry() {
        this(0.0, 0.0);
    }

    public Ferry(double maximumSpeed, double maximumLoad) {
        this.setMaximumSpeed(maximumSpeed);
        this.setMaximumLoad(maximumLoad);
        this.serialNumber = getNextFerrySerialNumber(); // Assigns a unique ferry serial number
    }

    public Ferry(Ferry other) {
        this.setMaximumSpeed(other.maximumSpeed);
        this.setMaximumLoad(other.maximumLoad);
        this.serialNumber = getNextFerrySerialNumber(); // Assigns a unique ferry serial number
    }

    private static synchronized long getNextFerrySerialNumber() {
        return nextFerrySerialNumber++;
    }

    // Accessors
    public double getMaximumSpeed() {
        return maximumSpeed;
    }

    public double getMaximumLoad() {
        return maximumLoad;
    }

    // Mutators with exception handling
    public void setMaximumSpeed(double maximumSpeed) {
        if (maximumSpeed < 0) {
            throw new IllegalArgumentException("Maximum speed cannot be negative.");
        }
        this.maximumSpeed = maximumSpeed;
    }

    public void setMaximumLoad(double maximumLoad) {
        if (maximumLoad < 0) {
            throw new IllegalArgumentException("Maximum load cannot be negative.");
        }
        this.maximumLoad = maximumLoad;
    }

    // To string method
    @Override
    public String toString() {
        return "Ferry [maximumSpeed=" + maximumSpeed + ", maximumLoad=" + maximumLoad + ", serialNumber=" + serialNumber + "]";
    }

    // Equals() method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Ferry other = (Ferry) obj;

        return Double.compare(other.maximumSpeed, maximumSpeed) == 0 && Double.compare(other.maximumLoad, maximumLoad) == 0;
    }
}
