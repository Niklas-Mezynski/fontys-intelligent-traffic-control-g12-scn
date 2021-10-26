package pedestrianstates;

import interfaces.PedestrianLightBehaviour;

/**
 * Green light state
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class GreenLightState extends State{

    public GreenLightState(PedestrianLightBehaviour light, State next, String name, boolean canPass, int length){
        super(light, next, name, canPass, length);
    }

    public GreenLightState(PedestrianLightBehaviour light, String name, boolean canPass, int length){
        super(light, name, canPass, length);
    }
    @Override
    public void requestStateChange() {
        System.out.println(this.name + " with length " + length);
        changeState();
    }
}
