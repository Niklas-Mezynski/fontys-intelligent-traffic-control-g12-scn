package interfaces;

/**
 * Factory used to create Pedestrian instances of different types
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public interface PedestrianFactory {
    /**
     * Creates Pedestrian of type Walker
     *
     * @param name of pedestrian
     * @param destination of pedestrian
     * @return new Walker instance
     */
    Pedestrian createWalker(String name, Platform destination);

    /**
     * Creates Pedestrian of type Jogger
     *
     * @param name of pedestrian
     * @param destination of pedestrian
     * @return new Jogger instance
     */
    Pedestrian createJogger(String name, Platform destination);

    /**
     * Creates Pedestrian of type Skateboarder
     *
     * @param name of pedestrian
     * @param destination of pedestrian
     * @return new Skateboarder instance
     */
    Pedestrian createSkateboarder(String name, Platform destination);
}
