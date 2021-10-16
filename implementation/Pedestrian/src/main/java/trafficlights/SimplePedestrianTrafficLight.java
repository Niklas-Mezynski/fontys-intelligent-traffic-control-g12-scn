package trafficlights;

import interfaces.PedestrianLightBehaviour;
import interfaces.PedestrianTrafficLight;
import states.State;

/**
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class SimplePedestrianTrafficLight implements PedestrianTrafficLight{
    PedestrianLightBehaviour lightBehaviour;

    @Override
    public void setPedestrianLightBehaviour(PedestrianLightBehaviour light) {
        this.lightBehaviour = light;
    }

    @Override
    public PedestrianLightBehaviour getPedestrianLightBehaviour() {
        return this.lightBehaviour;
    }

    @Override
    public void pushButton() {
        if(this.lightBehaviour == null) {
            System.out.println("No light behaviour supplied yet!");
        }
        else {
            System.out.println("button pushed");
            this.lightBehaviour.activateChange();
        }
    }

    @Override
    public State getCurrentState() {
        return this.lightBehaviour.getCurrentState();
    }

}
