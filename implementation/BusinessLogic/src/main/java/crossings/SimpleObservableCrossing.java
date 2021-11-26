package crossings;

import interfaces.*;

import java.util.Timer;
import java.util.TimerTask;

public class SimpleObservableCrossing extends SimpleCrossing implements ObservableCrossing {
    public SimpleObservableCrossing(PedestrianTrafficLight horizontalPedestrianTrafficLight, PedestrianTrafficLight verticalPedestrianTrafficLight, StreetTrafficLight horizontalStraight, StreetTrafficLight verticalStraight) {
        super(horizontalPedestrianTrafficLight, verticalPedestrianTrafficLight, horizontalStraight, verticalStraight);
    }

    @Override
    public void addHorizontalPedestrianLightObserver(LightObserver observer) {
        super.horizontalPedestrianTrafficLight.addLightObserver(observer);
    }

    @Override
    public void addVerticalPedestrianLightObserver(LightObserver observer) {
        super.verticalPedestrianTrafficLight.addLightObserver(observer);
    }

    @Override
    public void addHorizontalStreetLightObserver(LightObserver observer) {
        super.horizontalStreetTrafficLightStraight.addLightObserver(observer);
    }

    @Override
    public void addVerticalStreetLightObserver(LightObserver observer) {
        super.verticalStreetTrafficLightStraight.addLightObserver(observer);
    }

    @Override
    public void removeHorizontalPedestrianLightObserver(LightObserver observer) {
        super.horizontalPedestrianTrafficLight.removeLightObserver(observer);
    }

    @Override
    public void removeVerticalPedestrianLightObserver(LightObserver observer) {
        super.verticalPedestrianTrafficLight.removeLightObserver(observer);
    }

    @Override
    public void removeHorizontalStreetLightObserver(LightObserver observer) {
        super.horizontalStreetTrafficLightStraight.removeLightObserver(observer);
    }

    @Override
    public void removeVerticalStreetLightObserver(LightObserver observer) {
        super.verticalStreetTrafficLightStraight.removeLightObserver(observer);
    }
}
