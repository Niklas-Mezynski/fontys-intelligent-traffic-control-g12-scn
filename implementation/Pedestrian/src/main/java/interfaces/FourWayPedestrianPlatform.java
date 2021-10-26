package interfaces;

/**
 * Interface for FourWayPlatform objects.
 * FourWayPlatform are more complex platforms which can have up to four pair platforms accessible.
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public interface FourWayPedestrianPlatform extends PedestrianPlatform {
    /**
     * Getter for east pair platform
     *
     * @return east pair platform
     */
    PedestrianPlatform getEastPlatform();

    /**
     * Setter for east pair platform
     *
     * @param other pair platform
     */
    void setEastPlatform(PedestrianPlatform other);

    /**
     * Getter for west pair platform
     *
     * @return west pair platform
     */
    PedestrianPlatform getWestPlatform();

    /**
     * Setter for west pair platform
     *
     * @param other pair platform
     */
    void setWestPlatform(PedestrianPlatform other);

    /**
     * Getter for south pair platform
     *
     * @return south pair platform
     */
    PedestrianPlatform getSouthPlatform();

    /**
     * Setter for south pair platform
     *
     * @param other pair platform
     */
    void setSouthPlatform(PedestrianPlatform other);

    /**
     * Getter for north pair platform
     *
     * @return north pair platform
     */
    PedestrianPlatform getNorthPlatform();

    /**
     * Setter for north pair platform
     *
     * @param other pair platform
     */
    void setNorthPlatform(PedestrianPlatform other);
}
