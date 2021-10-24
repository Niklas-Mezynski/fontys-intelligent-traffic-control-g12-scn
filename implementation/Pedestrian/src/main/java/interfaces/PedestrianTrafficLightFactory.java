package interfaces;

/**
 * Factory used to create PedestrianTrafficLight instances
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public interface PedestrianTrafficLightFactory {
    /**
     * Creates PedestrianTrafficLight
     *
     * @return new PedestrianTrafficLight instance
     */
    PedestrianTrafficLight createPedestrianTrafficLight();
}
