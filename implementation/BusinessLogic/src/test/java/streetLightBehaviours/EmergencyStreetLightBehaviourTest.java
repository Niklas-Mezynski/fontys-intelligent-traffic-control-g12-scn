package streetLightBehaviours;

import factories.SimpleTrafficLightFactory;
import interfaces.StreetTrafficLight;
import interfaces.TrafficLightFactory;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class EmergencyStreetLightBehaviourTest {
    EmergencyStreetLightBehaviour behaviour = EmergencyStreetLightBehaviour.YELLOW_BLINKING_LIGHT;
    TrafficLightFactory trafficLightFactory = new SimpleTrafficLightFactory();

    @Test
    public void testingBehaviour(){
        StreetTrafficLight germanStreetTrafficLight = trafficLightFactory.createGermanStreetTrafficLight("German Light");
        germanStreetTrafficLight.changeState(behaviour);
        SoftAssertions.assertSoftly(softAssertions ->{
            softAssertions.assertThat(germanStreetTrafficLight.getCurrentState()).isEqualTo(EmergencyStreetLightBehaviour.YELLOW_BLINKING_LIGHT);
            germanStreetTrafficLight.startTraffic();
            softAssertions.assertThat(germanStreetTrafficLight.getCurrentState()).isEqualTo(EmergencyStreetLightBehaviour.YELLOW_BLINKING_LIGHT);
            germanStreetTrafficLight.stopTraffic();
            softAssertions.assertThat(germanStreetTrafficLight.getCurrentState()).isEqualTo(EmergencyStreetLightBehaviour.NO_LIGHT);
        } );







    }
}
