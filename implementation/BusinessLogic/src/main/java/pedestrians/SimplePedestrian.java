package pedestrians;

import interfaces.Pedestrian;
import interfaces.PedestrianPlatform;

/**
 * Abstract base class for Pedestrian objects.
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public abstract class SimplePedestrian implements Pedestrian {
    private final String name;
    private PedestrianPlatform destination;

    /**
     * Constructor for pedestrian
     *
     * @param name of the pedestrian
     * @param destination platform of the pedestrian
     */
    public SimplePedestrian(String name, PedestrianPlatform destination){
        this.name = name;
        this.destination = destination;
    }

    /**
     * Getter for name of pedestrian
     *
     * @return  name of the pedestrian
     */
    @Override
    public String getName(){
        return name;
    }

    /**
     * Getter for destination platform of pedestrian
     *
     * @return destination platform of the pedestrian
     */
    @Override
    public PedestrianPlatform getDestination() {
        return destination;
    }

    /**
     * Setter for destination platform of pedestrian
     *
     * @param destination platform of the pedestrian
     */
    @Override
    public void setDestination(PedestrianPlatform destination) {
        this.destination = destination;
    }

    /**
     * Getter for action of pedestrian
     *
     * @return String representation of the action performed by the pedestrian
     */
    @Override
    public abstract String getAction();
}
