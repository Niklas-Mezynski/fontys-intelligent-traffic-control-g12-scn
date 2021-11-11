package interfaces;
/**
 * Interface for TrafficLight
 *
 */
public interface TrafficLight {

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
    LightState getCurrentState();

    /**
     * Returns current shape
     *
     */
    Shape getShape();

    /**
     * Setter for current shape
     *
     * @param newShape to replace the current shape
     */
    void setShape(Shape newShape);

}
