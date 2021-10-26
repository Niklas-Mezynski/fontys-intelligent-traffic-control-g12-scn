package pedestrians;

import interfaces.PedestrianPlatform;

/**
 * Pedestrian object of type Skateboarder.
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class Skateboarder extends SimplePedestrian {
    public Skateboarder(String name, PedestrianPlatform destination){
        super( name, destination);
    }

    @Override
    public String getName() {
        return "skateboarder " + super.getName();
    }

    @Override
    public String getAction() {
        return "skateboarding";
    }
}
