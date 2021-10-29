package factories;

import interfaces.*;
import trafficlights.PedestrianTrafficLight;
import trafficlights.StreetTrafficLight;

/**
 * Implementation of TrafficLightFactory
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class SimpleTrafficLightFactory implements TrafficLightFactory {
    private final LightBehaviourFactory lightBehaviourFactory = new SimpleLightBehaviourFactory();

    @Override
    public TrafficLight createEmptyPedestrianTrafficLight() {
        return new PedestrianTrafficLight();
    }

    @Override
    public TrafficLight createEmptyStreetTrafficLight() {
        return new StreetTrafficLight();
    }

    @Override
    public TrafficLight createSimplePedestrianTrafficLight() {
        TrafficLight trafficLight = createEmptyPedestrianTrafficLight();
        LightBehaviour behaviour = lightBehaviourFactory.createSimplePedestrianLightBehaviour(trafficLight);
        trafficLight.setLightBehaviour(behaviour);
        return trafficLight;
    }

    @Override
    public TrafficLight createExtendedPedestrianTrafficLight() {
        TrafficLight trafficLight = createEmptyPedestrianTrafficLight();
        LightBehaviour behaviour = lightBehaviourFactory.createExtendedPedestrianLightBehaviour(trafficLight);
        trafficLight.setLightBehaviour(behaviour);
        return trafficLight;
    }

    @Override
    public TrafficLight createCustomPedestrianTrafficLight() {
        TrafficLight trafficLight = createEmptyPedestrianTrafficLight();
        LightBehaviour behaviour = lightBehaviourFactory.createCustomPedestrianLightBehaviour(trafficLight);
        trafficLight.setLightBehaviour(behaviour);
        return trafficLight;
    }

    @Override
    public TrafficLight createSimpleStreetTrafficLight() {
        TrafficLight trafficLight = createEmptyStreetTrafficLight();
        LightBehaviour behaviour = lightBehaviourFactory.createSimpleStreetLightBehaviour(trafficLight);
        trafficLight.setLightBehaviour(behaviour);
        return trafficLight;
    }
}
