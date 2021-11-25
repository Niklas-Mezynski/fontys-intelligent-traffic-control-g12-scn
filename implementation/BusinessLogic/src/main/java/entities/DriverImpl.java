package entities;

import interfaces.Driver;
import interfaces.DriverPlatform;

public class DriverImpl implements Driver {

    private final String name;
    private final DriverPlatform start;
    private final DriverPlatform end;



    public DriverImpl(String name, DriverPlatform start, DriverPlatform end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }

    @Override
    public DriverPlatform getStartingPoint() {
        return start;
    }

    @Override
    public DriverPlatform getDestination() {
        return end;
    }

    @Override
    public String getName() {
        return name;
    }
}
