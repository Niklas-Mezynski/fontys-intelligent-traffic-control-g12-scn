package trafficlights;

import interfaces.*;
import shapes.DotShape;
import states.State;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of PedestrianTrafficLight
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class SimplePedestrianTrafficLight implements PedestrianTrafficLight{
    private PedestrianLightBehaviour lightBehaviour;
    private Shape shape = new DotShape();
    private List<Observer> observers = new ArrayList<>();

    public SimplePedestrianTrafficLight(){
    }

    @Override
    public void setPedestrianLightBehaviour(PedestrianLightBehaviour light) {
        this.lightBehaviour = light;
    }

    @Override
    public PedestrianLightBehaviour getPedestrianLightBehaviour() {
        return this.lightBehaviour;
    }

    @Override
    public void pushButton() {
        if(this.lightBehaviour == null) {
            System.out.println("No light behaviour supplied yet!");
        }
        else {
            System.out.println("button pushed");
            this.lightBehaviour.activateChange();
        }
    }

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
        this.lightBehaviour.printCurrentLight();
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
    public void inform(String light) {
        var state = getCurrentState();
        observers.forEach(s -> s.update(state.isPassAllowed(), state.getLength(), getNameOfPairObserver(s)));
    }
}
