package states;

import interfaces.PedestrianLightBehaviour;

/**
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class GreenLightState extends State{

    public GreenLightState(PedestrianLightBehaviour light, State next, String name){
        super(light, next, name);
    }
    
    public GreenLightState(PedestrianLightBehaviour light, String name){
        super(light, name);
    }
    
    @Override
    public void requestStateChange() {
        System.out.println("wait for green timer to expire");
        changeState();
    }
}
