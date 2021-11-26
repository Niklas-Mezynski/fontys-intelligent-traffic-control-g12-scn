package crossings;

import interfaces.PedestrianTrafficLight;
import interfaces.StreetTrafficLight;

public class SimpleCrossing extends CrossingBase{

    public SimpleCrossing(PedestrianTrafficLight horizontalPedestrianTrafficLight, PedestrianTrafficLight verticalPedestrianTrafficLight, StreetTrafficLight horizontalStraight, StreetTrafficLight verticalStraight) {
        super(horizontalPedestrianTrafficLight, verticalPedestrianTrafficLight, horizontalStraight, verticalStraight);
    }

    @Override
    public void startHorizontalTrafficLights() {
        // Stop all vertical
        stopAllVertical();

        // Start horizontal Pedestrian
        startHorizontalStraight();
    }

    @Override
    public void startVerticalTrafficLights() {
        stopAllHorizontal();

        startVerticalStraight();
    }
}
