package interfaces;

/**
 * Interface for State.
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public interface State {
    /**
     * Getter for PedestrianLightBehaviour
     *
     * @return PedestrianLightBehaviour of the state
     */
    LightBehaviour getLightBehaviour();

    /**
     * Requests a change of the state
     */
    void requestStateChange();

    /**
     * Getter for name of state
     *
     * @return name of the state
     */
     String getName();

    /**
     * Prints state transition from current to next
     */
     void printTransition();

    /**
     * Changes state from current to next
     */
    void changeState() ;

    /**
     * Setter for next state of current state
     *
     * @param state next state of the current state
     */
    void setNextState(State state);

    /**
     * Returns String representation of state
     *
     * @return String representation of state
     */
    @Override
    String toString();

    /**
     * Returns boolean value whether the pedestrian passing is allowed
     *
     * @return boolean value of passing allowed
     */
    boolean isPassAllowed();

    /**
     * Returns length of signal
     *
     * @return length of signal showing number of pedestrians that can pass during one signal
     */
    int getLength();
}
