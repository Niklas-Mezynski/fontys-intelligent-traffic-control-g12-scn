package assembler;

import trafficLights.SimplePedestrianTrafficLight;
import lightBehaviour.GermanyLightBehaviour;
import interfaces.State;

/**
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class Main {

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {

                State state = GermanyLightBehaviour.RED_LIGHT;
                SimplePedestrianTrafficLight test = new SimplePedestrianTrafficLight(state);
                System.out.println(test);

                test.startTraffic();

                System.out.println("----");

                test.stopTraffic();

                System.out.println(test);

        }
}
