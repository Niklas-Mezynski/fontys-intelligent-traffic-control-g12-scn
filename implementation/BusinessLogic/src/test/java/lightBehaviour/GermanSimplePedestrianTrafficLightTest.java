package lightBehaviour;

import lightBehaviour.GermanyPedestrianLightBehaviour;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import trafficLights.SimplePedestrianTrafficLight;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class GermanSimplePedestrianTrafficLightTest {

    // Init the LightBehaviour
    GermanyPedestrianLightBehaviour redLight = GermanyPedestrianLightBehaviour.RED_LIGHT;
    GermanyPedestrianLightBehaviour greenLight = GermanyPedestrianLightBehaviour.GREEN_LIGHT;

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
        });

    }
}

