package states;

import interfaces.LightBehaviour;
import interfaces.State;

/**
 * Yellow light blinking state
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class YellowBlinkingLightState extends StateBase {

    public YellowBlinkingLightState(LightBehaviour light, State next, String name, boolean canPass, int length){
        super(light, next, name, canPass, length);
    }

    public YellowBlinkingLightState(LightBehaviour light, String name, boolean canPass, int length){
        super(light, name, canPass, length);
    }
    @Override
    public void requestStateChange() {
        if(this.lightBehaviour.isActive()) {
            System.out.println(this.name + " with length " + length);
            this.lightBehaviour.setActive(false);
            changeState();
        }
    }
}
