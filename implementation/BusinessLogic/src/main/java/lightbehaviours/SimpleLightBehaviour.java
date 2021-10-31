package lightbehaviours;

import interfaces.*;
import shapes.DotShape;

/** SimpleLightBehaviour base
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public abstract class SimpleLightBehaviour implements LightBehaviour {
    private Shape shape = new DotShape();
    private boolean isActive = false;
    private Subject subject;

    State currentState;

    @Override
    public State getCurrentState() {
        return this.currentState;
    }

    @Override
    public void setCurrentState(State state) {
        this.currentState = state;
    }
    
    @Override
    public void activateChange() {
        isActive = true;
        this.currentState.requestStateChange();
    }

    @Override
    public boolean isActive() {
        return this.isActive;
    }

    @Override
    public void setActive(boolean bool) {
        this.isActive = bool;
    }

    @Override
    public Shape getShape() {
        return this.shape;
    }

    @Override
    public void setShape(Shape shape){
        this.shape = shape;
    }

    @Override
    public void setSubject(Subject sub){
        this.subject = sub;
    }

    @Override
    public void informSubject(){
        this.subject.inform();
    }

}
