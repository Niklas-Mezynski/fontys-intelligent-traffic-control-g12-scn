package interfaces;

public interface TrafficLightFactory {
    PedestrianTrafficLight createDutchPedestrianTrafficLight(String name);

    PedestrianTrafficLight createGermanPedestrianTrafficLight(String name);

    PedestrianTrafficLight createAustralianPedestrianTrafficLight(String name);

    StreetTrafficLight createDutchStreetTrafficLight(String name);

    StreetTrafficLight createGermanStreetTrafficLight(String name);

    StreetTrafficLight createAustralianStreetTrafficLight(String name);

}
