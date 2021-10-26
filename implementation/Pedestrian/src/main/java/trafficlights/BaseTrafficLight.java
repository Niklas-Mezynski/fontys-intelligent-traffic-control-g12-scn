package trafficlights;

import interfaces.LightBehaviour;
import interfaces.Observer;
import interfaces.Shape;
import interfaces.TrafficLight;
import states.State;
import shapes.DotShape;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class for TrafficLight
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public abstract class BaseTrafficLight implements TrafficLight {
    private LightBehaviour lightBehaviour;
    private Shape shape = new DotShape();
    private List<Observer> observers = new ArrayList<>();

    public BaseTrafficLight(){
    }

    @Override
    public void setLightBehaviour(LightBehaviour light) {
        this.lightBehaviour = light;
    }

    @Override
    public LightBehaviour getLightBehaviour() {
        return this.lightBehaviour;
    }

    @Override
    public void activate() {
        if(this.lightBehaviour == null) {
            System.out.println("No light behaviour supplied yet!");
        }
        else {
            printActiveMessage();
            this.lightBehaviour.activateChange();
        }
    }

    protected abstract void printActiveMessage();

    @Override
    public State getCurrentState() {
        return this.lightBehaviour.getCurrentState();
    }

    @Override
    public Shape getShape() {
        return this.shape;
    }

    @Override
    public void setShape(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void printCurrentLight() {
        System.out.println("current light: " + lightBehaviour.getCurrentState().getName() + " in " + shape);
    }

    @Override
    public void addObserver(Observer a) {
        observers.add(a);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    /**
     * Returns name of the paired observer
     *
     * @param o current observer
     * @return pair observer of current observer
     */
    public String getNameOfPairObserver(Observer o){
        var x = observers.get(0).getName();
        if(x.equals(o.getName())){
            return observers.get(1).getName();
        }
        return x;
    }

    @Override
    public void inform() {
        var state = getCurrentState();
        observers.forEach(s -> s.update(state.isPassAllowed(), state.getLength(), getNameOfPairObserver(s)));
    }
}
