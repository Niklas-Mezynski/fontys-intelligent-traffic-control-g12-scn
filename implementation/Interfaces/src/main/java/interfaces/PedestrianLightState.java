package interfaces;

/**
 * Interface for PedestrianLightState
 *
 */
public interface PedestrianLightState extends LightState {
    /**
     * Getter for the next state
     *
     */
    PedestrianLightState getNext();

    /**
     * Used to change the state of the traffic light
     *
     * @param light traffic light to change the state of
     *
     */
    default void changeState(PedestrianTrafficLight light) {
        System.out.println("Changing from " + light.getCurrentState() + " -> " + getNext());
        light.changeState(getNext());
    }
}
