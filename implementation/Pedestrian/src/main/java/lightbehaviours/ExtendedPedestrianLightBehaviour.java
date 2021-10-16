package lightbehaviours;

import interfaces.PedestrianLightBehaviour;
import interfaces.PedestrianTrafficLight;
import interfaces.Shape;
import shapes.DotShape;
import states.GreenBlinkingLightState;
import states.GreenLightState;
import states.RedLightButtonPushedState;
import states.RedLightState;
import states.State;

/**
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class ExtendedPedestrianLightBehaviour implements PedestrianLightBehaviour{
    private final PedestrianTrafficLight trafficLight;
    private boolean buttonPushed = false;
    
    State RED_LIGHT = new RedLightState(this, "red light");
    State GREEN_BLINKING_LIGHT = new GreenBlinkingLightState(this, RED_LIGHT, "green blinking light");
    State GREEN_LIGHT = new GreenLightState(this, GREEN_BLINKING_LIGHT, "green light");
    State RED_LIGHT_BUTTON_PUSHED = new RedLightButtonPushedState(this, GREEN_LIGHT, "red light with button pushed");
    
    State currentState;
    
    public ExtendedPedestrianLightBehaviour(PedestrianTrafficLight traffic){
        this.trafficLight = traffic;
        RED_LIGHT.setNextState(RED_LIGHT_BUTTON_PUSHED);
        currentState = RED_LIGHT;
    }

    @Override
    public PedestrianTrafficLight getTrafficLight() {
        return this.trafficLight;
    }

    @Override
    public State getCurrentState() {
        return this.currentState;
    }

    @Override
    public void setCurrentState(State state) {
        this.currentState = state;
    }

    @Override
    public void activateChange() {
        buttonPushed = true;
        this.currentState.requestStateChange();
    }
    
    @Override
    public boolean buttonIsPushed() {
        return this.buttonPushed;
    }
    
    @Override
    public void setButtonPushed(boolean bool) {
        this.buttonPushed = bool;
    }

    @Override
    public Shape getShape() {
        return this.trafficLight.getShape();
    }

    @Override
    public void printCurrentLight() {
        this.currentState.printLight();
    }
}
