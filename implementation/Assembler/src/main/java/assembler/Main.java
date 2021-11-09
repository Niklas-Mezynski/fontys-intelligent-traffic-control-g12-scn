package assembler;

import interfaces.PedestrianLightState;
import interfaces.StreetLightState;
import pedestrianLightBehaviours.GermanPedestrianLightBehaviour;
import streetLightBehaviours.SimpleStreetLightBehaviour;
import trafficLights.SimplePedestrianTrafficLight;
import trafficLights.SimpleStreetTrafficLight;

/**
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class Main {

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
                //Timer timer = new Timer();
                PedestrianLightState state = GermanPedestrianLightBehaviour.RED_LIGHT;
                StreetLightState state2 = SimpleStreetLightBehaviour.RED_LIGHT;
                SimplePedestrianTrafficLight test = new SimplePedestrianTrafficLight(state);
                SimpleStreetTrafficLight test2 = new SimpleStreetTrafficLight(state2);



                //System.out.println(test);
                test2.startTraffic();

                System.out.println("----");

                test2.stopTraffic();

                System.out.println("----");

                System.out.println(test2);

                System.out.println(test);


//                timer.schedule(new TimerTask() {
//
//                        @Override
//                        public void run() {
//                                test.stopTraffic();
//                                timer.cancel();
//                        }
//                }, 2 * 10000);



                //System.out.println(test);

        }
}
