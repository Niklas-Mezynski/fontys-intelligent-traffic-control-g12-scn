package interfaces;

/**
 * Factory used to create Platform instances of different types
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public interface PedestrianPlatformFactory {
    /**
     * Creates Platform of type PairPedestrianPlatform
     *
     * @param name of the platform
     * @param x coordinate of the platform
     * @param y coordinate of the platform
     * @return new PairPedestrianPlatform instance
     */
    PairPedestrianPlatform createPairPlatform(String name, int x, int y);

    /**
     * Creates Platform of type FourWayPedestrianPlatform
     *
     * @param name of the platform
     * @param x coordinate of the platform
     * @param y coordinate of the platform
     * @return new FourWayPedestrianPlatform instance
     */
    FourWayPedestrianPlatform createFourWayPlatform(String name, int x, int y);

    /**
     * Creates Platform of type TwoWayPedestrianPlatform
     *
     * @param name of the platform
     * @param x coordinate of the platform
     * @param y coordinate of the platform
     * @return new TwoWayPedestrianPlatform instance
     */
    TwoWayPedestrianPlatform createTwoWayPlatform(String name, int x, int y);
}
