package crossings;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import trafficLights.SimplePedestrianTrafficLight;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.mockito.Mockito.*;

public class SimplePedestrianCrossingTest {

    @Test
    void t01testCrossingSequence() throws InterruptedException {
        SimplePedestrianTrafficLight horizontal = mock(SimplePedestrianTrafficLight.class);
        SimplePedestrianTrafficLight vertical = mock(SimplePedestrianTrafficLight.class);
        SimpleCrossing simpleCrossing = new SimpleCrossing();
        simpleCrossing.addPedestrianTrafficLightPair(horizontal, vertical);

        InOrder inOrder = inOrder(horizontal, vertical);
        CountDownLatch lock = new CountDownLatch(1);
        int millisSignalLength = 1;
        simpleCrossing.activate(millisSignalLength);
        lock.await(millisSignalLength * 50, TimeUnit.MILLISECONDS);
        simpleCrossing.deactivate();
        inOrder.verify(vertical, times(1)).stopTraffic();
        inOrder.verify(horizontal, times(1)).startTraffic();
        inOrder.verify(horizontal, times(1)).stopTraffic();
        inOrder.verify(vertical, times(1)).startTraffic();
    }

}
