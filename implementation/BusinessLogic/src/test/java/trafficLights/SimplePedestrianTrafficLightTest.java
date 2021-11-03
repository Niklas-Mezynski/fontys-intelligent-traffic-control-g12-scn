package trafficLights;

import lightBehaviour.GermanyPedestrianLightBehaviour;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import shapes.SimpleShape;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
        assertThat(trafficLight.toString()).isEqualTo("SimplePedestrianTrafficLight{ currentState=RED_LIGHT, currentShape=Dot Shape }");
    }

    @Test
    void getCurrentShape() {
        assertThat(trafficLight.getCurrentShape()).isEqualTo(new SimpleShape("Dot Shape"));
    }

    @Test
    void setCurrentShape() {
        var shape = new SimpleShape("Man Shape");
        trafficLight.setCurrentShape(shape);
        assertThat(trafficLight.getCurrentShape()).isEqualTo(shape);
    }
}