package lightBehaviours;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class DutchPedestrianLightBehaviourTest {
    DutchPedestrianLightBehaviour redLight = DutchPedestrianLightBehaviour.RED_LIGHT;
    DutchPedestrianLightBehaviour greenLight = DutchPedestrianLightBehaviour.GREEN_LIGHT;
    DutchPedestrianLightBehaviour greenBlinkingLight = DutchPedestrianLightBehaviour.GREEN_BLINKING_LIGHT;

    @Test
    public void redLightGetNextTest(){
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
        assertThat(greenLight.getNext()).isEqualTo(greenBlinkingLight);
    }

    @Test
    void greenBlinkingLightGetNextTest() {
        assertThat(greenBlinkingLight.getNext()).isEqualTo(redLight);
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

    @Test
    void greenBlinkingLightCheckValues() {

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(greenBlinkingLight.canPass()).isTrue();
            s.assertThat(greenBlinkingLight.getName()).isEqualTo("Green Blinking Light");
            s.assertThat(greenBlinkingLight.length()).isEqualTo(2);
            s.assertAll();
        });

    }
}
