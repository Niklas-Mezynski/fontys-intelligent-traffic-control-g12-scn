package interfaces;

/**
 * Interface for Subject objects.
 * Observers observe Subjects for their state changes.
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public interface Subject {
    /**
     * Adds observer to the list of observers
     *
     * @param o observer to be added
     */
    void addObserver(Observer o);

    /**
     * Removes observer from the list of observers
     *
     * @param o observer to be removed
     */
    void removeObserver(Observer o);

    /**
     * Informs observers for state change
     *
     * @param light name of the new light signal
     */
    void inform(String light);
}