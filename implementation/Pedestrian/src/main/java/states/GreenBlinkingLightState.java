package states;

import interfaces.PedestrianLightBehaviour;

/**
 * Green light blinking state
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class GreenBlinkingLightState extends State{

    public GreenBlinkingLightState(PedestrianLightBehaviour light, State next, String name, boolean canPass, int length){
        super(light, next, name, canPass, length);
    }

    public GreenBlinkingLightState(PedestrianLightBehaviour light, String name, boolean canPass, int length){
        super(light, name, canPass, length);
    }
    @Override
    public void requestStateChange() {
        System.out.println(this.name + " with length " + length);
        changeState();
    }
}
