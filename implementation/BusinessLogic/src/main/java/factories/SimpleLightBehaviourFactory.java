package factories;

import interfaces.*;
import lightbehaviours.*;

/**
 * Implementation of PedestrianLightBehaviourFactory
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class SimpleLightBehaviourFactory implements LightBehaviourFactory {

    @Override
    public LightBehaviour createSimplePedestrianLightBehaviour() {
        return new SimplePedestrianLightBehaviour();
    }

    @Override
    public LightBehaviour createExtendedPedestrianLightBehaviour() {
        return new ExtendedPedestrianLightBehaviour();
    }

    @Override
    public LightBehaviour createCustomPedestrianLightBehaviour() {
        return new CustomPedestrianLightBehaviour();
    }

    @Override
    public LightBehaviour createEmergencyPedestrianLightBehaviour() {
        return new EmergencyPedestrianLightBehaviour();
    }

    @Override
    public LightBehaviour createSimpleStreetLightBehaviour() {
        return new SimpleStreetLightBehaviour();
    }
}
