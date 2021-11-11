package interfaces;

/**
 * Interface for LightState
 *
 */
public interface LightState {
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
