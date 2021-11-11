package streetLightBehaviours;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import streetLightBehaviours.GermanStreetLightBehaviour;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class GermanStreetLightBehaviourTest {

    GermanStreetLightBehaviour redLight = GermanStreetLightBehaviour.RED_LIGHT;
    GermanStreetLightBehaviour redYellow = GermanStreetLightBehaviour.RED_YELLOW;
    GermanStreetLightBehaviour greenLight = GermanStreetLightBehaviour.GREEN_LIGHT;
    GermanStreetLightBehaviour yellow = GermanStreetLightBehaviour.YELLOW;


    @Test
    public void changeStateTest() {
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(redLight.getNext()).isEqualTo(redYellow);
            softAssertions.assertThat(redYellow.getNext()).isEqualTo(greenLight);
            softAssertions.assertThat(greenLight.getNext()).isEqualTo(yellow);
            softAssertions.assertThat(yellow.getNext()).isEqualTo(redLight);
        });
    }

    @Test
    public void checkNameTest() {
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(redLight.getName()).isEqualTo("Red Light");
            softAssertions.assertThat(redYellow.getName()).isEqualTo("Red Yellow Light");
            softAssertions.assertThat(yellow.getName()).isEqualTo("Yellow Light");
            softAssertions.assertThat(greenLight.getName()).isEqualTo("Green Light");

        });
    }

    @Test
    public void checkPassTest() {
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(redLight.canPass()).isFalse();
            softAssertions.assertThat(redYellow.canPass()).isFalse();
            softAssertions.assertThat(yellow.canPass()).isTrue();
            softAssertions.assertThat(greenLight.canPass()).isTrue();
        });
    }

    @Test
    public void checkLengthTest(){
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(redLight.length()).isEqualTo(0);
            softAssertions.assertThat(redYellow.length()).isEqualTo(0);
            softAssertions.assertThat(yellow.length()).isEqualTo(2);
            softAssertions.assertThat(greenLight.length()).isEqualTo(2);
        });
    }

}
