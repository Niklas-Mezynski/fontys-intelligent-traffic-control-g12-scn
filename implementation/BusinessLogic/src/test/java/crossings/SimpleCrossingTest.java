package crossings;

import crossingModes.SimpleCrossingMode;
import interfaces.CrossingMode;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import trafficLights.SimplePedestrianTrafficLight;
import trafficLights.SimpleStreetTrafficLight;

import static org.mockito.Mockito.*;

public class SimpleCrossingTest {

    @Test
    void t01testCrossingSequence() throws InterruptedException {
        SimplePedestrianTrafficLight horizontal = mock(SimplePedestrianTrafficLight.class);
        SimplePedestrianTrafficLight vertical = mock(SimplePedestrianTrafficLight.class);
        SimpleStreetTrafficLight horizontalStreet = mock(SimpleStreetTrafficLight.class);
        SimpleStreetTrafficLight verticalStreet = mock(SimpleStreetTrafficLight.class);
        CrossingMode newMode = new SimpleCrossingMode();
        SimpleCrossing simpleCrossing = new SimpleCrossing(newMode, horizontal, vertical, horizontalStreet, verticalStreet);

        InOrder inOrder = inOrder(horizontal, vertical, verticalStreet, horizontalStreet);
        simpleCrossing.stopAllVertical();
        simpleCrossing.startHorizontalStraight();
        inOrder.verify(verticalStreet).stopTraffic();
        inOrder.verify(vertical, times(2)).stopTraffic();
        inOrder.verify(horizontal).startTraffic();
        inOrder.verify(horizontalStreet).startTraffic();

        simpleCrossing.stopAllHorizontal();
        simpleCrossing.startVerticalStraight();
        inOrder.verify(horizontalStreet).stopTraffic();
        inOrder.verify(horizontal, times(2)).stopTraffic();
        inOrder.verify(vertical).startTraffic();
        inOrder.verify(verticalStreet).startTraffic();
    }
}
