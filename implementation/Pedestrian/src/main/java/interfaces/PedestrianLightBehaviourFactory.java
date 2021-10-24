package interfaces;

/**
 * Factory used to create PedestrianLightBehaviour instances of different types
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public interface PedestrianLightBehaviourFactory {
    /**
     * Creates PedestrianLightBehaviour of type SimplePedestrianLightBehaviour
     *
     * @param light trafficLight of the behaviour
     * @return new SimplePedestrianLightBehaviour instance
     */
    PedestrianLightBehaviour createSimplePedestrianLightBehaviour(PedestrianTrafficLight light);

    /**
     * Creates PedestrianLightBehaviour of type ExtendedPedestrianLightBehaviour
     *
     * @param light trafficLight of the behaviour
     * @return new ExtendedPedestrianLightBehaviour instance
     */
    PedestrianLightBehaviour createExtendedPedestrianLightBehaviour(PedestrianTrafficLight light);

    /**
     * Creates PedestrianLightBehaviour of type CustomPedestrianLightBehaviour
     *
     * @param light trafficLight of the behaviour
     * @return new CustomPedestrianLightBehaviour instance
     */
    PedestrianLightBehaviour createCustomPedestrianLightBehaviour(PedestrianTrafficLight light);
}
