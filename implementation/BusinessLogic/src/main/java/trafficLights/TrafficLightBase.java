package trafficLights;

import interfaces.*;
import shapes.DotShape;

import java.util.ArrayList;
import java.util.List;

/**
 * Instance object implementing TrafficLight interface
 *
 */
public abstract class TrafficLightBase implements TrafficLight {
    private Shape shape;
    private final String name;
    private final List<LightObserver> lightObservers;
    private final List<ShapeObserver> shapeObservers;

    public TrafficLightBase(String name){
        this.name = name;
        shape = new DotShape();
        lightObservers = new ArrayList<>();
        shapeObservers = new ArrayList<>();
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
        informForShapeChange();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                " currentState = " + getCurrentState() +
                ", shape = " + shape +
                " }";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addLightObserver(LightObserver o) {
        lightObservers.add(o);
    }

    @Override
    public void removeLightObserver(LightObserver o) {
        lightObservers.remove(o);
    }

    @Override
    public void informForLightChange() {
        lightObservers.forEach(s -> s.update(getCurrentState()));
    }

    @Override
    public void addShapeObserver(ShapeObserver o) {
        shapeObservers.add(o);
    }

    @Override
    public void removeShapeObserver(ShapeObserver o) {
        shapeObservers.remove(o);
    }

    @Override
    public void informForShapeChange() {
        shapeObservers.forEach(s -> s.update(getShape()));
    }
}
