package streetLightBehaviours;

import factories.SimpleTrafficLightFactory;
import interfaces.StreetTrafficLight;
import interfaces.TrafficLightFactory;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class EmergencyStreetLightBehaviourTest {
    EmergencyStreetLightBehaviour behaviour = EmergencyStreetLightBehaviour.YELLOW_BLINKING_LIGHT;
    TrafficLightFactory trafficLightFactory = new SimpleTrafficLightFactory();

    @Test
    public void t01(){
        StreetTrafficLight germanStreetTrafficLight = trafficLightFactory.createGermanStreetTrafficLight("German Light");
        germanStreetTrafficLight.changeState(behaviour);
        assertThat(germanStreetTrafficLight.getCurrentState()).isEqualTo(EmergencyStreetLightBehaviour.YELLOW_BLINKING_LIGHT);
        germanStreetTrafficLight.startTraffic();
        assertThat(germanStreetTrafficLight.getCurrentState()).isEqualTo(EmergencyStreetLightBehaviour.YELLOW_BLINKING_LIGHT);
        germanStreetTrafficLight.stopTraffic();
        assertThat(germanStreetTrafficLight.getCurrentState()).isEqualTo(EmergencyStreetLightBehaviour.YELLOW_BLINKING_LIGHT);






    }
}
