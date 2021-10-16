package states;

import interfaces.PedestrianLightBehaviour;

/**
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class GreenBlinkingLightState extends State{

    public GreenBlinkingLightState(PedestrianLightBehaviour light, State next, String name){
        super(light, next, name);
    }
    
    public GreenBlinkingLightState(PedestrianLightBehaviour light, String name){
        super(light, name);
    }
    
    @Override
    public void requestStateChange() {
        System.out.println(this.name + " until the timer expires");
        changeState();
    }
}
