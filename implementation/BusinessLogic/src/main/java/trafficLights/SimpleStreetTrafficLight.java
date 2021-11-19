package trafficLights;

import interfaces.*;
import shapes.DotShape;

/**
 * Instance object implementing StreetTrafficLight interface
 *
 */
public class SimpleStreetTrafficLight extends TrafficLightBase implements StreetTrafficLight {
    private StreetLightState currentState;

    public SimpleStreetTrafficLight(StreetLightState initialState, String name) {
        super(name);
        this.currentState = initialState;
    }

    @Override
    public void changeState(StreetLightState newState) {
        currentState = newState;
    }

    @Override
    public void stopTraffic() {
        if (currentState.stateMeaning() == LightState.LightStateMeaning.EMERGENCY)
            return;
        while(currentState.stateMeaning() != LightState.LightStateMeaning.STOP){
            currentState.changeState(this);
        }
    }

    @Override
    public void startTraffic() {
        if (currentState.stateMeaning() == LightState.LightStateMeaning.EMERGENCY)
            return;
        while(currentState.stateMeaning() != LightState.LightStateMeaning.PASS){
            currentState.changeState(this);
        }
    }

    @Override
    public StreetLightState getCurrentState() {
        return currentState;
    }
}
