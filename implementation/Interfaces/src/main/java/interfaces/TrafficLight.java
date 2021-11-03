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
     * Changes state of the traffic light
     *
     */
    void stopTraffic();

    void startTraffic();

    State getCurrentState();

}
