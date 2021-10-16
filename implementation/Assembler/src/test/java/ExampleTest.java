import static org.assertj.core.api.Assertions.assertThat;

import interfaces.PedestrianLightBehaviour;
import interfaces.PedestrianTrafficLight;
import lightbehaviours.ExtendedPedestrianLightBehaviour;
import lightbehaviours.SimplePedestrianLightBehaviour;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trafficlights.SimplePedestrianTrafficLight;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Just an example test to show that transitions of states are working properly
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public class ExampleTest {
    
    public ExampleTest() {
    }

     @Test
     public void testTrue() {
     assertThat(1).isEqualTo(1);
     }

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    PedestrianTrafficLight light = new SimplePedestrianTrafficLight();
    PedestrianLightBehaviour simple = new SimplePedestrianLightBehaviour(light);
    PedestrianLightBehaviour extended = new ExtendedPedestrianLightBehaviour(light);

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

        //test second behaviour
        light.pushButton();
        softly.assertThat(outputStreamCaptor.toString()).contains("from red light to red light with button pushed");
        softly.assertThat(outputStreamCaptor.toString()).contains("from red light with button pushed to green light");
        softly.assertThat(outputStreamCaptor.toString()).contains("from green light to green blinking light");
        softly.assertThat(outputStreamCaptor.toString()).contains("from green blinking light to red light");
        softly.assertThat(light.getCurrentState()).isEqualTo(redState);
        softly.assertAll();
    }
}
