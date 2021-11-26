package crossings;

import org.junit.jupiter.api.Disabled;
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
        SimpleCrossing simpleCrossing = new SimpleCrossing(horizontal, vertical, horizontalStreet, verticalStreet);

        InOrder inOrder = inOrder(horizontal, vertical, verticalStreet, horizontalStreet);
        simpleCrossing.startHorizontalTrafficLights();
        inOrder.verify(verticalStreet).stopTraffic();
        inOrder.verify(vertical, times(2)).stopTraffic();
        inOrder.verify(horizontal).startTraffic();
        inOrder.verify(horizontalStreet).startTraffic();

        simpleCrossing.startVerticalTrafficLights();
        inOrder.verify(horizontalStreet).stopTraffic();
        inOrder.verify(horizontal, times(2)).stopTraffic();
        inOrder.verify(vertical).startTraffic();
        inOrder.verify(verticalStreet).startTraffic();
    }
}
