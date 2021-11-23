package interfaces;

public interface Crossing {
    void addPedestrianTrafficLightPair(PedestrianTrafficLight a, PedestrianTrafficLight b);
    void addStreetTrafficLightPair(StreetTrafficLight a, StreetTrafficLight b);

    void removePedestrianTrafficLightPair();

    void removeStreetTrafficLightPair();

    void activate(int length);

    void deactivate();

    void startHorizontalTrafficLights();

    void startVerticalTrafficLights();
}
