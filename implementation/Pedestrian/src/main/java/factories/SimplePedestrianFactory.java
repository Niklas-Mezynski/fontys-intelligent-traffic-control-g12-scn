package factories;

import interfaces.Pedestrian;
import interfaces.PedestrianFactory;
import interfaces.Platform;
import pedestirans.Jogger;
import pedestirans.Skateboarder;
import pedestirans.Walker;

/**
 * Implementation of PedestrianFactory
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class SimplePedestrianFactory implements PedestrianFactory {

    @Override
    public Pedestrian createWalker(String name, Platform destination) {
        return new Walker(name, destination);
    }

    @Override
    public Pedestrian createJogger(String name, Platform destination) {
        return new Jogger(name, destination);
    }

    @Override
    public Pedestrian createSkateboarder(String name, Platform destination) {
        return new Skateboarder(name, destination);
    }
}
