package streetLightBehaviours;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import streetLightBehaviours.BulgarianStreetLightBehaviour;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class BulgarianStreetLightBehaviourTest {
    BulgarianStreetLightBehaviour redLight = BulgarianStreetLightBehaviour.RED_LIGHT;
    BulgarianStreetLightBehaviour greenLight = BulgarianStreetLightBehaviour.GREEN_LIGHT;
    BulgarianStreetLightBehaviour yellowLightBefore = BulgarianStreetLightBehaviour.YELLOW_LIGHT_BEFORE_GREEN;
    BulgarianStreetLightBehaviour yellowLightAfter = BulgarianStreetLightBehaviour.YELLOW_LIGHT_AFTER_GREEN;

    @Test
    public void redLightGetNextTest(){
        assertThat(redLight.getNext()).isEqualTo(yellowLightBefore);
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
    void yellowLightBeforeGetNextTest() {
        assertThat(yellowLightBefore.getNext()).isEqualTo(greenLight);
    }


    @Test
    void yellowLightBeforeCheckValues() {

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(yellowLightBefore.canPass()).isTrue();
            s.assertThat(yellowLightBefore.getName()).isEqualTo("Yellow Light");
            s.assertThat(yellowLightBefore.length()).isEqualTo(1);
            s.assertAll();
        });

    }

    @Test
    void greenLightGetNextTest() {
        assertThat(greenLight.getNext()).isEqualTo(yellowLightAfter);
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
    void yellowLightAfterGetNextTest() {
        assertThat(yellowLightAfter.getNext()).isEqualTo(redLight);
    }


    @Test
    void yellowLightAfterCheckValues() {

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(yellowLightAfter.canPass()).isTrue();
            s.assertThat(yellowLightAfter.getName()).isEqualTo("Yellow Light");
            s.assertThat(yellowLightAfter.length()).isEqualTo(1);
            s.assertAll();
        });

    }
}
