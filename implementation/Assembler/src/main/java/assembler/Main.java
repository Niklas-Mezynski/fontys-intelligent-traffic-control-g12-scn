package assembler;

import lightBehaviours.GermanPedestrianLightBehaviour;
import trafficLights.SimplePedestrianTrafficLight;
import interfaces.State;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class Main {

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
                Timer timer = new Timer();
                State state = GermanPedestrianLightBehaviour.RED_LIGHT;
                SimplePedestrianTrafficLight test = new SimplePedestrianTrafficLight(state);

                //System.out.println(test);
                test.startTraffic();

                System.out.println("----");


                timer.schedule(new TimerTask() {

                        @Override
                        public void run() {
                                test.stopTraffic();
                                timer.cancel();
                        }
                }, 2 * 10000);



                //System.out.println(test);

        }
}
