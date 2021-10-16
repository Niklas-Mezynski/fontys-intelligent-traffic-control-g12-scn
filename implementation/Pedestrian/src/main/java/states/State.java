package states;

import interfaces.PedestrianLightBehaviour;

/**
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public abstract class State{
    protected String name;
    protected State nextState;
    protected PedestrianLightBehaviour lightBehaviour;
    
    public State(PedestrianLightBehaviour light, String name){
        this.lightBehaviour = light;
        this.name = name;
    }
    
    public State(PedestrianLightBehaviour light, State next, String name){
        this.lightBehaviour = light;
        this.nextState = next;
        this.name = name;
    }

    public PedestrianLightBehaviour getLightBehaviour() {
        return this.lightBehaviour;
    }

    public abstract void requestStateChange();

    public String getName() {
        return this.name;
    }
    
    public void printTransition(){
        System.out.println("from " + getName() + " to " + nextState.getName());
    }
    
    public void changeState() {
        this.printTransition();
        this.lightBehaviour.setCurrentState(nextState);
        this.lightBehaviour.getCurrentState().requestStateChange();
    }
    
    public void setNextState(State state){
        this.nextState = state;
    }
    
}
