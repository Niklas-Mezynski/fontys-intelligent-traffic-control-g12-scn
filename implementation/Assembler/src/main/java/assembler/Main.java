package assembler;

import interfaces.PedestrianLightBehaviour;
import lightbehaviours.CustomPedestrianLightBehaviour;
import shapes.CustomShape;
import shapes.DonkeyShape;
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
        PedestrianLightBehaviour lightbehaviour3 = new CustomPedestrianLightBehaviour(trafficLight);
        trafficLight.setPedestrianLightBehaviour(lightbehaviour1);

        trafficLight.printCurrentLight();

        trafficLight.setShape(new CustomShape("Star Shape"));
        trafficLight.printCurrentLight();

        trafficLight.pushButton();

        System.out.println("\n change behaviour now \n");
        trafficLight.setPedestrianLightBehaviour(lightbehaviour2);
        trafficLight.pushButton();

        System.out.println("\n change behaviour now \n");
        trafficLight.setPedestrianLightBehaviour(lightbehaviour3);
        trafficLight.pushButton();

        System.out.println("\n change shape now \n");
        trafficLight.setShape(new DonkeyShape());
        trafficLight.pushButton();

        System.out.println("\n change shape now \n");
        trafficLight.setShape(new CustomShape("Square Shape"));
        trafficLight.pushButton();


    }
    
}
