package crossings;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;
import trafficLights.SimplePedestrianTrafficLight;

import static org.mockito.Mockito.*;

public class SimplePedestrianCrossingTest {

    @Test
    void t01testCrossingSequence() throws InterruptedException {
        SimplePedestrianTrafficLight horizontal = mock(SimplePedestrianTrafficLight.class);
        SimplePedestrianTrafficLight vertical = mock(SimplePedestrianTrafficLight.class);
        SimpleCrossing simpleCrossing = new SimpleCrossing();
        simpleCrossing.addPedestrianTrafficLightPair(horizontal, vertical);

        InOrder inOrder = inOrder(horizontal, vertical);

        simpleCrossing.activate(1);
        Thread.sleep(10);
        simpleCrossing.deactivate();
        inOrder.verify(vertical, times(1)).stopTraffic();
        inOrder.verify(horizontal, times(1)).startTraffic();
        inOrder.verify(horizontal, times(1)).stopTraffic();
        inOrder.verify(vertical, times(1)).startTraffic();
    }

}
