package interfaces;

import states.State;

/**
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public interface PedestrianTrafficLight {
    void setPedestrianLightBehaviour(PedestrianLightBehaviour light);
    
    PedestrianLightBehaviour getPedestrianLightBehaviour();

    void pushButton();

    State getCurrentState();

    Shape getShape();

    void setShape(Shape shape);

    void printCurrentLight();
}
