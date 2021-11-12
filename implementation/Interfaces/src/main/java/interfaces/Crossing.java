package interfaces;

public interface Crossing {
    void addPedestrianTrafficLightPair(PedestrianTrafficLight a, PedestrianTrafficLight b);

    void removePedestrianTrafficLightPair();

    void activate();

    void deactivate();
}
