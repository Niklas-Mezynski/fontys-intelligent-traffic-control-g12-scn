package trafficLights;

import interfaces.*;
import shapes.DotShape;

/**
 * Instance object implementing PedestrianTrafficLight interface
 *
 */
public class SimplePedestrianTrafficLight extends TrafficLightBase implements PedestrianTrafficLight {
    private PedestrianLightState currentState;
    private PedestrianShape shape;
    public SimplePedestrianTrafficLight(PedestrianLightState initialState, String name) {
        super(name);
        currentState = initialState;
        this.shape = new DotShape();
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
    public void changeToNextState() {
        if (currentState.stateMeaning() == LightState.LightStateMeaning.EMERGENCY) return;
        currentState.changeState(this);
    }

    @Override
    public PedestrianLightState getCurrentState() {
        return currentState;
    }

    @Override
    public PedestrianShape getShape() {
        return shape;
    }

    @Override
    public void setShape(PedestrianShape newShape) {
        this.shape = newShape;
        informForShapeChange(newShape);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                " currentState = " + getCurrentState() +
                ", shape = " + shape +
                " }";
    }

}
