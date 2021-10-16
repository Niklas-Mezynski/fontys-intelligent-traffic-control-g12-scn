package lightbehaviours;

import org.junit.jupiter.api.Test;
import trafficlights.*;
import interfaces.*;

import static org.assertj.core.api.Assertions.assertThat;

class SimplePedestrianLightBehaviourTest {
    PedestrianTrafficLight light = new SimplePedestrianTrafficLight();
    PedestrianLightBehaviour behaviour = new SimplePedestrianLightBehaviour(light);

    @Test
    void getTrafficLight() {
        assertThat(behaviour.getTrafficLight()).isEqualTo(light);
    }

    @Test
    void getCurrentState() {
        assertThat(behaviour.getCurrentState().getName()).isEqualTo("red light");
    }

    @Test
    void buttonIsPushed() {
        assertThat(behaviour.buttonIsPushed()).isEqualTo(false);
    }

}