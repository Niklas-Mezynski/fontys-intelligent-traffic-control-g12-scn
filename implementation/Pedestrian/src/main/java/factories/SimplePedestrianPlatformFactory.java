package factories;

import interfaces.FourWayPedestrianPlatform;
import interfaces.PairPedestrianPlatform;
import interfaces.PedestrianPlatformFactory;
import interfaces.TwoWayPedestrianPlatform;
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
    public PairPedestrianPlatform createPairPlatform(String name, int x, int y) {
        return new SimplePairPedestrianPlatform(name, x, y);
    }

    @Override
    public FourWayPedestrianPlatform createFourWayPlatform(String name, int x, int y) {
        return new SimpleFourWayPedestrianPlatform(name, x, y);
    }

    @Override
    public TwoWayPedestrianPlatform createTwoWayPlatform(String name, int x, int y) {
        return new SimpleTwoWayPedestrianPlatform(name, x, y);
    }
}
