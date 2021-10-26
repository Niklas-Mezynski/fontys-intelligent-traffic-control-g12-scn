package interfaces;

/**
 * Factory used to create Platform instances of different types
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public interface PedestrianPlatformFactory {
    /**
     * Creates Platform of type PairPlatform
     *
     * @param name of the platform
     * @param x coordinate of the platform
     * @param y coordinate of the platform
     * @return new PairPlatform instance
     */
    PairPedestrianPlatform createPairPlatform(String name, int x, int y);

    /**
     * Creates Platform of type FourWayPlatform
     *
     * @param name of the platform
     * @param x coordinate of the platform
     * @param y coordinate of the platform
     * @return new FourWayPlatform instance
     */
    FourWayPedestrianPlatform createFourWayPlatform(String name, int x, int y);

    /**
     * Creates Platform of type TwoWayPlatform
     *
     * @param name of the platform
     * @param x coordinate of the platform
     * @param y coordinate of the platform
     * @return new TwoWayPlatform instance
     */
    TwoWayPedestrianPlatform createTwoWayPlatform(String name, int x, int y);
}
