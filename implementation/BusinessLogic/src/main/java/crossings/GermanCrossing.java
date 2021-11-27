package crossings;

import interfaces.PedestrianTrafficLight;
import interfaces.StreetTrafficLight;

import java.util.TimerTask;

public class GermanCrossing extends CrossingBase{

    public GermanCrossing(PedestrianTrafficLight horizontalPedestrianTrafficLight, PedestrianTrafficLight verticalPedestrianTrafficLight, StreetTrafficLight horizontalStraight, StreetTrafficLight verticalStraight) {
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

                // Start horizontal straight
                System.out.println("\n2. Starting horizontal straight traffic");
                startHorizontalStraight();
            }
        }, 0, length * 3L);

        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                // Stop pedestrian horizontal
                System.out.println("\n3. Starting horizontal right traffic");
                startHorizontalRight();
            }
        }, length/2, length* 3L);

        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                System.out.println("\n4. Starting horizontal right traffic");
                stopAllHorizontal();
                startHorizontalLeft();

                System.out.println("\n--- Horizontal traffic started!---\n");
            }
        }, length, length* 3L);


        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                System.out.println("\n--- Starting vertical traffic ---\n");
                System.out.println("1. Stopping horizontal traffic");
                stopAllHorizontal();

                System.out.println("\n2. Starting vertical straight traffic");
                startVerticalStraight();
            }
        }, length + length/2, length*3L);

        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                // Stop pedestrian horizontal
                System.out.println("\n3. Starting vertical right traffic");
                startVerticalRight();
            }
        }, length* 2L, length*3L);

        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                System.out.println("\n4. Starting vertical right traffic");
                stopAllVertical();
                startVerticalLeft();

                System.out.println("\n--- Vertical traffic started!---\n");
            }
        }, length*2L + length/2, length*3L);

    }
}
