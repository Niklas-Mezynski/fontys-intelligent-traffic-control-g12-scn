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

                PedestrianTrafficLight test = trafficLightFactory.createAustralianPedestrianTrafficLight("horizontal pedestrian");
                PedestrianTrafficLight test2 = trafficLightFactory.createGermanPedestrianTrafficLight("vertical pedestrian");

                StreetTrafficLight germanSt = trafficLightFactory.createGermanStreetTrafficLight("horizontal street");
                StreetTrafficLight germanSt2 = trafficLightFactory.createGermanStreetTrafficLight("vertical street");

                SimpleCrossing cros = new SimpleCrossing();
                cros.addPedestrianTrafficLightPair(test, test2);
                cros.addStreetTrafficLightPair(germanSt, germanSt2);
                cros.activate(10000);



        }
}
