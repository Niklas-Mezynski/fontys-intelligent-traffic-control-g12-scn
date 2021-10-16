package assembler;

import interfaces.PedestrianLightBehaviour;
import trafficlights.SimplePedestrianTrafficLight;
import interfaces.PedestrianTrafficLight;
import lightbehaviours.ExtendedPedestrianLightBehaviour;
import lightbehaviours.SimplePedestrianLightBehaviour;

/**
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PedestrianTrafficLight trafficLight = new SimplePedestrianTrafficLight();
        PedestrianLightBehaviour lightbehaviour1 = new SimplePedestrianLightBehaviour(trafficLight);
        PedestrianLightBehaviour lightbehaviour2 = new ExtendedPedestrianLightBehaviour(trafficLight);
        trafficLight.setPedestrianLightBehaviour(lightbehaviour1);
        trafficLight.pushButton();
        System.out.println("\n change behaviour now \n");
        trafficLight.setPedestrianLightBehaviour(lightbehaviour2);
        trafficLight.pushButton();
    }
    
}
