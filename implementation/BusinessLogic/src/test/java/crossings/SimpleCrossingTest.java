package crossings;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import trafficLights.SimplePedestrianTrafficLight;
import trafficLights.SimpleStreetTrafficLight;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.mockito.Mockito.*;

public class SimpleCrossingTest {

    @Test
    void t01testCrossingSequence() throws InterruptedException {
        SimplePedestrianTrafficLight horizontal = mock(SimplePedestrianTrafficLight.class);
        SimplePedestrianTrafficLight vertical = mock(SimplePedestrianTrafficLight.class);
        SimpleStreetTrafficLight horizontalStreet = mock(SimpleStreetTrafficLight.class);
        SimpleStreetTrafficLight verticalStreet = mock(SimpleStreetTrafficLight.class);
        SimpleCrossing simpleCrossing = new SimpleCrossing();
        simpleCrossing.addPedestrianTrafficLightPair(horizontal, vertical);
        simpleCrossing.addStreetTrafficLightPair(horizontalStreet, verticalStreet);

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

    @Test
    void t02testCrossingSequence() throws InterruptedException {
        SimplePedestrianTrafficLight horizontalPedestrian = mock(SimplePedestrianTrafficLight.class);
        SimpleStreetTrafficLight horizontalStreet = mock(SimpleStreetTrafficLight.class);
        SimplePedestrianTrafficLight verticalPedestrian = mock(SimplePedestrianTrafficLight.class);
        SimpleStreetTrafficLight verticalStreet = mock(SimpleStreetTrafficLight.class);
        SimpleCrossing simpleCrossing = new SimpleCrossing();
        simpleCrossing.addPedestrianTrafficLightPair(horizontalPedestrian, verticalPedestrian);
        simpleCrossing.addStreetTrafficLightPair(horizontalStreet, verticalStreet);

        InOrder inOrder = inOrder(horizontalPedestrian, verticalPedestrian, horizontalStreet, verticalStreet);
        CountDownLatch lock = new CountDownLatch(1);
        int millisSignalLength = 1;
        simpleCrossing.activate(millisSignalLength);
        lock.await(millisSignalLength * 50, TimeUnit.MILLISECONDS);
        simpleCrossing.deactivate();
        inOrder.verify(verticalPedestrian, times(1)).stopTraffic();
        inOrder.verify(verticalStreet, times(1)).stopTraffic();
        inOrder.verify(horizontalPedestrian, times(1)).startTraffic();
        inOrder.verify(horizontalStreet, times(1)).startTraffic();
        inOrder.verify(horizontalPedestrian, times(1)).stopTraffic();
        inOrder.verify(horizontalStreet, times(1)).stopTraffic();
        inOrder.verify(verticalPedestrian, times(1)).startTraffic();
        inOrder.verify(verticalStreet, times(1)).startTraffic();
    }
}
