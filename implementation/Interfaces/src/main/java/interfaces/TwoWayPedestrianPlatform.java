package interfaces;

/**
 * Interface for TwoWayPedestrianPlatform objects.
 * TwoWayPedestrianPlatform are more complex platforms which can have up to two pair platforms accessible.
 * TwoWayPedestrianPlatform can also be seen as Corner Platform as they will be used as corners of a crossing.
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public interface TwoWayPedestrianPlatform extends PedestrianPlatform {
    /**
     * Getter for Horizontal pair platform
     *
     * @return Horizontal pair platform
     */
    PedestrianPlatform getHorizontalPlatform();

    /**
     * Setter for Horizontal pair platform
     *
     * @param other pair platform
     */
    void setHorizontalPlatform(PedestrianPlatform other);

    /**
     * Getter for Vertical pair platform
     *
     * @return Vertical pair platform
     */
    PedestrianPlatform getVerticalPlatform();

    /**
     * Setter for Vertical pair platform
     *
     * @param other pair platform
     */
    void setVerticalPlatform(PedestrianPlatform other);
}
