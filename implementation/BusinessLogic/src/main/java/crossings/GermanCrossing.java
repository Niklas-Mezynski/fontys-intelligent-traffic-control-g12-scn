package crossings;

import interfaces.PedestrianTrafficLight;
import interfaces.StreetTrafficLight;

public class GermanCrossing extends CrossingBase{

    public GermanCrossing(PedestrianTrafficLight horizontalPedestrianTrafficLight, PedestrianTrafficLight verticalPedestrianTrafficLight, StreetTrafficLight horizontalStraight, StreetTrafficLight verticalStraight) {
        super(horizontalPedestrianTrafficLight, verticalPedestrianTrafficLight, horizontalStraight, verticalStraight);
    }

    @Override
    public void startHorizontalTrafficLights() {
        // Stop all vertical
        stopAllVertical();

        // Start horizontal Pedestrian
        startHorizontalStraight();

        // Stop pedestrian horizontal
        startHorizontalRight();

        stopAllHorizontal();
        startHorizontalLeft();
        System.out.println();
    }

    @Override
    public void startVerticalTrafficLights() {
        stopAllHorizontal();

        startVerticalStraight();

        startVerticalRight();

        stopAllVertical();
        startVerticalLeft();
        System.out.println();
    }
}
