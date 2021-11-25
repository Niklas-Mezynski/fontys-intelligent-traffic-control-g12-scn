package interfaces;

public interface DriverPlatform extends Platform{

    public void addHorizontalPartner(DriverPlatform platform);

    public void addVerticalPartner(DriverPlatform platform);

    public DriverPlatform getHorizontalPartner();

    public DriverPlatform getVerticalPartner();

    public void attachDriver(Driver driver);

    int getCount();
}
