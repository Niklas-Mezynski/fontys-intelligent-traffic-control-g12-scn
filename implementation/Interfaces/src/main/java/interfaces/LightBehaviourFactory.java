package interfaces;

/**
 * Factory used to create LightBehaviour instances of different types
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public interface LightBehaviourFactory {
    /**
     * Creates LightBehaviour of type SimplePedestrianLightBehaviour
     *
     * @return new SimplePedestrianLightBehaviour instance
     */
    LightBehaviour createSimplePedestrianLightBehaviour();

    /**
     * Creates LightBehaviour of type ExtendedPedestrianLightBehaviour
     *
     * @return new ExtendedPedestrianLightBehaviour instance
     */
    LightBehaviour createExtendedPedestrianLightBehaviour();

    /**
     * Creates LightBehaviour of type CustomPedestrianLightBehaviour
     *
     * @return new CustomPedestrianLightBehaviour instance
     */
    LightBehaviour createCustomPedestrianLightBehaviour();

    /**
     * Creates LightBehaviour of type EmergencyPedestrianLightBehaviour
     *
     * @return new CustomPedestrianLightBehaviour instance
     */
    LightBehaviour createEmergencyPedestrianLightBehaviour();

    /**
     * Creates LightBehaviour of type SimpleStreetLightBehaviour
     *
     * @return new SimpleStreetLightBehaviour instance
     */
    LightBehaviour createSimpleStreetLightBehaviour();
}
