package assembler;

import static org.assertj.core.api.Assertions.assertThat;

import factories.SimplePedestrianFactory;
import factories.SimplePedestrianLightBehaviourFactory;
import factories.SimplePedestrianPlatformFactory;
import factories.SimplePedestrianTrafficLightFactory;
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
    PedestrianTrafficLightFactory trafLightFac = new SimplePedestrianTrafficLightFactory();
    PedestrianLightBehaviourFactory lightBehFac = new SimplePedestrianLightBehaviourFactory();

    PedestrianTrafficLight light = trafLightFac.createPedestrianTrafficLight();
    PedestrianLightBehaviour simple = lightBehFac.createSimplePedestrianLightBehaviour(light);
    PedestrianLightBehaviour extended = lightBehFac.createExtendedPedestrianLightBehaviour(light);
    PedestrianLightBehaviour custom = lightBehFac.createCustomPedestrianLightBehaviour(light);


    @Test
    public void testEmptyBehaviour() {
        light.pushButton();
        assertThat(outputStreamCaptor.toString()).contains("No light behaviour supplied yet!");
    }

    @Test
    public void testSimpleBehaviour() {
        SoftAssertions softly = new SoftAssertions();

        //supply behaviour
        light.setPedestrianLightBehaviour(simple);
        var redState = light.getCurrentState();
        softly.assertThat(redState.getName()).isEqualTo("red light");

        //test behaviour
        light.pushButton();
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
        light.setPedestrianLightBehaviour(extended);
        var redState = light.getCurrentState();
        softly.assertThat(redState.getName()).isEqualTo("red light");

        //test behaviour
        light.pushButton();
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
        light.setPedestrianLightBehaviour(custom);
        var redState = light.getCurrentState();
        softly.assertThat(redState.getName()).isEqualTo("red light");

        //test behaviour
        light.pushButton();
        softly.assertThat(outputStreamCaptor.toString()).contains("from red light to red light with button pushed");
        softly.assertThat(outputStreamCaptor.toString()).contains("from red light with button pushed to green light");
        softly.assertThat(outputStreamCaptor.toString()).contains("from green light to green blinking light");
        softly.assertThat(outputStreamCaptor.toString()).contains("from green blinking light to yellow light");
        softly.assertThat(outputStreamCaptor.toString()).contains("from yellow light to red light");
        softly.assertThat(light.getCurrentState()).isEqualTo(redState);
        softly.assertAll();
    }

    @Test
    public void testBehaviourChange() {
        SoftAssertions softly = new SoftAssertions();

        //supply first behaviour
        light.setPedestrianLightBehaviour(simple);
        var redState = light.getCurrentState();
        softly.assertThat(redState.getName()).isEqualTo("red light");

        //test first behaviour
        light.pushButton();
        softly.assertThat(outputStreamCaptor.toString().contains("from red light to red light with button pushed")).isTrue();
        softly.assertThat(outputStreamCaptor.toString().contains("from red light with button pushed to green light")).isTrue();
        softly.assertThat(outputStreamCaptor.toString().contains("from green light to red light")).isTrue();
        softly.assertThat(light.getCurrentState()).isEqualTo(redState);

        //change behaviour
        light.setPedestrianLightBehaviour(extended);
        redState = light.getCurrentState();
        softly.assertThat(redState.getName()).isEqualTo("red light");
        outputStreamCaptor.reset();

        //test second behaviour
        light.pushButton();
        softly.assertThat(outputStreamCaptor.toString()).contains("from red light to red light with button pushed");
        softly.assertThat(outputStreamCaptor.toString()).contains("from red light with button pushed to green light");
        softly.assertThat(outputStreamCaptor.toString()).contains("from green light to green blinking light");
        softly.assertThat(outputStreamCaptor.toString()).contains("from green blinking light to red light");
        softly.assertThat(light.getCurrentState()).isEqualTo(redState);
        softly.assertAll();
    }

    @Test
    public void testDefaultShape() {
        assertThat(light.getShape().toString()).isEqualTo("Dot Shape");
    }

    @Test
    public void testCustomShape() {
        light.setShape(new CustomShape("Star Shape"));
        assertThat(light.getShape().toString()).isEqualTo("Star Shape");
    }

    @Test
    public void testShapeChange() {
        SoftAssertions softly = new SoftAssertions();

        light.setPedestrianLightBehaviour(simple);

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

        PairPlatform a = platFac.createPairPlatform("a", 0, 0);
        PairPlatform b = platFac.createPairPlatform("b", 1 , 0);
        a.setPairPlatform(b);
        b.setPairPlatform(a);

        Pedestrian p1 = pedFac.createWalker("p1", a);
        Pedestrian p2 = pedFac.createWalker("p2", a);
        Pedestrian p3 = pedFac.createWalker("p3", b);
        Pedestrian p4 = pedFac.createWalker("p4", b);
        Pedestrian p5 = pedFac.createWalker("p5", b);

        b.addPedestrians(List.of(p1, p2));
        a.addPedestrians(List.of(p3, p4, p5));

        PedestrianTrafficLight trafficLight = trafLightFac.createPedestrianTrafficLight();

        trafficLight.addObserver(a);
        trafficLight.addObserver(b);

        PedestrianLightBehaviour lightBehaviour1 = lightBehFac.createSimplePedestrianLightBehaviour(trafficLight);

        trafficLight.setPedestrianLightBehaviour(lightBehaviour1);

        System.out.println();
        trafficLight.pushButton();
        
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
        trafficLight.pushButton();

        softly.assertThat(outputStreamCaptor.toString()).contains("No pedestrians waiting at platform b");
        softly.assertThat(outputStreamCaptor.toString()).contains("walker p5 is walking from a to b");
        softly.assertThat(outputStreamCaptor.toString()).contains("walker p5 has arrived at final destination b");

        softly.assertAll();
    }

    @Test
    public void testFourWayPlatforms() {
        SoftAssertions softly = new SoftAssertions();

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

        softly.assertThat(outputStreamCaptor.toString()).contains("walker w1 is walking from a to b");
        softly.assertThat(outputStreamCaptor.toString()).contains("skateboarder s1 is skateboarding from a to b");
        softly.assertThat(outputStreamCaptor.toString()).contains("No pedestrians waiting at platform b to go to platform a");

        outputStreamCaptor.reset();

        System.out.println();
        trafficLightLeft.pushButton();

        softly.assertThat(outputStreamCaptor.toString()).contains("jogger j1 is jogging from a to b");
        softly.assertThat(outputStreamCaptor.toString()).contains("No pedestrians waiting at platform b to go to platform a");

        outputStreamCaptor.reset();

        System.out.println();
        trafficLightUp.pushButton();

        softly.assertThat(outputStreamCaptor.toString()).contains("skateboarder s1 is skateboarding from b to d");
        softly.assertThat(outputStreamCaptor.toString()).contains("skateboarder s1 has arrived at final destination d");
        softly.assertThat(outputStreamCaptor.toString()).contains("No pedestrians waiting at platform d to go to platform b");

        outputStreamCaptor.reset();

        System.out.println();
        trafficLightDown.pushButton();

        softly.assertThat(outputStreamCaptor.toString()).contains("jogger j1 is jogging from b to e");
        softly.assertThat(outputStreamCaptor.toString()).contains("jogger j1 has arrived at final destination e");
        softly.assertThat(outputStreamCaptor.toString()).contains("No pedestrians waiting at platform e to go to platform b");

        outputStreamCaptor.reset();

        System.out.println();
        trafficLightRight.pushButton();

        softly.assertThat(outputStreamCaptor.toString()).contains("walker w1 is walking from b to c");
        softly.assertThat(outputStreamCaptor.toString()).contains("walker w1 has arrived at final destination c");
        softly.assertThat(outputStreamCaptor.toString()).contains("jogger j2 is jogging from c to b");

        outputStreamCaptor.reset();

        System.out.println();
        trafficLightLeft.pushButton();

        softly.assertThat(outputStreamCaptor.toString()).contains("No pedestrians waiting at platform a to go to platform b");
        softly.assertThat(outputStreamCaptor.toString()).contains("jogger j2 is jogging from b to a");
        softly.assertThat(outputStreamCaptor.toString()).contains("jogger j2 has arrived at final destination a");

        outputStreamCaptor.reset();

        softly.assertAll();
    }
}
