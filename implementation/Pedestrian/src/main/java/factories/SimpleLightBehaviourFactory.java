package factories;

import interfaces.*;
import lightbehaviours.CustomPedestrianLightBehaviour;
import lightbehaviours.ExtendedPedestrianLightBehaviour;
import lightbehaviours.SimplePedestrianLightBehaviour;
import lightbehaviours.SimpleStreetLightBehaviour;

/**
 * Implementation of PedestrianLightBehaviourFactory
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class SimpleLightBehaviourFactory implements LightBehaviourFactory {

    @Override
    public LightBehaviour createSimplePedestrianLightBehaviour(TrafficLight light) {
        return new SimplePedestrianLightBehaviour(light);
    }

    @Override
    public LightBehaviour createExtendedPedestrianLightBehaviour(TrafficLight light) {
        return new ExtendedPedestrianLightBehaviour(light);
    }

    @Override
    public LightBehaviour createCustomPedestrianLightBehaviour(TrafficLight light) {
        return new CustomPedestrianLightBehaviour(light);
    }

    @Override
    public LightBehaviour createSimpleStreetLightBehaviour(TrafficLight light) {
        return new SimpleStreetLightBehaviour(light);
    }
}
