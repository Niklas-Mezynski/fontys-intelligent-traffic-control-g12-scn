package interfaces;

import java.util.Optional;


/**
 * The crossing entity which holds the different pedestrian and street traffic lights
 * A crossing always has 2 pedestrian traffic lights for the vertical and horizontal direction
 * A crossing always has at least  2 street traffic lights for the vertical and horizontal direction
 */
public interface Crossing {

    /**
     * Method to start the crossing cycle
     * @param length the length in millis for one complete cycle
     */
    void activate(int length);

    /**
     * Stops the crossing cycle
     */
    void deactivate();

    /**
     * Starts all traffic lights for the horizontal direction
     */
    void startHorizontalTrafficLights();

    /**
     * Starts all traffic lights for the vertical direction
     */
    void startVerticalTrafficLights();

    void addHorizontalLeft(StreetTrafficLight light);

    void addHorizontalRight(StreetTrafficLight light);

    void addVerticalLeft(StreetTrafficLight light);

    void addVerticalRight(StreetTrafficLight light);


    /**
     * Stops all traffic lights for the vertical direction
     */
    void stopAllVertical();

    /**
     * Stops all traffic lights for the horizontal direction
     */
    void stopAllHorizontal();


    /**
     * Only starts the horizontal traffic lights allowing to go straight
     */
    void startHorizontalStraight();

    /**
     * Only starts the vertical traffic lights allowing to go straight
     */
    void startVerticalStraight();

    /**
     * Starts the horizontal traffic lights allowing to turn right, the pedestrian lights will stop then
     */
    void startHorizontalRight();

    /**
     * Only starts the horizontal traffic lights allowing to turn left, everything else will stop
     */
    void startHorizontalLeft();

    /**
     * Starts the vertical traffic lights allowing to turn right, the pedestrian lights will stop then
     */
    void startVerticalRight();

    /**
     * Only starts the vertical traffic lights allowing to turn left, everything else will stop
     */
    void startVerticalLeft();
}
