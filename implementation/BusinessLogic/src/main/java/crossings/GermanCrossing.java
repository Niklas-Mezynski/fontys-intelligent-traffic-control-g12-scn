package crossings;

import interfaces.PedestrianTrafficLight;
import interfaces.StreetTrafficLight;

public class GermanCrossing extends CrossingBase{

    public GermanCrossing(PedestrianTrafficLight horizontalPedestrianTrafficLight, PedestrianTrafficLight verticalPedestrianTrafficLight, StreetTrafficLight horizontalStraight, StreetTrafficLight verticalStraight) {
        super(horizontalPedestrianTrafficLight, verticalPedestrianTrafficLight, horizontalStraight, verticalStraight);
    }

    @Override
    public void startHorizontalTrafficLights() {
        System.out.println("\n--- Starting horizontal traffic ---\n");
        // Stop all vertical
        System.out.println("1. Stopping vertical traffic");
        stopAllVertical();

        // Start horizontal straight
        System.out.println("\n2. Starting horizontal straight traffic");
        startHorizontalStraight();

        // Stop pedestrian horizontal
        System.out.println("\n3. Starting horizontal right traffic");
        startHorizontalRight();

        System.out.println("\n4. Starting horizontal right traffic");
        stopAllHorizontal();
        startHorizontalLeft();

        System.out.println("\n--- Horizontal traffic started!---\n");
    }

    @Override
    public void startVerticalTrafficLights() {
        System.out.println("\n--- Starting vertical traffic ---\n");
        System.out.println("1. Stopping horizontal traffic");
        stopAllHorizontal();

        System.out.println("\n4. Starting vertical straight traffic");
        startVerticalStraight();

        System.out.println("\n4. Starting vertical right traffic");
        startVerticalRight();

        System.out.println("\n4. Starting vertical right traffic");
        stopAllVertical();
        startVerticalLeft();
        System.out.println("\n--- Vertical traffic started!---\n");
    }
}
