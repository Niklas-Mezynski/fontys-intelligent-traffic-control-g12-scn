package states;

import interfaces.LightBehaviour;
import interfaces.State;

/**
 * Abstract base class for State objects.
 * States are light states of the light behaviour.
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public abstract class StateBase implements State {
    protected String name;
    protected boolean canPass;
    protected int length;
    protected State nextState;
    protected LightBehaviour lightBehaviour;

    /**
     * Constructor for state
     *
     * @param name of the state
     * @param light behaviour of the state
     * @param canPass boolean showing whether the state allows passing
     * @param length of the state (number of pedestrians that can pass during single signal)
     */
    public StateBase(LightBehaviour light, String name, boolean canPass, int length){
        this.lightBehaviour = light;
        this.name = name;
        this.canPass = canPass;
        this.length = length;
    }

    /**
     * Constructor for state
     *
     * @param name of the state
     * @param light behaviour of the state
     * @param next state after this state
     * @param canPass boolean showing whether the state allows passing
     * @param length of the state (number of pedestrians that can pass during single signal)
     */
    public StateBase(LightBehaviour light, State next, String name, boolean canPass, int length){
        this.lightBehaviour = light;
        this.nextState = next;
        this.name = name;
        this.canPass = canPass;
        this.length = length;
    }

    /**
     * Getter for PedestrianLightBehaviour
     *
     * @return PedestrianLightBehaviour of the state
     */
    public LightBehaviour getLightBehaviour() {
        return this.lightBehaviour;
    }

    /**
     * Requests a change of the state
     */
    public abstract void requestStateChange();

    /**
     * Getter for name of state
     *
     * @return name of the state
     */
    public String getName() {
        return this.name;
    }

    /**
     * Prints state transition from current to next
     */
    public void printTransition(){
        System.out.println("transition from " + this.name + " to " + nextState + " (" + this.lightBehaviour.getShape() + ")");
    }

    /**
     * Changes state from current to next
     */
    public void changeState() {
        this.lightBehaviour.informSubject();
        this.printTransition();
        this.lightBehaviour.setCurrentState(nextState);
        this.lightBehaviour.getCurrentState().requestStateChange();
    }

    /**
     * Setter for next state of current state
     *
     * @param state next state of the current state
     */
    @Override
    public void setNextState(State state){
        this.nextState = state;
    }

    /**
     * Returns String representation of state
     *
     * @return String representation of state
     */
    @Override
    public String toString(){
        return getName();
    }

    /**
     * Returns boolean value whether the pedestrian passing is allowed
     *
     * @return boolean value of passing allowed
     */
    public boolean isPassAllowed() {
        return canPass;
    }

    /**
     * Returns length of signal
     *
     * @return length of signal showing number of pedestrians that can pass during one signal
     */
    public int getLength() {
        return length;
    }
}
