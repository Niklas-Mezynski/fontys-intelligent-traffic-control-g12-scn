package interfaces;

import states.State;

/**
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public interface PedestrianLightBehaviour {
    PedestrianTrafficLight getTrafficLight();
    
    State getCurrentState();

    void setCurrentState(State state);
    
    void activateChange();
    
    boolean buttonIsPushed();
    
    void setButtonPushed(boolean bool);
}
