package interfaces;

import java.util.List;

/**
 * Interface for Platform objects.
 * Platforms are locations where pedestrians wait for traffic light signals.
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public interface PedestrianPlatform extends Observer{
    /**
     * Adds Pedestrian to Platform
     *
     * @param p pedestrian to be added
     */
    void addPedestrian(Pedestrian p);

    /**
     * Adds Pedestrians to Platform
     *
     * @param p list of pedestrians to be added
     */
    void addPedestrians(List<Pedestrian> p);

    /**
     * Getter for x Coordinate
     *
     * @return x Coordinate
     */
    int getXCoordinate();

    /**
     * Getter for y Coordinate
     *
     * @return y Coordinate
     */
    int getYCoordinate();
}
