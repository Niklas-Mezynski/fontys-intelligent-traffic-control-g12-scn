package factories;

import interfaces.*;
import trafficlights.SimplePedestrianTrafficLight;

/**
 * Implementation of PedestrianTrafficLightFactory
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class SimplePedestrianTrafficLightFactory implements PedestrianTrafficLightFactory {
    @Override
    public PedestrianTrafficLight createPedestrianTrafficLight() {
        return new SimplePedestrianTrafficLight();
    }
}
