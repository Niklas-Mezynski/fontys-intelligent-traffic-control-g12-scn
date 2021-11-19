package trafficLights;

import interfaces.LightState;
import interfaces.Shape;
import interfaces.TrafficLight;
import shapes.DotShape;

/**
 * Instance object implementing TrafficLight interface
 *
 */
public abstract class PedestrianTrafficLightBase implements TrafficLight {
    private Shape shape = new DotShape();

    @Override
    public abstract void stopTraffic();

    @Override
    public abstract void startTraffic();

    @Override
    public abstract LightState getCurrentState();

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
        return getClass().getSimpleName() + "{" +
                " currentState = " + getCurrentState() +
                ", shape = " + shape +
                " }";
    }
}
