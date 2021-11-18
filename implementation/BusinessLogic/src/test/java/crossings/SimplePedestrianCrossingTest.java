package crossings;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;
import trafficLights.SimplePedestrianTrafficLight;

public class SimplePedestrianCrossingTest {

    @Test
    void t01() throws InterruptedException {
        SimplePedestrianTrafficLight horizontal = Mockito.mock(SimplePedestrianTrafficLight.class);
        SimplePedestrianTrafficLight vertical = Mockito.mock(SimplePedestrianTrafficLight.class);
        SimpleCrossing simpleCrossing = new SimpleCrossing();
        simpleCrossing.addPedestrianTrafficLightPair(horizontal, vertical);

        InOrder inOrder = Mockito.inOrder(horizontal, vertical);

        simpleCrossing.activate(1);
        inOrder.verify(vertical, Mockito.times(1)).stopTraffic();
        inOrder.verify(horizontal, Mockito.times(1)).startTraffic();
        inOrder.verify(horizontal, Mockito.times(1)).stopTraffic();
        inOrder.verify(vertical, Mockito.times(1)).startTraffic();
        simpleCrossing.deactivate();
    }

}
