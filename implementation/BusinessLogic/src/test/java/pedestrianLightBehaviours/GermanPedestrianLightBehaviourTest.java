package pedestrianLightBehaviours;

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
            s.assertThat(redLight.canPass()).isFalse();
            s.assertThat(redLight.getName()).isEqualTo("Red Light");
            s.assertThat(redLight.length()).isEqualTo(0);
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
            s.assertThat(greenLight.canPass()).isTrue();
            s.assertThat(greenLight.getName()).isEqualTo("Green Light");
            s.assertThat(greenLight.length()).isEqualTo(2);
            s.assertAll();
        });

    }
}

