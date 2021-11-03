package trafficLights;

import interfaces.Shape;
import interfaces.State;
import interfaces.TrafficLight;
import shapes.SimpleShape;

/**
 * Instance object implementing TrafficLight interface
 *
 */
public class SimplePedestrianTrafficLight implements TrafficLight {
    private Shape shape = new SimpleShape("Dot");
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
    public Shape getShape() {
        return shape;
    }

    @Override
    public void setShape(Shape newShape) {
        this.shape = newShape;
    }

    @Override
    public String toString() {
        return "SimplePedestrianTrafficLight{" +
                " currentState = " + currentState +
                ", shape = " + shape +
                " }";
    }
}
