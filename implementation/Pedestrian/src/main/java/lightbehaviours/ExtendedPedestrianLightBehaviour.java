package lightbehaviours;

import interfaces.TrafficLight;
import states.GreenBlinkingLightState;
import states.GreenLightState;
import states.RedLightButtonPushedState;
import states.RedLightState;
import states.State;

/** ExtendedPedestrianLightBehaviour extension of SimpleLightBehaviour
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class ExtendedPedestrianLightBehaviour  extends SimpleLightBehaviour {
    State RED_LIGHT = new RedLightState(this, "red light", false, 7);
    State GREEN_BLINKING_LIGHT = new GreenBlinkingLightState(this, RED_LIGHT, "green blinking light", true, 3);
    State GREEN_LIGHT = new GreenLightState(this, GREEN_BLINKING_LIGHT, "green light", true, 7);
    State RED_LIGHT_BUTTON_PUSHED = new RedLightButtonPushedState(this, GREEN_LIGHT, "red light with button pushed", false, 3);

    public ExtendedPedestrianLightBehaviour(TrafficLight traffic){
        super(traffic);
        RED_LIGHT.setNextState(RED_LIGHT_BUTTON_PUSHED);
        currentState = RED_LIGHT;
    }
}
