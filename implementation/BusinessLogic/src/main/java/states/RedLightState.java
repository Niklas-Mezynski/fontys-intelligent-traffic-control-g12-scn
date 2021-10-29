package states;

import interfaces.LightBehaviour;
import interfaces.State;

/**
 * Red light state
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class RedLightState extends StateBase {

    public RedLightState(LightBehaviour light, State next, String name, boolean canPass, int length){
        super(light, next, name, canPass, length);
    }
    
    public RedLightState(LightBehaviour light, String name, boolean canPass, int length){
        super(light, name, canPass, length);
    }
    
    @Override
    public void requestStateChange() {
        if(this.lightBehaviour.isActive()){
            this.lightBehaviour.setActive(false);
            changeState();
        }
    }
}
