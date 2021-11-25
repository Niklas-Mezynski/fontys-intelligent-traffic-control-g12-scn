package entities;

import interfaces.LightState;
import interfaces.Pedestrian;
import interfaces.PedestrianPlatform;

public class PedestrianImpl implements Pedestrian {
    private final String name;
    private final PedestrianPlatform dest;

    public PedestrianImpl(String name, PedestrianPlatform dest) {
        this.name = name;
        this.dest = dest;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public PedestrianPlatform getDestination() {
        return dest;
    }

    @Override
    public void crossStreet() {

    }
}
