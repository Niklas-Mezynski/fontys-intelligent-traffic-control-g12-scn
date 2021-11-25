package interfaces;
/**
 * Interface for TrafficLight
 *
 */
public interface PedestrianTrafficLight extends TrafficLight{

    /**
     * Changes state of the traffic light
     *
     * @param state to which the change is transitioning
     *
     */
    void changeState(PedestrianLightState state);

    PedestrianShape getShape();

    void setShape(PedestrianShape newShape);

}
