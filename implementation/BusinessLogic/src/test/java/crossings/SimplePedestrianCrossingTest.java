package crossings;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import trafficLights.SimplePedestrianTrafficLight;

public class SimplePedestrianCrossingTest {

    @Test
    void t01() throws InterruptedException {
        SimplePedestrianTrafficLight horizontal = Mockito.mock(SimplePedestrianTrafficLight.class);
        SimplePedestrianTrafficLight vertical = Mockito.mock(SimplePedestrianTrafficLight.class);
        SimpleCrossing simpleCrossing = new SimpleCrossing();
        simpleCrossing.addPedestrianTrafficLightPair(horizontal, vertical);

        simpleCrossing.activate();
        Mockito.verify(vertical, Mockito.times(1)).stopTraffic();
        Mockito.verify(horizontal, Mockito.times(1)).startTraffic();
        Thread.sleep(5005);
        simpleCrossing.deactivate();
        Mockito.verify(horizontal, Mockito.times(1)).stopTraffic();
        Mockito.verify(vertical, Mockito.times(1)).startTraffic();
    }

}
