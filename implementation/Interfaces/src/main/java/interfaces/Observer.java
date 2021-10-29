package interfaces;

/**
 * Interface for Observer objects.
 * Observers are notified when the Subject they are observing changes state.
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public interface Observer {
    /**
     * Used to notify observer when subject changes state
     *
     * @param isPassAllowed shows whether the signal allows passing or not
     * @param length shows the length of the signal (number of pedestrians that can pass during one signal)
     * @param nextName shows the name of the other observer part of the pair (one traffic light contains one pair observers/platforms)
     */
    void update(boolean isPassAllowed, int length, String nextName);

    /**
     * Returns name of Observer
     *
     * @return name of observer
     */
    String getName();
}

