package assembler;

import static org.assertj.core.api.Assertions.assertThat;

import factories.SimplePedestrianFactory;
import factories.SimpleLightBehaviourFactory;
import factories.SimplePedestrianPlatformFactory;
import factories.SimpleTrafficLightFactory;
import interfaces.*;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shapes.CustomShape;
import shapes.DonkeyShape;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

/**
 * Just an example test to show that transitions of states are working properly
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class PedestrianLightsTest {
    
    public PedestrianLightsTest() {
    }

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    PedestrianFactory pedFac = new SimplePedestrianFactory();
    PedestrianPlatformFactory platFac = new SimplePedestrianPlatformFactory();
    TrafficLightFactory trafLightFac = new SimpleTrafficLightFactory();
    LightBehaviourFactory lightBehFac = new SimpleLightBehaviourFactory();

    TrafficLight light = trafLightFac.createEmptyPedestrianTrafficLight();
    LightBehaviour simple = lightBehFac.createSimplePedestrianLightBehaviour();
    LightBehaviour extended = lightBehFac.createExtendedPedestrianLightBehaviour();
    LightBehaviour custom = lightBehFac.createCustomPedestrianLightBehaviour();
    LightBehaviour emergency = lightBehFac.createEmergencyPedestrianLightBehaviour();


    @Test
    public void testEmptyBehaviour() {
        light.activate();
        assertThat(outputStreamCaptor.toString()).contains("No light behaviour supplied yet!");
    }

    @Test
    public void testSimpleBehaviour() {
        SoftAssertions softly = new SoftAssertions();

        //supply behaviour
        light.setLightBehaviour(simple);
        var redState = light.getCurrentState();
        softly.assertThat(redState.getName()).isEqualTo("red light");

        //test behaviour
        light.activate();
        softly.assertThat(outputStreamCaptor.toString().contains("from red light to red light with button pushed")).isTrue();
        softly.assertThat(outputStreamCaptor.toString().contains("from red light with button pushed to green light")).isTrue();
        softly.assertThat(outputStreamCaptor.toString().contains("from green light to red light")).isTrue();
        softly.assertThat(light.getCurrentState()).isEqualTo(redState);
        softly.assertAll();
    }

    @Test
    public void testExtendedBehaviour() {
        SoftAssertions softly = new SoftAssertions();

        //supply behaviour
        light.setLightBehaviour(extended);
        var redState = light.getCurrentState();
        softly.assertThat(redState.getName()).isEqualTo("red light");

        //test behaviour
        light.activate();
        softly.assertThat(outputStreamCaptor.toString()).contains("from red light to red light with button pushed");
        softly.assertThat(outputStreamCaptor.toString()).contains("from red light with button pushed to green light");
        softly.assertThat(outputStreamCaptor.toString()).contains("from green light to green blinking light");
        softly.assertThat(outputStreamCaptor.toString()).contains("from green blinking light to red light");
        softly.assertThat(light.getCurrentState()).isEqualTo(redState);
        softly.assertAll();
    }

    @Test
    public void testCustomBehaviour() {
        SoftAssertions softly = new SoftAssertions();

        //supply behaviour
        light.setLightBehaviour(custom);
        var redState = light.getCurrentState();
        softly.assertThat(redState.getName()).isEqualTo("red light");

        //test behaviour
        light.activate();
        softly.assertThat(outputStreamCaptor.toString()).contains("from red light to red light with button pushed");
        softly.assertThat(outputStreamCaptor.toString()).contains("from red light with button pushed to green light");
        softly.assertThat(outputStreamCaptor.toString()).contains("from green light to green blinking light");
        softly.assertThat(outputStreamCaptor.toString()).contains("from green blinking light to yellow light");
        softly.assertThat(outputStreamCaptor.toString()).contains("from yellow light to red light");
        softly.assertThat(light.getCurrentState()).isEqualTo(redState);
        softly.assertAll();
    }

    @Test
    public void testEmergencyBehaviour() {
        SoftAssertions softly = new SoftAssertions();

        //supply behaviour
        light.setLightBehaviour(emergency);
        var initState = light.getCurrentState();
        softly.assertThat(initState.getName()).isEqualTo("yellow blinking light");

        //test behaviour
        light.activate();
        softly.assertThat(outputStreamCaptor.toString()).contains("from yellow blinking light to yellow blinking light");
        softly.assertThat(light.getCurrentState()).isEqualTo(initState);
        softly.assertAll();
    }

    @Test
    public void testBehaviourChange() {
        SoftAssertions softly = new SoftAssertions();

        //supply first behaviour
        light.setLightBehaviour(simple);
        var redState = light.getCurrentState();
        softly.assertThat(redState.getName()).isEqualTo("red light");

        //test first behaviour
        light.activate();
        softly.assertThat(outputStreamCaptor.toString().contains("from red light to red light with button pushed")).isTrue();
        softly.assertThat(outputStreamCaptor.toString().contains("from red light with button pushed to green light")).isTrue();
        softly.assertThat(outputStreamCaptor.toString().contains("from green light to red light")).isTrue();
        softly.assertThat(light.getCurrentState()).isEqualTo(redState);

        //change behaviour
        light.setLightBehaviour(extended);
        redState = light.getCurrentState();
        softly.assertThat(redState.getName()).isEqualTo("red light");
        outputStreamCaptor.reset();

        //test second behaviour
        light.activate();
        softly.assertThat(outputStreamCaptor.toString()).contains("from red light to red light with button pushed");
        softly.assertThat(outputStreamCaptor.toString()).contains("from red light with button pushed to green light");
        softly.assertThat(outputStreamCaptor.toString()).contains("from green light to green blinking light");
        softly.assertThat(outputStreamCaptor.toString()).contains("from green blinking light to red light");
        softly.assertThat(light.getCurrentState()).isEqualTo(redState);
        softly.assertAll();
    }

    @Test
    public void testDefaultShape() {
        light.setLightBehaviour(simple);
        assertThat(light.getShape().toString()).isEqualTo("Dot Shape");
    }

    @Test
    public void testCustomShape() {
        light.setLightBehaviour(simple);
        light.setShape(new CustomShape("Star Shape"));
        assertThat(light.getShape().toString()).isEqualTo("Star Shape");
    }

    @Test
    public void testShapeChange() {
        SoftAssertions softly = new SoftAssertions();

        light.setLightBehaviour(simple);

        //test default shape
        light.printCurrentLight();
        softly.assertThat(outputStreamCaptor.toString()).contains("red light in Dot Shape");
        outputStreamCaptor.reset();

        //test change shape
        light.setShape(new DonkeyShape());
        light.printCurrentLight();
        softly.assertThat(outputStreamCaptor.toString()).contains("red light in Donkey Shape");

        //test change shape
        light.setShape(new CustomShape("Star Shape"));
        light.printCurrentLight();
        softly.assertThat(outputStreamCaptor.toString()).contains("red light in Star Shape");

        softly.assertAll();
    }

    @Test
    public void testPairPlatforms() {
        SoftAssertions softly = new SoftAssertions();

        PairPedestrianPlatform a = platFac.createPairPlatform("a", 0, 0);
        PairPedestrianPlatform b = platFac.createPairPlatform("b", 1 , 0);
        a.setPairPlatform(b);
        b.setPairPlatform(a);

        Pedestrian p1 = pedFac.createWalker("p1", a);
        Pedestrian p2 = pedFac.createWalker("p2", a);
        Pedestrian p3 = pedFac.createWalker("p3", b);
        Pedestrian p4 = pedFac.createWalker("p4", b);
        Pedestrian p5 = pedFac.createWalker("p5", b);

        b.addPedestrians(List.of(p1, p2));
        a.addPedestrians(List.of(p3, p4, p5));

        TrafficLight trafficLight = trafLightFac.createSimplePedestrianTrafficLight();

        trafficLight.addObserver(a);
        trafficLight.addObserver(b);

        System.out.println();
        trafficLight.activate();
        
        softly.assertThat(outputStreamCaptor.toString()).contains("walker p1 is walking from b to a");
        softly.assertThat(outputStreamCaptor.toString()).contains("walker p1 has arrived at final destination a");
        softly.assertThat(outputStreamCaptor.toString()).contains("walker p2 is walking from b to a");
        softly.assertThat(outputStreamCaptor.toString()).contains("walker p2 has arrived at final destination a");

        softly.assertThat(outputStreamCaptor.toString()).contains("walker p3 is walking from a to b");
        softly.assertThat(outputStreamCaptor.toString()).contains("walker p3 has arrived at final destination b");
        softly.assertThat(outputStreamCaptor.toString()).contains("walker p4 is walking from a to b");
        softly.assertThat(outputStreamCaptor.toString()).contains("walker p4 has arrived at final destination b");

        outputStreamCaptor.reset();

        System.out.println();
        trafficLight.activate();

        softly.assertThat(outputStreamCaptor.toString()).contains("No pedestrians waiting at platform b");
        softly.assertThat(outputStreamCaptor.toString()).contains("walker p5 is walking from a to b");
        softly.assertThat(outputStreamCaptor.toString()).contains("walker p5 has arrived at final destination b");

        softly.assertAll();
    }

    @Test
    public void testTwoWayPlatforms() {
        SoftAssertions softly = new SoftAssertions();

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

        softly.assertThat(outputStreamCaptor.toString()).contains("walker w1 is walking from p00 to p01");
        softly.assertThat(outputStreamCaptor.toString()).contains("walker w1 has arrived at final destination p01");
        softly.assertThat(outputStreamCaptor.toString()).contains("No pedestrians waiting at platform p01 to go to platform p00");

        outputStreamCaptor.reset();

        System.out.println();
        trafficLightUp.activate();

        softly.assertThat(outputStreamCaptor.toString()).contains("walker w2 is walking from p00 to p10");
        softly.assertThat(outputStreamCaptor.toString()).contains("walker w2 has arrived at final destination p10");
        softly.assertThat(outputStreamCaptor.toString()).contains("walker w3 is walking from p00 to p10");
        softly.assertThat(outputStreamCaptor.toString()).contains("No pedestrians waiting at platform p10 to go to platform p00");

        outputStreamCaptor.reset();

        System.out.println();
        trafficLightRight.activate();

        softly.assertThat(outputStreamCaptor.toString()).contains("walker w3 is walking from p10 to p11");
        softly.assertThat(outputStreamCaptor.toString()).contains("walker w3 has arrived at final destination p11");
        softly.assertThat(outputStreamCaptor.toString()).contains("No pedestrians waiting at platform p11 to go to platform p10");

        outputStreamCaptor.reset();

        System.out.println();
        trafficLightDown.activate();

        softly.assertThat(outputStreamCaptor.toString()).contains("walker w4 is walking from p11 to p01");
        softly.assertThat(outputStreamCaptor.toString()).contains("No pedestrians waiting at platform p01 to go to platform p11");

        outputStreamCaptor.reset();

        System.out.println();
        trafficLightLeft.activate();

        softly.assertThat(outputStreamCaptor.toString()).contains("No pedestrians waiting at platform p00 to go to platform p01");
        softly.assertThat(outputStreamCaptor.toString()).contains("walker w4 is walking from p01 to p00");
        softly.assertThat(outputStreamCaptor.toString()).contains("walker w4 has arrived at final destination p00");

        outputStreamCaptor.reset();

        softly.assertAll();
    }

    @Test
    public void testFourWayPlatforms() {
        SoftAssertions softly = new SoftAssertions();

        PairPedestrianPlatform a = platFac.createPairPlatform("a", 0, 1);
        FourWayPedestrianPlatform b = platFac.createFourWayPlatform("b", 1, 1);
        PairPedestrianPlatform c = platFac.createPairPlatform("c", 2, 1);
        PairPedestrianPlatform d = platFac.createPairPlatform("d", 1, 0);
        PairPedestrianPlatform e = platFac.createPairPlatform("e", 1, 2);

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

        TrafficLight trafficLightUp = trafLightFac.createSimplePedestrianTrafficLight();
        TrafficLight trafficLightLeft = trafLightFac.createSimplePedestrianTrafficLight();
        TrafficLight trafficLightRight = trafLightFac.createSimplePedestrianTrafficLight();
        TrafficLight trafficLightDown = trafLightFac.createSimplePedestrianTrafficLight();

        trafficLightLeft.addObserver(a);
        trafficLightLeft.addObserver(b);

        trafficLightRight.addObserver(b);
        trafficLightRight.addObserver(c);

        trafficLightUp.addObserver(b);
        trafficLightUp.addObserver(d);

        trafficLightDown.addObserver(b);
        trafficLightDown.addObserver(e);

        System.out.println();
        trafficLightLeft.activate();

        softly.assertThat(outputStreamCaptor.toString()).contains("walker w1 is walking from a to b");
        softly.assertThat(outputStreamCaptor.toString()).contains("skateboarder s1 is skateboarding from a to b");
        softly.assertThat(outputStreamCaptor.toString()).contains("No pedestrians waiting at platform b to go to platform a");

        outputStreamCaptor.reset();

        System.out.println();
        trafficLightLeft.activate();

        softly.assertThat(outputStreamCaptor.toString()).contains("jogger j1 is jogging from a to b");
        softly.assertThat(outputStreamCaptor.toString()).contains("No pedestrians waiting at platform b to go to platform a");

        outputStreamCaptor.reset();

        System.out.println();
        trafficLightUp.activate();

        softly.assertThat(outputStreamCaptor.toString()).contains("skateboarder s1 is skateboarding from b to d");
        softly.assertThat(outputStreamCaptor.toString()).contains("skateboarder s1 has arrived at final destination d");
        softly.assertThat(outputStreamCaptor.toString()).contains("No pedestrians waiting at platform d to go to platform b");

        outputStreamCaptor.reset();

        System.out.println();
        trafficLightDown.activate();

        softly.assertThat(outputStreamCaptor.toString()).contains("jogger j1 is jogging from b to e");
        softly.assertThat(outputStreamCaptor.toString()).contains("jogger j1 has arrived at final destination e");
        softly.assertThat(outputStreamCaptor.toString()).contains("No pedestrians waiting at platform e to go to platform b");

        outputStreamCaptor.reset();

        System.out.println();
        trafficLightRight.activate();

        softly.assertThat(outputStreamCaptor.toString()).contains("walker w1 is walking from b to c");
        softly.assertThat(outputStreamCaptor.toString()).contains("walker w1 has arrived at final destination c");
        softly.assertThat(outputStreamCaptor.toString()).contains("jogger j2 is jogging from c to b");

        outputStreamCaptor.reset();

        System.out.println();
        trafficLightLeft.activate();

        softly.assertThat(outputStreamCaptor.toString()).contains("No pedestrians waiting at platform a to go to platform b");
        softly.assertThat(outputStreamCaptor.toString()).contains("jogger j2 is jogging from b to a");
        softly.assertThat(outputStreamCaptor.toString()).contains("jogger j2 has arrived at final destination a");

        outputStreamCaptor.reset();

        softly.assertAll();
    }
}
