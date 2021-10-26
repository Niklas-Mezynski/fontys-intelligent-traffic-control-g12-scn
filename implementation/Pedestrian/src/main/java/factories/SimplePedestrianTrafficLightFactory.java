package factories;

import interfaces.*;
import trafficlights.SimplePedestrianTrafficLight;

/**
 * Implementation of PedestrianTrafficLightFactory
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class SimplePedestrianTrafficLightFactory implements PedestrianTrafficLightFactory {
    private final PedestrianLightBehaviourFactory lightBehaviourFactory = new SimplePedestrianLightBehaviourFactory();

    @Override
    public PedestrianTrafficLight createEmptyPedestrianTrafficLight() {
        return new SimplePedestrianTrafficLight();
    }

    @Override
    public PedestrianTrafficLight createSimplePedestrianTrafficLight() {
        PedestrianTrafficLight trafficLight = createEmptyPedestrianTrafficLight();
        PedestrianLightBehaviour behaviour = lightBehaviourFactory.createSimplePedestrianLightBehaviour(trafficLight);
        trafficLight.setPedestrianLightBehaviour(behaviour);
        return trafficLight;
    }

    @Override
    public PedestrianTrafficLight createExtendedPedestrianTrafficLight() {
        PedestrianTrafficLight trafficLight = createEmptyPedestrianTrafficLight();
        PedestrianLightBehaviour behaviour = lightBehaviourFactory.createExtendedPedestrianLightBehaviour(trafficLight);
        trafficLight.setPedestrianLightBehaviour(behaviour);
        return trafficLight;
    }

    @Override
    public PedestrianTrafficLight createCustomPedestrianTrafficLight() {
        PedestrianTrafficLight trafficLight = createEmptyPedestrianTrafficLight();
        PedestrianLightBehaviour behaviour = lightBehaviourFactory.createCustomPedestrianLightBehaviour(trafficLight);
        trafficLight.setPedestrianLightBehaviour(behaviour);
        return trafficLight;
    }
}
