package interfaces;

/**
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public interface LightBehaviour {
    /**
     * Getter for current light state
     *
     * @return current light state
     */
    State getCurrentState();

    /**
     * Setter for for current light state
     *
     * @param state of the new light state
     */
    void setCurrentState(State state);

    /**
     * Activates transition of current state to next state
     */
    void activateChange();

    /**
     * Getter for the shape of the light
     *
     * @return shape of the light
     */
    Shape getShape();

    /**
     * Checks if traffic light has been activated
     *
     * @return boolean value of traffic light being active
     */
    boolean isActive();

    /**
     * Setter for activity state
     *
     * @param bool of the new activity state
     */
    void setActive(boolean bool);

    /**
     * Setter for traffic light shape
     *
     * @param shape of the traffic light
     */
    void setShape(Shape shape);

    /**
     * Setter for subject
     *
     * @param subject of the traffic light behaviour
     */
    void setSubject(Subject subject);

    /**
     * Used to inform subject
     *
     */
    void informSubject();
}
