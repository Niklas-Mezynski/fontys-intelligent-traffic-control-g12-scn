package interfaces;
/**
 * Interface for TrafficLight
 *
 */
public interface TrafficLight {

    /**
     * Changes state of the traffic light
     *
     * @param state to which the change is transitioning
     *
     */
    void changeState(State state);

    /**
     * Used to loop through all passing states
     *
     */
    void stopTraffic();

    /**
     * Used to loop through all non-passing states
     *
     */
    void startTraffic();

    /**
     * Returns current state
     *
     */
    State getCurrentState();

}
