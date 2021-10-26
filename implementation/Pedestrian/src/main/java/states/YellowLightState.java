package states;

import interfaces.LightBehaviour;

/**
 * Yellow light state
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class YellowLightState extends State{

    public YellowLightState(LightBehaviour light, State next, String name, boolean canPass, int length){
        super(light, next, name, canPass, length);
    }

    public YellowLightState(LightBehaviour light, String name, boolean canPass, int length){
        super(light, name, canPass, length);
    }
    @Override
    public void requestStateChange() {
        System.out.println(this.name + " with length " + length);
        changeState();
    }
}
