package trafficLights;

import interfaces.*;
import shapes.DotShape;

/**
 * Instance object implementing TrafficLight interface
 *
 */
public abstract class TrafficLightBase implements TrafficLight {
    private Shape shape = new DotShape();
    private String name;

    public TrafficLightBase(String name){
        this.name = name;
    }

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

    @Override
    public String getName(){
        return this.name;
    }
}
