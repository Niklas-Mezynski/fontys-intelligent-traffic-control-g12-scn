package lightbehaviours;

import interfaces.TrafficLight;
import states.*;

/** SimpleStreetLightBehaviour extension of SimpleLightBehaviour
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class SimpleStreetLightBehaviour extends SimpleLightBehaviour {
    StateBase RED_LIGHT = new RedLightState(this, "red light", false, 2);
    StateBase GREEN_LIGHT = new GreenLightState(this, RED_LIGHT, "green light", true, 2);
    StateBase YELLOW_LIGHT = new YellowLightState(this, GREEN_LIGHT, "yellow light", true, 1);

    public SimpleStreetLightBehaviour(TrafficLight traffic){
        super(traffic);
        RED_LIGHT.setNextState(YELLOW_LIGHT);
        currentState = RED_LIGHT;
    }
}
