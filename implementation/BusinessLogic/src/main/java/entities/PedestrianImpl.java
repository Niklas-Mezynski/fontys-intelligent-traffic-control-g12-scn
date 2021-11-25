package entities;

import interfaces.Pedestrian;
import interfaces.PedestrianPlatform;

public class PedestrianImpl implements Pedestrian {
    private final String name;
    private final PedestrianPlatform start;
    private final PedestrianPlatform end;

    public PedestrianImpl(String name, PedestrianPlatform start, PedestrianPlatform end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public PedestrianPlatform getStartingPoint() {
        return start;
    }

    @Override
    public PedestrianPlatform getDestination() {
        return end;
    }

    @Override
    public void crossStreet() {

    }
}
