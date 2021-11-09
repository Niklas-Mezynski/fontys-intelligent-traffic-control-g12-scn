package streetLightBehaviours;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import streetLightBehaviours.SimpleStreetLightBehaviour;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SimpleStreetLightBehaviourTest {
    SimpleStreetLightBehaviour redLight = SimpleStreetLightBehaviour.RED_LIGHT;
    SimpleStreetLightBehaviour greenLight = SimpleStreetLightBehaviour.GREEN_LIGHT;
    SimpleStreetLightBehaviour yellowLight = SimpleStreetLightBehaviour.YELLOW_LIGHT;

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
        assertThat(greenLight.getNext()).isEqualTo(yellowLight);
    }

    @Test
    void yellowLightGetNextTest() {
        assertThat(yellowLight.getNext()).isEqualTo(redLight);
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
    void yellowLightCheckValues() {

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(yellowLight.canPass()).isTrue();
            s.assertThat(yellowLight.getName()).isEqualTo("Yellow Light");
            s.assertThat(yellowLight.length()).isEqualTo(0);
            s.assertAll();
        });

    }
}
