package interfaces;

/**
 * Interface for FourWayPlatform objects.
 * FourWayPlatform are more complex platforms which can have up to four pair platforms accessible.
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public interface FourWayPlatform extends Platform{
    /**
     * Getter for east pair platform
     *
     * @return east pair platform
     */
    Platform getEastPlatform();

    /**
     * Setter for east pair platform
     *
     * @param other pair platform
     */
    void setEastPlatform(Platform other);

    /**
     * Getter for west pair platform
     *
     * @return west pair platform
     */
    Platform getWestPlatform();

    /**
     * Setter for west pair platform
     *
     * @param other pair platform
     */
    void setWestPlatform(Platform other);

    /**
     * Getter for south pair platform
     *
     * @return south pair platform
     */
    Platform getSouthPlatform();

    /**
     * Setter for south pair platform
     *
     * @param other pair platform
     */
    void setSouthPlatform(Platform other);

    /**
     * Getter for north pair platform
     *
     * @return north pair platform
     */
    Platform getNorthPlatform();

    /**
     * Setter for north pair platform
     *
     * @param other pair platform
     */
    void setNorthPlatform(Platform other);
}
