package pedestrians;

import interfaces.Platform;

/**
 * Pedestrian object of type Walker.
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class Walker extends SimplePedestrian {
    public Walker(String name, Platform destination){
        super( name, destination);
    }

    @Override
    public String getName() {
        return "walker " + super.getName();
    }

    @Override
    public String getAction() {
        return "walking";
    }
}
