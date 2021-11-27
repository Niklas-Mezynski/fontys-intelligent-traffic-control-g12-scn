package interfaces;

public interface SimpleObservableCrossing extends Crossing{
    void addHorizontalPedestrianLightObserver(LightObserver observer);

    void addVerticalPedestrianLightObserver(LightObserver observer);

    void addHorizontalStreetLightObserver(LightObserver observer);

    void addVerticalStreetLightObserver(LightObserver observer);

    void removeHorizontalPedestrianLightObserver(LightObserver observer);

    void removeVerticalPedestrianLightObserver(LightObserver observer);

    void removeHorizontalStreetLightObserver(LightObserver observer);

    void removeVerticalStreetLightObserver(LightObserver observer);
}
