package interfaces;

import pedestrianstates.State;

/**
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public interface PedestrianLightBehaviour {
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
     * Prints current light in text form
     */
    void printCurrentLight();

    /**
     * Getter for traffic light
     *
     * @return traffic light of this behaviour
     */
    PedestrianTrafficLight getTrafficLight();

    /**
     * Checks if button of traffic light has been pushed
     *
     * @return boolean value of button being pushed
     */
    boolean buttonIsPushed();

    /**
     * Setter for button pushed state
     *
     * @param bool of the new button pushed state
     */
    void setButtonPushed(boolean bool);
}
