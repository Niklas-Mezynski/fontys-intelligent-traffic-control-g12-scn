package trafficLights;

import interfaces.*;

/**
 * Instance object implementing PedestrianTrafficLight interface
 *
 */
public class SimplePedestrianTrafficLight extends TrafficLightBase implements PedestrianTrafficLight {
    private PedestrianLightState currentState;

    public SimplePedestrianTrafficLight(PedestrianLightState initialState, String name) {
        super(name);
        currentState = initialState;
    }

    @Override
    public void changeState(PedestrianLightState newState) {
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
    public PedestrianLightState getCurrentState() {
        return currentState;
    }
}
