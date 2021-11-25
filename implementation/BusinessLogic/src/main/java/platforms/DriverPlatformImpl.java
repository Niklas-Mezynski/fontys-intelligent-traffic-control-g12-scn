package platforms;

import interfaces.Driver;
import interfaces.DriverPlatform;

import java.util.ArrayList;
import java.util.List;

public class DriverPlatformImpl implements DriverPlatform {

    private int x;
    private int y;

    private DriverPlatform hPartner;
    private DriverPlatform vPartner;

    private final List<Driver> driverPriorityQueue;
    private int count;

    public DriverPlatformImpl(int x, int y) {
        this.x = x;
        this.y = y;
        this.driverPriorityQueue = new ArrayList<>();
    }



    @Override
    public void addHorizontalPartner(DriverPlatform platform) {
        hPartner = platform;
    }

    @Override
    public void addVerticalPartner(DriverPlatform platform) {
        vPartner = platform;
    }

    @Override
    public DriverPlatform getHorizontalPartner() {
        return hPartner;
    }

    @Override
    public DriverPlatform getVerticalPartner() {
        return vPartner;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void attachDriver(Driver driver) {
            driverPriorityQueue.add(driver);
            count++;
    }

    public int getCount() {
        return count;
    }
}
