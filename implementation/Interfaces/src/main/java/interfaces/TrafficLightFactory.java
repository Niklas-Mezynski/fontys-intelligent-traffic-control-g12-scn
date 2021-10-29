package interfaces;

/**
 * Factory used to create PedestrianTrafficLight instances
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public interface TrafficLightFactory {
    /**
     * Creates PedestrianTrafficLight without behaviour
     *
     * @return new PedestrianTrafficLight instance
     */
    TrafficLight createEmptyPedestrianTrafficLight();

    /**
     * Creates StreetTrafficLight without behaviour
     *
     * @return new StreetTrafficLight instance
     */
    TrafficLight createEmptyStreetTrafficLight();

    /**
     * Creates PedestrianTrafficLight with simple behaviour
     *
     * @return new PedestrianTrafficLight instance
     */
    TrafficLight createSimplePedestrianTrafficLight();

    /**
     * Creates PedestrianTrafficLight with extended behaviour
     *
     * @return new PedestrianTrafficLight instance
     */
    TrafficLight createExtendedPedestrianTrafficLight();

    /**
     * Creates PedestrianTrafficLight with custom behaviour
     *
     * @return new PedestrianTrafficLight instance
     */
    TrafficLight createCustomPedestrianTrafficLight();

    /**
     * Creates SimpleStreetTrafficLight with simple behaviour
     *
     * @return new SimpleStreetTrafficLight instance
     */
    TrafficLight createSimpleStreetTrafficLight();
}
