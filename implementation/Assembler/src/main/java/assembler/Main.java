package assembler;

import crossings.SimpleCrossing;
import factories.SimpleTrafficLightFactory;
import interfaces.*;

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
                TrafficLightFactory trafficLightFactory = new SimpleTrafficLightFactory();

                PedestrianTrafficLight test = trafficLightFactory.createAustralianPedestrianTrafficLight();
                PedestrianTrafficLight test2 = trafficLightFactory.createGermanPedestrianTrafficLight();

                SimpleCrossing cros = new SimpleCrossing();
                cros.addPedestrianTrafficLightPair(test, test2);
                cros.activate(10000);
                //cros.deactivate();

//                /**
//                 * Dutch traffic light test
//                 */
//                DutchTrafficLightBehaviour dtlb = DutchTrafficLightBehaviour.RED_LIGHT;
//                SimpleStreetTrafficLight dutchTrafficLight = new SimpleStreetTrafficLight(dtlb);
//
//                dutchTrafficLight.changeState(DutchTrafficLightBehaviour.GREEN_LIGHT);
//
//
//                //System.out.println(test);
//                test2.startTraffic();
//
//                System.out.println("----");
//
//                test2.stopTraffic();
//
//                System.out.println("----");
//
//                System.out.println(test2);
//
//                System.out.println(test);


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
