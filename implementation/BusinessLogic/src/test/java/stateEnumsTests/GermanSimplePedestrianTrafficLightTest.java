package stateEnumsTests;

import lightBehaviour.GermanyPedestrianLightBehaviour;
import org.junit.jupiter.api.Test;
import trafficLights.SimplePedestrianTrafficLight;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class GermanSimplePedestrianTrafficLightTest {

    /**
     * Initialize the pedestrian lights.
     */
    SimplePedestrianTrafficLight germanLight = new SimplePedestrianTrafficLight(GermanyPedestrianLightBehaviour.RED_LIGHT);

    /**
     * Assert whether the getCurrentState() method returns the expected state.
     * In this case it should be GermanyPedestrianLightBehaviour.RED_LIGHT
     */
    @Test
    void getCurrentStateShouldReturnCorrectStateTest() {
        assertThat(germanLight.getCurrentState()).isEqualTo(GermanyPedestrianLightBehaviour.RED_LIGHT);
    }

    /**
     * Assert whether the changeState() method changes state correctly.
     */
    @Test
    void changeStateMethodTest() {
        
        //1: Change the state
        germanLight.changeState(GermanyPedestrianLightBehaviour.GREEN_LIGHT);
        //2: Assert
        assertThat(germanLight.getCurrentState()).isEqualTo(GermanyPedestrianLightBehaviour.GREEN_LIGHT);

    }
}
