package trafficLights;

import lightBehaviours.GermanyPedestrianLightBehaviour;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import shapes.SimpleShape;

import static org.assertj.core.api.Assertions.assertThat;

public class SimplePedestrianTrafficLightTest {

    SimplePedestrianTrafficLight trafficLight = new SimplePedestrianTrafficLight(GermanyPedestrianLightBehaviour.RED_LIGHT);

    @Test
    void changeState() {
        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(trafficLight.getCurrentState()).isEqualTo(GermanyPedestrianLightBehaviour.RED_LIGHT);
        trafficLight.changeState(GermanyPedestrianLightBehaviour.GREEN_LIGHT);
        softly.assertThat(trafficLight.getCurrentState()).isEqualTo(GermanyPedestrianLightBehaviour.GREEN_LIGHT);
    }

    @Test
    void stopTraffic() {
        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(trafficLight.getCurrentState()).isEqualTo(GermanyPedestrianLightBehaviour.RED_LIGHT);
        trafficLight.startTraffic();
        softly.assertThat(trafficLight.getCurrentState()).isEqualTo(GermanyPedestrianLightBehaviour.GREEN_LIGHT);
        trafficLight.stopTraffic();
        softly.assertThat(trafficLight.getCurrentState()).isEqualTo(GermanyPedestrianLightBehaviour.RED_LIGHT);
    }

    @Test
    void startTraffic() {
        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(trafficLight.getCurrentState()).isEqualTo(GermanyPedestrianLightBehaviour.RED_LIGHT);
        trafficLight.startTraffic();
        softly.assertThat(trafficLight.getCurrentState()).isEqualTo(GermanyPedestrianLightBehaviour.GREEN_LIGHT);
    }

    @Test
    void getCurrentState() {
        assertThat(trafficLight.getCurrentState()).isEqualTo(GermanyPedestrianLightBehaviour.RED_LIGHT);
    }

    @Test
    void testToString() {
        assertThat(trafficLight.toString()).isEqualTo("SimplePedestrianTrafficLight{ currentState = RED_LIGHT, shape = Dot Shape }");
    }

    @Test
    void getShape() {
        assertThat(trafficLight.getShape()).isEqualTo(new SimpleShape("Dot"));
    }

    @Test
    void setShape() {
        var shape = new SimpleShape("Man");
        trafficLight.setShape(shape);
        assertThat(trafficLight.getShape()).isEqualTo(shape);
    }
}