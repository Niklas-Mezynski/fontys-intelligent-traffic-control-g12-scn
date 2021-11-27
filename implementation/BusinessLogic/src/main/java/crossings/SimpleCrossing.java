package crossings;

import interfaces.PedestrianTrafficLight;
import interfaces.StreetTrafficLight;

import java.util.TimerTask;

public class SimpleCrossing extends CrossingBase{

    public SimpleCrossing(PedestrianTrafficLight horizontalPedestrianTrafficLight, PedestrianTrafficLight verticalPedestrianTrafficLight, StreetTrafficLight horizontalStraight, StreetTrafficLight verticalStraight) {
        super(horizontalPedestrianTrafficLight, verticalPedestrianTrafficLight, horizontalStraight, verticalStraight);
    }

    @Override
    public void activate(int length) {
        resetTimer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                System.out.println("\n--- Starting horizontal traffic ---\n");
                // Stop all vertical
                System.out.println("1. Stopping vertical traffic");
                stopAllVertical();

                // Start horizontal traffic
                System.out.println("\n2. Starting horizontal traffic");
                startHorizontalStraight();
                System.out.println("\n--- Horizontal traffic started!---\n");
            }
        }, 0, length);
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                System.out.println("\n--- Starting vertical traffic ---\n");

                System.out.println("1. Stopping horizontal traffic");
                stopAllHorizontal();

                System.out.println("\n2. Starting vertical traffic");
                startVerticalStraight();
                System.out.println("\n--- Vertical traffic started!---\n");
            }
        }, length/2, length);
    }
}
