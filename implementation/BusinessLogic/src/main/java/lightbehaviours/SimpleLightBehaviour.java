package lightbehaviours;

import interfaces.LightBehaviour;
import interfaces.Shape;
import interfaces.TrafficLight;
import interfaces.State;

/** SimpleLightBehaviour base
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public abstract class SimpleLightBehaviour implements LightBehaviour {
    private final TrafficLight trafficLight;
    private boolean isActive = false;

    State currentState;

    public SimpleLightBehaviour(TrafficLight traffic){
        this.trafficLight = traffic;
    }

    @Override
    public TrafficLight getTrafficLight() {
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
        isActive = true;
        this.currentState.requestStateChange();
    }

    @Override
    public boolean isActive() {
        return this.isActive;
    }

    @Override
    public void setActive(boolean bool) {
        this.isActive = bool;
    }

    @Override
    public Shape getShape() {
        return this.trafficLight.getShape();
    }
}
