package trafficLights;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import shapes.DotShape;
import streetLightBehaviours.DutchTrafficLightBehaviour;
import streetLightBehaviours.SimpleStreetLightBehaviour;

import static org.assertj.core.api.Assertions.assertThat;

public class DutchTrafficLightTest {
    SimpleStreetTrafficLight trafficLight = new SimpleStreetTrafficLight(DutchTrafficLightBehaviour.RED_LIGHT);

    @Test
    void changeState() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(trafficLight.getCurrentState()).isEqualTo(DutchTrafficLightBehaviour.RED_LIGHT);
        trafficLight.changeState(DutchTrafficLightBehaviour.GREEN_LIGHT);
        softly.assertThat(trafficLight.getCurrentState()).isEqualTo(DutchTrafficLightBehaviour.GREEN_LIGHT);
        softly.assertAll();
    }

    @Test
    void startStopTraffic() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(trafficLight.getCurrentState()).isEqualTo(DutchTrafficLightBehaviour.RED_LIGHT);
        trafficLight.startTraffic();
        softly.assertThat(trafficLight.getCurrentState()).isEqualTo(DutchTrafficLightBehaviour.GREEN_LIGHT);
        trafficLight.stopTraffic();
        softly.assertThat(trafficLight.getCurrentState()).isEqualTo(DutchTrafficLightBehaviour.RED_LIGHT);
        softly.assertAll();
    }

    @Test
    void getCurrentState() {
        assertThat(trafficLight.getCurrentState()).isEqualTo(DutchTrafficLightBehaviour.RED_LIGHT);
    }

    @Test
    void testToString() {
        assertThat(trafficLight.toString()).isEqualTo("SimpleStreetTrafficLight{ currentState = RED_LIGHT, shape = Dot Shape }");
    }

    @Test
    void getShape() {
        assertThat(trafficLight.getShape()).isEqualTo(new DotShape());
    }

    @Test
    void setShape() {
        var shape = new DotShape();
        trafficLight.setShape(shape);
        assertThat(trafficLight.getShape()).isEqualTo(shape);
    }
}
