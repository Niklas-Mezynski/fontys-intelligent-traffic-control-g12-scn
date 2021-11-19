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

                StreetTrafficLight germanSt = trafficLightFactory.createGermanStreetTrafficLight();
                StreetTrafficLight germanSt2 = trafficLightFactory.createGermanStreetTrafficLight();

                SimpleCrossing cros = new SimpleCrossing();
                cros.addPedestrianTrafficLightPair(test, test2);
                cros.addStreetTrafficLightPair(germanSt, germanSt2);
                cros.activate(10000);



        }
}
