package interfaces;

public interface DriverPlatform {

    public DriverPlatform getHorizontalPartner();

    public DriverPlatform getVerticalPartner();

    public int getX();

    public int getY();

    public void attachDriver(Driver driver);

    public void removeDriver(Driver driver);
}
