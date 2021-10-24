package interfaces;

/**
 * Interface for Pedestrian objects
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public interface Pedestrian {
    /**
     * Returns name of Pedestrian
     *
     * @return name of pedestrian
     */
    String getName();

    /**
     * Returns destination platform of Pedestrian
     *
     * @return destination platform of pedestrian
     */
    Platform getDestination();

    /**
     * Setter for destination platform of Pedestrian
     *
     * @param destination platform of pedestrian
     */
    void setDestination(Platform destination);

    /**
     * Returns action performed by Pedestrian
     *
     * @return action performed by pedestrian
     */
    String getAction();
}
