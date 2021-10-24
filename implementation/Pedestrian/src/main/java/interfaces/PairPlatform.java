package interfaces;

/**
 * Interface for PairPlatform objects such as End and Start platforms.
 * PairPlatforms are simple platforms which have only one pair platform accessible.
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public interface PairPlatform extends Platform{
    /**
     * Getter for pair platform
     *
     * @return pair platform
     */
    Platform getPairPlatform();

    /**
     * Setter for pair platform
     *
     * @param other platform to be paired with
     */
    void setPairPlatform(Platform other);

    /**
     * Returns first pedestrian in the queue
     *
     * @return first pedestrian in the queue
     */
    Pedestrian getFirstInQueue();
}
