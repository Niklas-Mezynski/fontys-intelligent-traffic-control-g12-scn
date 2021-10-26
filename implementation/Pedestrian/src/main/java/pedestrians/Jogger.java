package pedestrians;

import interfaces.Platform;

/**
 * Pedestrian object of type Jogger.
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class Jogger extends SimplePedestrian {
    public Jogger(String name, Platform destination){
        super( name, destination);
    }

    @Override
    public String getName() {
        return "jogger " + super.getName();
    }

    @Override
    public String getAction() {
        return "jogging";
    }
}
