package interfaces;

public interface TrafficLightFactory {
    PedestrianTrafficLight createDutchPedestrianTrafficLight();

    PedestrianTrafficLight createGermanPedestrianTrafficLight();

    PedestrianTrafficLight createAustralianPedestrianTrafficLight();

    StreetTrafficLight createDutchStreetTrafficLight();

    StreetTrafficLight createGermanStreetTrafficLight();

    StreetTrafficLight createAustralianStreetTrafficLight();

}
