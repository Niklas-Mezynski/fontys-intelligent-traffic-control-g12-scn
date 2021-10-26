package pedestrianstates;

import interfaces.PedestrianLightBehaviour;

/**
 * Red light state
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class RedLightState extends State{

    public RedLightState(PedestrianLightBehaviour light, State next, String name, boolean canPass, int length){
        super(light, next, name, canPass, length);
    }
    
    public RedLightState(PedestrianLightBehaviour light, String name, boolean canPass, int length){
        super(light, name, canPass, length);
    }
    
    @Override
    public void requestStateChange() {
        if(this.lightBehaviour.buttonIsPushed()){
            this.lightBehaviour.setButtonPushed(false);
            changeState();
        }
    }
}
