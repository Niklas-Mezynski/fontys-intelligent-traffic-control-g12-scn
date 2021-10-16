package states;

import interfaces.PedestrianLightBehaviour;

/**
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class YellowLightState extends State{

    public YellowLightState(PedestrianLightBehaviour light, State next, String name){
        super(light, next, name);
    }

    public YellowLightState(PedestrianLightBehaviour light, String name){
        super(light, name);
    }
    
    @Override
    public void requestStateChange() {
        System.out.println(this.name + " until the timer expires");
        changeState();
    }
}
