package pedestrianLightBehaviours;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AustralianPedestrianBehaviourTest {
    AustralianPedestrianLightBehaviour redLight = AustralianPedestrianLightBehaviour.RED_LIGHT;
    AustralianPedestrianLightBehaviour greenLight = AustralianPedestrianLightBehaviour.GREEN_LIGHT;
    AustralianPedestrianLightBehaviour redBlinkingLight = AustralianPedestrianLightBehaviour.RED_BLINKING_LIGHT;

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
        assertThat(greenLight.getNext()).isEqualTo(redBlinkingLight);
    }

    @Test
    void redBlinkingLightGetNextTest() {
        assertThat(redBlinkingLight.getNext()).isEqualTo(redLight);
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
    void redBlinkingLightCheckValues() {

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(redBlinkingLight.canPass()).isTrue();
            s.assertThat(redBlinkingLight.getName()).isEqualTo("Red Blinking Light");
            s.assertThat(redBlinkingLight.length()).isEqualTo(2);
            s.assertAll();
        });

    }
}
