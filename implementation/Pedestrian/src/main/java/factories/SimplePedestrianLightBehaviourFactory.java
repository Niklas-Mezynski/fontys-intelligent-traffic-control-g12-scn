package factories;

import interfaces.*;
import lightbehaviours.CustomPedestrianLightBehaviour;
import lightbehaviours.ExtendedPedestrianLightBehaviour;
import lightbehaviours.SimplePedestrianLightBehaviour;

/**
 * Implementation of PedestrianLightBehaviourFactory
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class SimplePedestrianLightBehaviourFactory implements PedestrianLightBehaviourFactory {

    @Override
    public PedestrianLightBehaviour createSimplePedestrianLightBehaviour(PedestrianTrafficLight light) {
        return new SimplePedestrianLightBehaviour(light);
    }

    @Override
    public PedestrianLightBehaviour createExtendedPedestrianLightBehaviour(PedestrianTrafficLight light) {
        return new ExtendedPedestrianLightBehaviour(light);
    }

    @Override
    public PedestrianLightBehaviour createCustomPedestrianLightBehaviour(PedestrianTrafficLight light) {
        return new CustomPedestrianLightBehaviour(light);
    }
}
