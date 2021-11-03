package lightBehaviour;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import trafficLights.SimplePedestrianTrafficLight;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class DutchSimplePedestrianTrafficLightTest {

    SimplePedestrianTrafficLight dutchLight = new SimplePedestrianTrafficLight(DutchPedestrianLightBehaviour.RED_LIGHT);


    @Test
    public void getCurrentStateShouldReturnCorrectStateTest(){
        assertThat(dutchLight.getCurrentState()).isEqualTo(DutchPedestrianLightBehaviour.RED_LIGHT);
        assertThat(dutchLight.getCurrentState().toString()).isEqualTo("RED_LIGHT");
    }

    @Test
    public void changeStateMethodTest(){
       dutchLight.changeState(DutchPedestrianLightBehaviour.GREEN_BLINKING_LIGHT);
       assertThat(dutchLight.getCurrentState()).isEqualTo(DutchPedestrianLightBehaviour.GREEN_BLINKING_LIGHT);
        assertThat(dutchLight.getCurrentState().toString()).isEqualTo("GREEN_BLINKING_LIGHT");

    }
    @Test
    public void startTrafficTest(){
        dutchLight.startTraffic();
        assertThat(dutchLight.getCurrentState()).isEqualTo(DutchPedestrianLightBehaviour.GREEN_LIGHT);

    }

    @Test
    public void stopTrafficTest(){
        dutchLight.stopTraffic();
        assertThat(dutchLight.getCurrentState()).isEqualTo(DutchPedestrianLightBehaviour.RED_LIGHT);

    }

    @Test
    public void testToString(){
        assertThat(dutchLight.toString()).isEqualTo("SimplePedestrianTrafficLight{ currentState = RED_LIGHT, shape = Dot Shape }");
    }

    @Test
    public void redLightCheckValues(){
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(dutchLight.getCurrentState().canPass()).isEqualTo(false);
            softAssertions.assertThat(dutchLight.getCurrentState().getName()).isEqualTo("Red Light");
            softAssertions.assertThat(dutchLight.getCurrentState().length()).isEqualTo(0);
        });
    }

    @Test
    public void greenLightCheckValues(){
        dutchLight.changeState(DutchPedestrianLightBehaviour.GREEN_LIGHT);
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(dutchLight.getCurrentState().canPass()).isEqualTo(true);
            softAssertions.assertThat(dutchLight.getCurrentState().getName()).isEqualTo("Green Light");
            softAssertions.assertThat(dutchLight.getCurrentState().length()).isEqualTo(2);
        });
    }

    @Test
    public void greenLightBlinkingCheckValues(){
        dutchLight.changeState(DutchPedestrianLightBehaviour.GREEN_BLINKING_LIGHT);
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(dutchLight.getCurrentState().canPass()).isEqualTo(true);
            softAssertions.assertThat(dutchLight.getCurrentState().getName()).isEqualTo("Green Blinking Light");
            softAssertions.assertThat(dutchLight.getCurrentState().length()).isEqualTo(2);
        });
    }
    
}
