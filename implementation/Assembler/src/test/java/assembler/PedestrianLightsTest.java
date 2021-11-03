package assembler;

import interfaces.State;
import lightBehaviours.DutchPedestrianLightBehaviour;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trafficLights.SimplePedestrianTrafficLight;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

    @Test
    public void integrationTest(){
        SoftAssertions softly = new SoftAssertions();

        State state = DutchPedestrianLightBehaviour.RED_LIGHT;
        SimplePedestrianTrafficLight test = new SimplePedestrianTrafficLight(state);
        System.out.println(test);
        test.startTraffic();
        test.stopTraffic();
        System.out.println(test);

        softly.assertThat(outputStreamCaptor.toString()).contains("SimplePedestrianTrafficLight{ currentState = RED_LIGHT, shape = Dot Shape }");
        softly.assertThat(outputStreamCaptor.toString()).contains("Changing from RED_LIGHT -> GREEN_LIGHT");
        softly.assertThat(outputStreamCaptor.toString()).contains("Changing from GREEN_LIGHT -> GREEN_BLINKING_LIGHT");
        softly.assertThat(outputStreamCaptor.toString()).contains("Changing from GREEN_BLINKING_LIGHT -> RED_LIGHT");
        softly.assertThat(outputStreamCaptor.toString()).contains("SimplePedestrianTrafficLight{ currentState = RED_LIGHT, shape = Dot Shape }");
    }

}
