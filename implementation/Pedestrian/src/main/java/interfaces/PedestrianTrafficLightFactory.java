package interfaces;

/**
 * Factory used to create PedestrianTrafficLight instances
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public interface PedestrianTrafficLightFactory {
    /**
     * Creates PedestrianTrafficLight without behaviour
     *
     * @return new PedestrianTrafficLight instance
     */
    PedestrianTrafficLight createEmptyPedestrianTrafficLight();

    /**
     * Creates PedestrianTrafficLight with simple behaviour
     *
     * @return new PedestrianTrafficLight instance
     */
    PedestrianTrafficLight createSimplePedestrianTrafficLight();

    /**
     * Creates PedestrianTrafficLight with extended behaviour
     *
     * @return new PedestrianTrafficLight instance
     */
    PedestrianTrafficLight createExtendedPedestrianTrafficLight();

    /**
     * Creates PedestrianTrafficLight with custom behaviour
     *
     * @return new PedestrianTrafficLight instance
     */
    PedestrianTrafficLight createCustomPedestrianTrafficLight();
}
