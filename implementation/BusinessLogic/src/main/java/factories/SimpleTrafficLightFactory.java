package factories;

import interfaces.LightBehaviourFactory;
import interfaces.PedestrianTrafficLight;
import interfaces.StreetTrafficLight;
import interfaces.TrafficLightFactory;
import trafficLights.SimplePedestrianTrafficLight;
import trafficLights.SimpleStreetTrafficLight;

public class SimpleTrafficLightFactory implements TrafficLightFactory {
    private final LightBehaviourFactory lightBehaviourFactory = new SimpleLightBehaviourFactory();

    @Override
    public PedestrianTrafficLight createDutchPedestrianTrafficLight() {
        return new SimplePedestrianTrafficLight(lightBehaviourFactory.getInitialDutchPedestrianState());
    }

    @Override
    public PedestrianTrafficLight createGermanPedestrianTrafficLight() {
        return new SimplePedestrianTrafficLight(lightBehaviourFactory.getInitialGermanPedestrianState());
    }

    @Override
    public PedestrianTrafficLight createAustralianPedestrianTrafficLight() {
        return new SimplePedestrianTrafficLight(lightBehaviourFactory.getInitialAustralianPedestrianState());
    }

    @Override
    public StreetTrafficLight createDutchStreetTrafficLight() {
        return new SimpleStreetTrafficLight(lightBehaviourFactory.getInitialDutchStreetState());
    }

    @Override
    public StreetTrafficLight createGermanStreetTrafficLight() {
        return new SimpleStreetTrafficLight(lightBehaviourFactory.getInitialGermanStreetState());
    }

    @Override
    public StreetTrafficLight createAustralianStreetTrafficLight() {
        return new SimpleStreetTrafficLight(lightBehaviourFactory.getInitialBulgarianStreetState());
    }
}
