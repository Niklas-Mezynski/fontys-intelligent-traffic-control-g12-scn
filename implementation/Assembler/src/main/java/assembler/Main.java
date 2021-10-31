package assembler;

import factories.SimplePedestrianFactory;
import factories.SimpleLightBehaviourFactory;
import factories.SimplePedestrianPlatformFactory;
import factories.SimpleTrafficLightFactory;
import interfaces.*;
import lightbehaviours.EmergencyPedestrianLightBehaviour;

/**
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class Main {

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
                PedestrianFactory pedFac = new SimplePedestrianFactory();
                PedestrianPlatformFactory platFac = new SimplePedestrianPlatformFactory();
                TrafficLightFactory trafLightFac = new SimpleTrafficLightFactory();
//              LightBehaviourFactory lightBehFac = new SimpleLightBehaviourFactory();

                TwoWayPedestrianPlatform p00 = platFac.createTwoWayPlatform("p00", 0, 0);
                TwoWayPedestrianPlatform p10 = platFac.createTwoWayPlatform("p10", 1, 0);
                TwoWayPedestrianPlatform p01 = platFac.createTwoWayPlatform("p01", 0, 1);
                TwoWayPedestrianPlatform p11 = platFac.createTwoWayPlatform("p11", 1, 1);

                p00.setHorizontalPlatform(p10);
                p10.setHorizontalPlatform(p00);

                p00.setVerticalPlatform(p01);
                p01.setVerticalPlatform(p00);

                p01.setHorizontalPlatform(p11);
                p11.setHorizontalPlatform(p01);

                p11.setVerticalPlatform(p10);
                p10.setVerticalPlatform(p11);

                Pedestrian p1 = pedFac.createWalker("w1", p01);
                Pedestrian p2 = pedFac.createWalker("w2", p10);
                Pedestrian p3 = pedFac.createWalker("w3", p11);
                Pedestrian p4 = pedFac.createWalker("w4", p00);

                p00.addPedestrian(p1);
                p00.addPedestrian(p2);
                p00.addPedestrian(p3);
                p11.addPedestrian(p4);

                TrafficLight trafficLightUp = trafLightFac.createSimplePedestrianTrafficLight();
                TrafficLight trafficLightLeft = trafLightFac.createSimplePedestrianTrafficLight();
                TrafficLight trafficLightRight = trafLightFac.createSimplePedestrianTrafficLight();
                TrafficLight trafficLightDown = trafLightFac.createSimplePedestrianTrafficLight();

                trafficLightLeft.addObserver(p00);
                trafficLightLeft.addObserver(p01);

                trafficLightRight.addObserver(p10);
                trafficLightRight.addObserver(p11);

                trafficLightUp.addObserver(p00);
                trafficLightUp.addObserver(p10);

                trafficLightDown.addObserver(p01);
                trafficLightDown.addObserver(p11);

                System.out.println();
                trafficLightLeft.activate();

                System.out.println();
                trafficLightUp.activate();

                System.out.println();
                trafficLightRight.activate();

                System.out.println();
                trafficLightDown.activate();

                System.out.println();
                trafficLightLeft.activate();
        }
}
