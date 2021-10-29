package interfaces;

/**
 * Interface for PairPedestrianPlatform objects such as End and Start platforms.
 * PairPedestrianPlatforms are simple platforms which have only one pair platform accessible.
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public interface PairPedestrianPlatform extends PedestrianPlatform {
    /**
     * Getter for pair platform
     *
     * @return pair platform
     */
    PedestrianPlatform getPairPlatform();

    /**
     * Setter for pair platform
     *
     * @param other platform to be paired with
     */
    void setPairPlatform(PedestrianPlatform other);

    /**
     * Returns first pedestrian in the queue
     *
     * @return first pedestrian in the queue
     */
    Pedestrian getFirstInQueue();
}
