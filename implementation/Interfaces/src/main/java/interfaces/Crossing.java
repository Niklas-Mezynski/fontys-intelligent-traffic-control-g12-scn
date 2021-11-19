package interfaces;

public interface Crossing {
    void addPedestrianTrafficLightPair(PedestrianTrafficLight a, PedestrianTrafficLight b);
    void addStreetTrafficLightPair(StreetTrafficLight a, StreetTrafficLight b);

    void removePedestrianTrafficLightPair(PedestrianTrafficLight horizontal, PedestrianTrafficLight vertical);

    void removeStreetTrafficLightPair(StreetTrafficLight horizontal, StreetTrafficLight vertical);

    void activate(int length);

    void deactivate();

    void startHorizontalTrafficLights();

    void startVerticalTrafficLights();

}
