package lightbehaviours;

import interfaces.TrafficLight;
import states.GreenLightState;
import states.RedLightButtonPushedState;
import states.RedLightState;
import states.State;

/** SimplePedestrianLightBehaviour extension of SimpleLightBehaviour
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class SimplePedestrianLightBehaviour  extends SimpleLightBehaviour {
    State RED_LIGHT = new RedLightState(this, "red light", false, 2);
    State GREEN_LIGHT = new GreenLightState(this, RED_LIGHT, "green light", true, 2);
    State RED_LIGHT_BUTTON_PUSHED = new RedLightButtonPushedState(this, GREEN_LIGHT, "red light with button pushed", false, 1);

    public SimplePedestrianLightBehaviour(TrafficLight traffic){
        super(traffic);
        RED_LIGHT.setNextState(RED_LIGHT_BUTTON_PUSHED);
        currentState = RED_LIGHT;
    }
}
