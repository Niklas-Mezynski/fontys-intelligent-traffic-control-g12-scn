package interfaces;

public interface AdvancedObservableCrossing extends Crossing{
    void addHorizontalPedestrianLightObserver(LightObserver observer);

    void addVerticalPedestrianLightObserver(LightObserver observer);

    void addHorizontalLeftStreetLightObserver(LightObserver observer);

    void addVerticalLeftStreetLightObserver(LightObserver observer);

    void addHorizontalRightStreetLightObserver(LightObserver observer);

    void addVerticalRightStreetLightObserver(LightObserver observer);

    void addHorizontalStraightStreetLightObserver(LightObserver observer);

    void addVerticalStraightStreetLightObserver(LightObserver observer);
}
