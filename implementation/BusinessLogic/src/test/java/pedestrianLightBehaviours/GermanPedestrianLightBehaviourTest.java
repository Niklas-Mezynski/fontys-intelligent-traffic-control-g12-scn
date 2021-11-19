package pedestrianLightBehaviours;

import interfaces.LightState;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import pedestrianLightBehaviours.GermanPedestrianLightBehaviour;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class GermanPedestrianLightBehaviourTest {

    // Init the LightBehaviour
    GermanPedestrianLightBehaviour redLight = GermanPedestrianLightBehaviour.RED_LIGHT;
    GermanPedestrianLightBehaviour greenLight = GermanPedestrianLightBehaviour.GREEN_LIGHT;

    @Test
    void redLightGetNextTest() {
        assertThat(redLight.getNext()).isEqualTo(greenLight);
    }

    @Test
    void redLightCheckValues() {

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(redLight.stateMeaning()).isEqualTo(LightState.LightStateMeaning.STOP);
            s.assertThat(redLight.getName()).isEqualTo("Red Light");
            s.assertAll();
        });

    }

    @Test
    void greenLightGetNextTest() {
        assertThat(greenLight.getNext()).isEqualTo(redLight);
    }

    @Test
    void greenLightCheckValues() {

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(greenLight.stateMeaning()).isEqualTo(LightState.LightStateMeaning.PASS);
            s.assertThat(greenLight.getName()).isEqualTo("Green Light");
            s.assertAll();
        });

    }
}

