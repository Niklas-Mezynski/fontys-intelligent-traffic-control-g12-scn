package entities;

import interfaces.Driver;
import interfaces.DriverPlatform;

public class DriverImpl implements Driver {

    private final String name;
    private final DriverPlatform driverPlatform;

    public DriverImpl(String name, DriverPlatform driverPlatform) {
        this.name = name;
        this.driverPlatform = driverPlatform;
    }

    @Override
    public DriverPlatform getDestination() {
        return driverPlatform;
    }

    @Override
    public String getName() {
        return name;
    }
}
