package interfaces;

import pedestrianstates.State;

/**
 * Interface for PedestrianTrafficLight objects.
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public interface PedestrianTrafficLight extends Subject{
    /**
     * Getter for light state of the traffic light
     *
     * @return state of light behaviour of the traffic light
     */
    State getCurrentState();

    /**
     * Getter for traffic light shape
     *
     * @return shape of the traffic light
     */
    Shape getShape();

    /**
     * Setter for traffic light shape
     *
     * @param shape of the traffic light
     */
    void setShape(Shape shape);

    /**
     * Prints current light state in text form
     */
    void printCurrentLight();

    /**
     * Setter for traffic light behaviour
     *
     * @param light behaviour of the traffic light
     */
    void setPedestrianLightBehaviour(PedestrianLightBehaviour light);

    /**
     * Getter for traffic light behaviour
     *
     * @return light behaviour of the traffic light
     */
    PedestrianLightBehaviour getPedestrianLightBehaviour();

    /**
     * Used when physical button of traffic light is pushed by pedestrian
     */
    void pushButton();
}
