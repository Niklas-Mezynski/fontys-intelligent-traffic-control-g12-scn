package factories;

import interfaces.Pedestrian;
import interfaces.PedestrianFactory;
import interfaces.PedestrianPlatform;
import pedestrians.Jogger;
import pedestrians.Skateboarder;
import pedestrians.Walker;

/**
 * Implementation of PedestrianFactory
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class SimplePedestrianFactory implements PedestrianFactory {

    @Override
    public Pedestrian createWalker(String name, PedestrianPlatform destination) {
        return new Walker(name, destination);
    }

    @Override
    public Pedestrian createJogger(String name, PedestrianPlatform destination) {
        return new Jogger(name, destination);
    }

    @Override
    public Pedestrian createSkateboarder(String name, PedestrianPlatform destination) {
        return new Skateboarder(name, destination);
    }
}
