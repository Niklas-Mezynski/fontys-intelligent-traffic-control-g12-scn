package factories;

import interfaces.FourWayPlatform;
import interfaces.PairPlatform;
import interfaces.PedestrianPlatformFactory;
import interfaces.TwoWayPlatform;
import locations.SimpleFourWayPedestrianPlatform;
import locations.SimplePairPedestrianPlatform;
import locations.SimpleTwoWayPedestrianPlatform;

/**
 * Implementation of PedestrianPlatformFactory
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class SimplePedestrianPlatformFactory implements PedestrianPlatformFactory {

    @Override
    public PairPlatform createPairPlatform(String name, int x, int y) {
        return new SimplePairPedestrianPlatform(name, x, y);
    }

    @Override
    public FourWayPlatform createFourWayPlatform(String name, int x, int y) {
        return new SimpleFourWayPedestrianPlatform(name, x, y);
    }

    @Override
    public TwoWayPlatform createTwoWayPlatform(String name, int x, int y) {
        return new SimpleTwoWayPedestrianPlatform(name, x, y);
    }
}
