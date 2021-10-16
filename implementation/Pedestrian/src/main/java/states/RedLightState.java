package states;

import interfaces.PedestrianLightBehaviour;

/**
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class RedLightState extends State{

    public RedLightState(PedestrianLightBehaviour light, State next, String name){
        super(light, next, name);
    }
    
    public RedLightState(PedestrianLightBehaviour light, String name){
        super(light, name);
    }
    
    @Override
    public void requestStateChange() {
        if(this.lightBehaviour.buttonIsPushed()){
            this.lightBehaviour.setButtonPushed(false);
            changeState();
        }
    }
}
