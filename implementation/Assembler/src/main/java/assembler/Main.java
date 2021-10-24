package assembler;

import factories.SimplePedestrianFactory;
import factories.SimplePedestrianLightBehaviourFactory;
import factories.SimplePedestrianPlatformFactory;
import factories.SimplePedestrianTrafficLightFactory;
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
        PedestrianFactory pedFac = new SimplePedestrianFactory();
        PedestrianPlatformFactory platFac = new SimplePedestrianPlatformFactory();
        PedestrianTrafficLightFactory trafLightFac = new SimplePedestrianTrafficLightFactory();
        PedestrianLightBehaviourFactory lightBehFac = new SimplePedestrianLightBehaviourFactory();

        PairPlatform a = platFac.createPairPlatform("a", 0, 1);
        FourWayPlatform b = platFac.createFourWayPlatform("b", 1, 1);
        PairPlatform c = platFac.createPairPlatform("c", 2, 1);
        PairPlatform d = platFac.createPairPlatform("d", 1, 0);
        PairPlatform e = platFac.createPairPlatform("e", 1, 2);

        b.setWestPlatform(a);
        a.setPairPlatform(b);

        b.setEastPlatform(c);
        c.setPairPlatform(b);

        b.setNorthPlatform(d);
        d.setPairPlatform(b);

        b.setSouthPlatform(e);
        e.setPairPlatform(b);

        Pedestrian p1 = pedFac.createWalker("w1", c);
        Pedestrian p2 = pedFac.createSkateboarder("s1", d);
        Pedestrian p3 = pedFac.createJogger("j1", e);
        Pedestrian p4 = pedFac.createJogger("j2", a);

        a.addPedestrian(p1);
        a.addPedestrian(p2);
        a.addPedestrian(p3);
        c.addPedestrian(p4);

        PedestrianTrafficLight trafficLightUp = trafLightFac.createPedestrianTrafficLight();
        PedestrianTrafficLight trafficLightLeft = trafLightFac.createPedestrianTrafficLight();
        PedestrianTrafficLight trafficLightRight = trafLightFac.createPedestrianTrafficLight();
        PedestrianTrafficLight trafficLightDown = trafLightFac.createPedestrianTrafficLight();

        trafficLightLeft.addObserver(a);
        trafficLightLeft.addObserver(b);

        trafficLightRight.addObserver(b);
        trafficLightRight.addObserver(c);

        trafficLightUp.addObserver(b);
        trafficLightUp.addObserver(d);

        trafficLightDown.addObserver(b);
        trafficLightDown.addObserver(e);

        PedestrianLightBehaviour lightBehaviourLeft = lightBehFac.createSimplePedestrianLightBehaviour(trafficLightLeft);
        PedestrianLightBehaviour lightBehaviourRight = lightBehFac.createSimplePedestrianLightBehaviour(trafficLightRight);
        PedestrianLightBehaviour lightBehaviourUp = lightBehFac.createSimplePedestrianLightBehaviour(trafficLightUp);
        PedestrianLightBehaviour lightBehaviourDown = lightBehFac.createSimplePedestrianLightBehaviour(trafficLightDown);

        trafficLightLeft.setPedestrianLightBehaviour(lightBehaviourLeft);
        trafficLightRight.setPedestrianLightBehaviour(lightBehaviourRight);
        trafficLightUp.setPedestrianLightBehaviour(lightBehaviourUp);
        trafficLightDown.setPedestrianLightBehaviour(lightBehaviourDown);

        System.out.println();
        trafficLightLeft.pushButton();

        System.out.println();
        trafficLightLeft.pushButton();

        System.out.println();
        trafficLightUp.pushButton();

        System.out.println();
        trafficLightDown.pushButton();

        System.out.println();
        trafficLightRight.pushButton();

        System.out.println();
        trafficLightLeft.pushButton();
    }
    
}
