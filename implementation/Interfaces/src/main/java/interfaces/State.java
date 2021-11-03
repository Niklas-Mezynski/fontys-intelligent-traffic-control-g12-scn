package interfaces;

/**
 * Interface for State
 *
 */
public interface State {

    /**
     * Getter for the next state
     *
     */
    State getNext();

    /**
     * Used to change the state of the traffic light
     *
     * @param light traffic light to change the state of
     *
     */
    default void changeState(TrafficLight light) {
        System.out.println("Changing from " + light.getCurrentState() + " -> " + getNext());
        light.changeState(getNext());
    }

    /**
     * Returns boolean indicating whether signal allows passing
     *
     */
    boolean canPass();

    /**
     * Returns length of the signal
     *
     */
    int length();

    /**
     * Returns name of the signal
     *
     */
    String getName();
}
