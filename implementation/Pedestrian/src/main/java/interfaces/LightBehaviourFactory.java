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
     * @param light trafficLight of the behaviour
     * @return new SimplePedestrianLightBehaviour instance
     */
    LightBehaviour createSimplePedestrianLightBehaviour(TrafficLight light);

    /**
     * Creates LightBehaviour of type ExtendedPedestrianLightBehaviour
     *
     * @param light trafficLight of the behaviour
     * @return new ExtendedPedestrianLightBehaviour instance
     */
    LightBehaviour createExtendedPedestrianLightBehaviour(TrafficLight light);

    /**
     * Creates LightBehaviour of type CustomPedestrianLightBehaviour
     *
     * @param light trafficLight of the behaviour
     * @return new CustomPedestrianLightBehaviour instance
     */
    LightBehaviour createCustomPedestrianLightBehaviour(TrafficLight light);

    /**
     * Creates LightBehaviour of type SimpleStreetLightBehaviour
     *
     * @param light trafficLight of the behaviour
     * @return new SimpleStreetLightBehaviour instance
     */
    LightBehaviour createSimpleStreetLightBehaviour(TrafficLight light);
}
