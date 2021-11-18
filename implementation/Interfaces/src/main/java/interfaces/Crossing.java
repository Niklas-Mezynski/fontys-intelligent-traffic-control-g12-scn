package interfaces;

public interface Crossing {
    void addPedestrianTrafficLightPair(PedestrianTrafficLight a, PedestrianTrafficLight b);

    void removePedestrianTrafficLightPair();

    void activate(int length);

    void deactivate();

    void startPedestrianHorizontalTraffic();

    void startPedestrianVerticalTraffic();
}
