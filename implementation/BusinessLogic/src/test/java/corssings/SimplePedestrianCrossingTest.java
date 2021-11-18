package corssings;

import crossings.SimpleCrossing;
import factories.SimpleTrafficLightFactory;
import interfaces.PedestrianTrafficLight;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;
import trafficLights.SimplePedestrianTrafficLight;

import static org.assertj.core.api.Assertions.*;

public class SimplePedestrianCrossingTest {

    @Test
    void t01() throws InterruptedException {
        SimplePedestrianTrafficLight horizontal = Mockito.mock(SimplePedestrianTrafficLight.class);
        SimplePedestrianTrafficLight vertical = Mockito.mock(SimplePedestrianTrafficLight.class);
        SimpleCrossing simpleCrossing = new SimpleCrossing();
        simpleCrossing.addPedestrianTrafficLightPair(horizontal, vertical);

        simpleCrossing.activate(1);
        Mockito.verify(vertical, Mockito.times(1)).stopTraffic();
        Mockito.verify(horizontal, Mockito.times(1)).startTraffic();
        Thread.sleep(10);
        simpleCrossing.deactivate();
        Mockito.verify(horizontal, Mockito.times(1)).stopTraffic();
        Mockito.verify(vertical, Mockito.times(1)).startTraffic();
    }

}
