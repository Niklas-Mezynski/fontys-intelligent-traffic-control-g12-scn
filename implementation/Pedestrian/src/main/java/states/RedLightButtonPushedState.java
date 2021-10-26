package states;

import interfaces.LightBehaviour;

/**
 * Red light with button pushed state
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class RedLightButtonPushedState extends State{

    public RedLightButtonPushedState(LightBehaviour light, State next, String name, boolean canPass, int length){
        super(light, next, name, canPass, length);
    }

    public RedLightButtonPushedState(LightBehaviour light, String name, boolean canPass, int length){
        super(light, name, canPass, length);
    }
    @Override
    public void requestStateChange() {
        System.out.println(this.name + " with length " + length);
        changeState();
    }
}
