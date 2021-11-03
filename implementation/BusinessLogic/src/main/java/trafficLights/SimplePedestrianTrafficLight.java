package trafficLights;

import interfaces.State;
import interfaces.TrafficLight;
/**
 * Instance object implementing TrafficLight interface
 *
 */
public class SimplePedestrianTrafficLight implements TrafficLight {

    private State currentState;

    public SimplePedestrianTrafficLight(State initialState) {
        this.currentState = initialState;
    }

    @Override
    public void changeState(State newState) {
        currentState = newState;
    }

    @Override
    public void stopTraffic() {

        while(currentState.canPass()){

            currentState.changeState(this);

        }
    }

    @Override
    public void startTraffic() {
        while(!currentState.canPass()){

            currentState.changeState(this);

        }
    }

    @Override
    public State getCurrentState() {
        return currentState;
    }

    @Override
    public String toString() {
        return "SimplePedestrianTrafficLight{" +
                "currentState=" + currentState.toString() +
                '}';
    }
}
