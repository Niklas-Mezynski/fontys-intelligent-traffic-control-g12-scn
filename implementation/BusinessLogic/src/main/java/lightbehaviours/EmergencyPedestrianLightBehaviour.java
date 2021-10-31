package lightbehaviours;

import states.*;

/** SimplePedestrianLightBehaviour extension of SimpleLightBehaviour
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class EmergencyPedestrianLightBehaviour extends SimpleLightBehaviour {
    StateBase YELLOW_LIGHT_BLINKING = new YellowBlinkingLightState(this, "yellow blinking light", true, 1);

    public EmergencyPedestrianLightBehaviour(){
        YELLOW_LIGHT_BLINKING.setNextState(YELLOW_LIGHT_BLINKING);
        currentState = YELLOW_LIGHT_BLINKING;
    }
}
