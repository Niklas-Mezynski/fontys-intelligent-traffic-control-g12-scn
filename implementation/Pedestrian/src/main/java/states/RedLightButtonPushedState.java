package states;

import interfaces.PedestrianLightBehaviour;

/**
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class RedLightButtonPushedState extends State{
       
    public RedLightButtonPushedState(PedestrianLightBehaviour light, State next, String name){
        super(light, next, name);
    }
    
    public RedLightButtonPushedState(PedestrianLightBehaviour light, String name){
        super(light, name);
    }
    
    @Override
    public void requestStateChange() {
        System.out.println("wait for request timer to expire");
        changeState();
    }
}
