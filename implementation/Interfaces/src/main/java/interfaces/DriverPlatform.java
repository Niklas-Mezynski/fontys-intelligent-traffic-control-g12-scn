package interfaces;

public interface DriverPlatform {

    public void addHorizontalPartner(DriverPlatform platform);

    public void addVerticalPartner(DriverPlatform platform);

    public DriverPlatform getHorizontalPartner();

    public DriverPlatform getVerticalPartner();

    public int getX();

    public int getY();

    public void attachDriver(Driver driver);

    int getCount();
}
